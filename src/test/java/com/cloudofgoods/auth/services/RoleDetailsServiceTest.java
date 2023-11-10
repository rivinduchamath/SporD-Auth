//package com.cloudofgoods.auth.services;
//
//import com.cloudofgoods.auth.entity.Permission;
//import com.cloudofgoods.auth.service.RoleDetailsService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@Slf4j
//@SpringBootTest
//public class RoleDetailsServiceTest {
//
//    @Autowired
//    private RoleDetailsService roleDetailsService;
//
//    @Test
//    public void assignPermissionToRole() {
//        String roleName = "";
//        Permission permission = new Permission();
//        roleDetailsService.assignPermissionToRole(roleName, permission);
//    }
//
//    @Test
//    public void createRole() {
//        String roleName = "";
//        roleDetailsService.createRole(roleName);
//    }
//
//    @Test
//    public void removeRole() {
//        String roleName = "";
//        roleDetailsService.removeRole(roleName);
//    }
//
//    @Test
//    public void removePermissionFromRole() {
//        String roleName = "";
//        Permission permission = new Permission();
//        roleDetailsService.removePermissionFromRole(roleName, permission);
//    }
//}
