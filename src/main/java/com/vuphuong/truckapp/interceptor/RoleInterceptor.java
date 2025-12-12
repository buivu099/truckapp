//package com.vuphuong.truckapp.interceptor;
//
//import com.vuphuong.truckapp.entity.User;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//public class RoleInterceptor implements HandlerInterceptor {
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String path = request.getRequestURI();
//        if (path.startsWith("/login") || path.startsWith("/register")){
//            return true;
//        }
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            User user = (User) session.getAttribute("user");
//            if (user != null) {
//                String role = user.getRole();
//                if (user.getStatus()==false) {
//                    response.sendRedirect("/account_blocked");
//                    return false;
//                }
//                if (role.equals("admin")) {
//                    return true;
//                }
//                if (request.getMethod().equalsIgnoreCase("GET")) {
//                    return true;
//
//                }
//                response.sendRedirect("/access-denied");
//                return false;
//            }
//        }
//        response.sendRedirect("/login");
//        return false;
//    }
//
//}
