//package com.vuphuong.truckapp.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//@Component
//public class AuthFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        HttpSession session = req.getSession(false);
//        String path = req.getRequestURI();
//        if (path.startsWith("/login") || path.startsWith("/register")) {
//            filterChain.doFilter(req, res);
//            return;
//        }
//        if (session == null || session.getAttribute("user") == null) {
//            res.sendRedirect("/login");
//            return;
//        }
//        filterChain.doFilter(req, res);
//    }
//}
