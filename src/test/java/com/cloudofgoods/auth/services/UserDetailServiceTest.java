//package com.cloudofgoods.auth.services;
//
//import com.cloudofgoods.auth.dto.AccountLockUnlockDTO;
//import com.cloudofgoods.auth.dto.UserRegisterDTO;
//import com.cloudofgoods.auth.entity.Role;
//import com.cloudofgoods.auth.service.UserDetailService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@Slf4j
//@SpringBootTest
//@AutoConfigureWebTestClient
//public class UserDetailServiceTest {
//
//    @Autowired
//    private UserDetailService userDetailService;
//
//    @Test
//    public void findAllUsers(){
//        userDetailService.findAllUsers();
//    }
//
//    @Test
//    public void getUserById(){
//        userDetailService.getUserById("");
//    }
//
//    @Test
//    public void removeRoleFromUser(){
//        Role role = new Role();
//        String userName ="";
//        userDetailService.removeRoleFromUser( userName,  role);
//    }
//
//    @Test
//    public void lockOrUnlockUserAccount(){
//        AccountLockUnlockDTO accountLockUnlockDTO = new AccountLockUnlockDTO();
//        userDetailService.lockOrUnlockUserAccount(accountLockUnlockDTO);
//    }
//
//    @Test
//    public void registerUser(){
//        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
//        userDetailService.registerUser(userRegisterDTO);
//
//    }
//}
