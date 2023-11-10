package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.controller.response.ResponseHandler;
import com.cloudofgoods.auth.service.PermissionDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/permission")
public class PermissionController {
    final PermissionDetailsService permissionDetailsService;

    @PostMapping ("${server.servlet.createPermission}/{permissionName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> createPermission(@PathVariable(name = "permissionName") String permissionName) {
        try {
            String s = permissionDetailsService.savePermission (permissionName);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, s);
        } catch (Exception e) {
            log.error ("LOG::Permission " + permissionName + " PermissionController createPermission Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @PostMapping ("${server.servlet.deletePermission}/{permissionId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> removePermission(@PathVariable(name = "permissionId") Integer permissionId) {
        log.info ("LOG:: PermissionController removePermission");
        try {
            boolean delete = permissionDetailsService.deletePermissionById (permissionId);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, delete);
        } catch (Exception e) {
            log.error ("LOG::Permission " + permissionId + " PermissionController removePermission Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }
}
