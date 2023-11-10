package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.controller.response.ResponseHandler;
import com.cloudofgoods.auth.dto.ClientDTO;
import com.cloudofgoods.auth.service.ClientDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    final ClientDetailService clientDetailService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping( value = "${server.servlet.createClient}")
    public ResponseEntity <Object> registerClient(@RequestBody ClientDTO clientDTO) {
        log.info ("LOG:: ClientController registerClient");
        try {
            ClientDTO clientDTO1 = clientDetailService.saveClient (clientDTO);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, clientDTO1);
        } catch (Exception e) {
            log.error ("LOG::Client " + clientDTO.getClientId () + " ClientController registerClient Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }
    @GetMapping( value = "${server.servlet.blockClient}")
    public ResponseEntity <Object> blockClient(HttpServletRequest request) {
        log.info ("LOG:: ClientController blockClient");
        String clientId = request.getHeader ("clientId");
        try {
            String s = clientDetailService.blockClient (clientId);
            return ResponseHandler.responseBuilder ("Success", "2000", HttpStatus.OK, s);
        } catch (Exception e) {
            log.error ("LOG::Client " + clientId + " ClientController blockClient Failed");
            return ResponseHandler.responseBuilder ("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage ());
        }
    }
}
