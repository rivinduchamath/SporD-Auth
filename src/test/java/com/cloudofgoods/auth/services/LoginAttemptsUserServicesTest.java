//package com.cloudofgoods.auth.services;
//
//import com.cloudofgoods.auth.dto.UserRegisterDTO;
//import com.cloudofgoods.auth.entity.User;
//import com.cloudofgoods.auth.service.LoginAttemptsUserServicesBO;
//import com.cloudofgoods.auth.service.UserDetailService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class LoginAttemptsUserServicesTest {
//    @Autowired
//    private UserDetailService userDetailService;
//    @Autowired
//    private LoginAttemptsUserServicesBO loginAttemptsUserServicesBO;
//
//    @Test
//    public void registerUser() {
//        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
//        userDetailService.registerUser(userRegisterDTO);
//
//    }
//
//    @Test
//    public void increaseFailedAttempts() {
//        User user = new User();
//        loginAttemptsUserServicesBO.increaseFailedAttempts(user);
//    }
//
//    @Test
//    public void lockUser() {
//        User user = new User();
//        loginAttemptsUserServicesBO.lock(user);
//    }
//
//    @Test
//    public void findByUsername() {
//        loginAttemptsUserServicesBO.findByUsername("");
//    }
//
//    @Test
//    public void updateAuthenticationType() {
//        User user = new User();
//        loginAttemptsUserServicesBO.updateAuthenticationType(user);
//    }
//}
