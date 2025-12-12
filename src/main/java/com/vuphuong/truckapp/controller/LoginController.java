package com.vuphuong.truckapp.controller;

import com.vuphuong.truckapp.entity.User;
import com.vuphuong.truckapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public LoginController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    //    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
//        User user;
//        user = userService.login(username, password);
//        if (user != null){
//            session.setAttribute("user", user);
//            return "redirect:/home";
//        }
//        model.addAttribute("error","invalid username or password");
//        return "login";
//    }
    @GetMapping("/account_blocked")
    public String accountBlocked() {
        return "account_blocked";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


    @PostMapping("/login")
    public String dologin(@RequestParam String username,
                          @RequestParam String password,
                          HttpServletRequest request) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, password);

        try {
            Authentication authentication = authenticationManager.authenticate(authToken);

            // ✅ Đặt authentication vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // ✅ Tạo session để lưu trạng thái đăng nhập
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            session.setAttribute("user", authentication.getPrincipal());

            return "redirect:/home"; // hoặc bất kỳ trang nào sau đăng nhập
        } catch (AuthenticationException e) {
            return "redirect:/login?error=true";
        }
    }

}