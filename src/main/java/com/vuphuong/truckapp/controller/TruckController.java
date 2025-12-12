package com.vuphuong.truckapp.controller;

import com.vuphuong.truckapp.entity.Truck;
import com.vuphuong.truckapp.entity.User;
import com.vuphuong.truckapp.repository.TruckRepositoty;
import com.vuphuong.truckapp.service.AuditLogService;
import com.vuphuong.truckapp.service.TruckService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TruckController {
    private final TruckService truckService;
    private final TruckRepositoty truckRepositoty;
    private final AuditLogService auditLogService;

    public TruckController(TruckService truckService, TruckRepositoty truckRepositoty, AuditLogService auditLogService) {
        this.truckService = truckService;
        this.truckRepositoty = truckRepositoty;
        this.auditLogService = auditLogService;
    }
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("user") == null) {
            return "truck";
        }
        model.addAttribute("trucks", truckRepositoty.findAll());
        return "truck";
    }
    @GetMapping("/truck/edit")
    public String showEditForm( Model model, @RequestParam Long id) {
        Truck truck = truckService.getTruckById(id);
        model.addAttribute("truck", truck);
        return "truck_edit";
    }
    @PostMapping("/truck/update")
    public String updateTruck(@ModelAttribute Truck truck, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        truckService.saveTruck(truck);
        auditLogService.logAction(user.getUsername(), "UPDATE TRUCK", "Cập nhật xe có licensePlate:"+ truck.getLicensePlate(), request.getRemoteAddr());
        return "redirect:/home";
    }
    @PostMapping("/truck/delete/{id}")
    public String deleteTruck(@PathVariable Long id,  HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        Truck truck = truckService.getTruckById(id);

        if (session.getAttribute("user") == null) {
            return "login";
        }
        truckService.deleteTruckByID(id);
        auditLogService.logAction(user.getUsername(),"Delete Truck", "Xóa xe có licenseplate:"+truck.getLicensePlate(),request.getRequestURI());
        return "redirect:/home";
    }
    @GetMapping("/truck/add")
    public String addTruck(Model model, HttpSession session) {
        if(session.getAttribute("user") == null) {
            return "login";
        }
        model.addAttribute("truck", new Truck());
        return "truck_add";
    }
    @PostMapping("/addtruck")
    public String addOneTruck(@ModelAttribute Truck truck, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        truckService.saveTruck(truck);
        auditLogService.logAction(user.getUsername(),"Add 01 xe taỉ", "Thêm xe có licensePlate:" +truck.getLicensePlate(),request.getRemoteAddr());
        return "redirect:/home";
    }
}
