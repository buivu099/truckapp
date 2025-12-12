package com.vuphuong.truckapp.controller;

import com.vuphuong.truckapp.entity.AuditLog;
import com.vuphuong.truckapp.repository.AuditLogRepository;
import com.vuphuong.truckapp.service.AuditLogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuditLogController {
    private final AuditLogService auditLogService;
    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }
    public String viewAuditLog(Model model) {
        model.addAttribute("logs", auditLogService.findAllLog());
        return "audit_log";
    }
}
