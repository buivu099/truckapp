//package com.vuphuong.truckapp.config;
//
//import com.vuphuong.truckapp.interceptor.AuthInterceptor;
//import com.vuphuong.truckapp.interceptor.RoleInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//        @Override
//   public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/access-denied", "/account_blocked");
//        registry.addInterceptor(new RoleInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/access-denied", "/account_blocked");
//    }
//}
