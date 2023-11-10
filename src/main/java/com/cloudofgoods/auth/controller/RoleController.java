package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.controller.response.ResponseHandler;
import com.cloudofgoods.auth.dto.CustomRolePermissionDTO;
import com.cloudofgoods.auth.service.RoleDetailsService;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Slf4j
public class RoleController {

    private final RoleDetailsService roleDetailsService;

    @PostMapping( "${server.servlet.createRole}/{roleName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> createRole(@PathVariable(name = "roleName") String roleName) {
        try {
            String role = roleDetailsService.createRole (roleName);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, role);
        } catch (Exception e) {
            log.error ("LOG::Role " + roleName + " RoleController createRole Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @DeleteMapping ("${server.servlet.removeRole}/{roleName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> removeRole(@PathVariable(name = "roleName") String roleName) {
        try {
            int i = roleDetailsService.removeRole (roleName);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, i);
        } catch (Exception e) {
            log.error ("LOG::Role " + roleName + " RoleController removeRole Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @PostMapping( "${server.servlet.assignRolePermission}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> assignPermissionToRole(@RequestBody CustomRolePermissionDTO customRolePermission) {
        try {
            String s = roleDetailsService.assignPermissionToRole (customRolePermission.getRoleName (), customRolePermission.getPermission ());
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, s);
        } catch (Exception e) {
            log.error ("LOG::Role " + customRolePermission.getPermission () + " RoleController assignPermissionToRole Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @GetMapping( "${server.servlet.removeRolePermission}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> removePermissionFromRole(@RequestBody CustomRolePermissionDTO customRolePermission) {
        try {
            String s = roleDetailsService.removePermissionFromRole (customRolePermission.getRoleName (), customRolePermission.getPermission ());
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, s);
        } catch (Exception e) {
            log.error ("LOG::Role " + customRolePermission.getPermission () + " RoleController removePermissionFromRole Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }
}
