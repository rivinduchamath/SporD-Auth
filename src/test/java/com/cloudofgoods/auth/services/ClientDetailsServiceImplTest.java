//package com.cloudofgoods.auth.services;
//
//import com.cloudofgoods.auth.dto.ClientDTO;
//import com.cloudofgoods.auth.exception.SystemWarningException;
//import com.cloudofgoods.auth.service.ClientDetailService;
//import com.cloudofgoods.auth.service.impl.UserDetailServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//public class ClientDetailsServiceImplTest {
//
//    @Bean
//    @LoadBalanced
//    RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//    static InMemoryDaoImpl inMemoryDao = null;
//    static ApplicationContext applicationContext = null;
//
//    @BeforeClass
//    // Method 1
//    public static void setup()
//    {
//        // Creating application context instance
//        applicationContext
//                = new ClassPathXmlApplicationContext(
//                "application-security.xml");
//
//        // Getting user details service configured in
//        // configuration
//        inMemoryDao = applicationContext.getBean(
//                InMemoryDaoImpl.class);
//    }
//    @Test
//    public void saveClient() {
//
//        // details service
//        UserDetails userDetails
//                = inMemoryDao.loadUserByUsername(
//                "Chamath2");
//        Authentication authToken
//                = new UsernamePasswordAuthenticationToken(
//                userDetails.getUsername(),
//                userDetails.getPassword(),
//                userDetails.getAuthorities());
//        SecurityContextHolder.getContext()
//                .setAuthentication(authToken);
//        ClientDetailService service
//                = (ClientDetailService)applicationContext.getBean(
//                "demoService");
//
//        ClientDTO clientDTO = new ClientDTO();
//        clientDTO.setClientId("Test");
//        clientDTO.setClientSecret("1234");
//        clientDTO.setWebServerRedirectUri("http://localhost:8080/login");
//        clientDTO.setScope("READ");
//        clientDTO.setAccessTokenValidity(100);
//        clientDTO.setRefreshTokenValidity(100);
//        clientDTO.setResourceIds("inventory,payment");
//        clientDTO.setAuthorizedGrantTypes("authorization_code,password,refresh_token,implicit");
//        clientDTO.setAuthorities("");
//        clientDTO.setAutoApprove("");
//        service.saveClient(clientDTO);
//
//
//     /*   Exception exception = assertThrows(SystemWarningException.class, () -> {
//            clientDetailService.saveClient(clientDTO);
//        });
//*/
//  //      assertEquals("", exception.getMessage());
//    }
//}
