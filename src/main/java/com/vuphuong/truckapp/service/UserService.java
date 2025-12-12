package com.vuphuong.truckapp.service;

import com.vuphuong.truckapp.entity.User;
import com.vuphuong.truckapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger =  LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.warn("Không tìm thấy người dùng: {}", username);
            return null;
        }
        if (!passwordEncoder.matches(password,user.getPassword())){
            logger.warn("Sai mật khẩu cho người dùng: {}", username);
            return null;
        }
        logger.info("Đăng nhập thành công: {}", username);
        return user;
    }
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(true);
        user.setRole("admin");
        userRepository.save(user);
    }
}
