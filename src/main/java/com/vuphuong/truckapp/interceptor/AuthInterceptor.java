//package com.vuphuong.truckapp.interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//@Component
//public class AuthInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession(false);
//        String uri = request.getRequestURI();
//        System.out.println("uri:"+uri);
//        if (uri.startsWith("/login") || uri.startsWith("/register")){
//            return true;
//        }
//        if (session.getAttribute("user") == null || session == null){
//            response.sendRedirect("/login");
//            return false;
//        }
//        return true;
//    }
//}
