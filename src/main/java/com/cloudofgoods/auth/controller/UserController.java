package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.controller.response.ResponseHandler;
import com.cloudofgoods.auth.dto.AccountLockUnlockDTO;
import com.cloudofgoods.auth.dto.CustomUserRoleDTO;
import com.cloudofgoods.auth.dto.UserDTO;
import com.cloudofgoods.auth.dto.UserRegisterDTO;
import com.cloudofgoods.auth.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserDetailService userDetailService;

    @PostMapping( "${server.servlet.registration}")
    @Description("Register Customer To the system without role or authentication")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Object> registerCustomer(@RequestBody UserRegisterDTO registrationRequest) {
        log.info ("LOG::User " + registrationRequest.getUsername () + " Register");
        UserRegisterDTO userRegisterDTO = null;
        try {
            userRegisterDTO = userDetailService.registerUser (registrationRequest);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, userRegisterDTO);
        } catch (Exception e) {
            log.error ("LOG::User " + registrationRequest.getUsername () + " Register Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @PostMapping( "${server.servlet.accountLock}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> lockUserAccount(@RequestBody AccountLockUnlockDTO accountLockUnlockDTO) {
        log.info ("LOG::UserController lockUserAccount ");
        try {
            String lockOrUnlockUserAccount = userDetailService.lockOrUnlockUserAccount (accountLockUnlockDTO);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, lockOrUnlockUserAccount);
        } catch (Exception e) {
            log.error ("LOG::User " + accountLockUnlockDTO.getEmail () + " Lock Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @GetMapping( value = "${server.servlet.roleRemoveFromUser}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> removeRoleFromUser(@RequestBody CustomUserRoleDTO customUserRole) {
        log.info ("LOG::UserController removeRoleFromUser ");
        try {
            String removeRoleFromUser = userDetailService.removeRoleFromUser (customUserRole.getUserName (), customUserRole.getRole ());
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, removeRoleFromUser);
        } catch (Exception e) {
            log.error ("LOG::User " + customUserRole.getUserName () + " Remove Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @GetMapping( value = "${server.servlet.getAllUsers}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> getAllUsersWithPagination(HttpServletRequest request) {
        log.info ("LOG::UserController revokeToken ");
        try {
            String startNumber = request.getHeader ("startNumber");
            String sizeNumber = request.getHeader ("sizeNumber");
            if (!sizeNumber.equals ("") || !startNumber.equals ("")) {
                List <UserDTO> allUsersWithPagination = userDetailService.findAllUsersWithPagination (startNumber, sizeNumber);
                return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, allUsersWithPagination);
            }else {
                return ResponseHandler.responseBuilder ("Fail", "4000", HttpStatus.BAD_REQUEST, null);
            }
        } catch (Exception e) {
            log.error ("LOG::User All Get");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

    @GetMapping( value = "${server.servlet.getByUserName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> getUser(HttpServletRequest request) {
        log.info ("LOG::UserController getUser ");
        try {
            String email = request.getHeader ("userName");
            if (!email.equals ("")) {
                Optional <UserDTO> userById = userDetailService.getUserByEmail (email);
                return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, userById);
            }else {
                return ResponseHandler.responseBuilder ("Fail", "4000", HttpStatus.BAD_REQUEST, null);
            }
        } catch (Exception e) {
            log.error ("LOG::User All Get");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }

}
