package com.eats.restaurant.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KeycloakLogoutHandler {

    private static final Logger logger= LoggerFactory.getLogger(KeycloakLogoutHandler.class);
    private final RestTemplate restTemplate;
    public KeycloakLogoutHandler(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth){


    }

    private void logoutFromKeyCloak(OidcUser user){
        String endSessionEndpoint=user.getIssuer()+"/protocol/openid-connect/logout";
        UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(endSessionEndpoint).
                queryParam("id_token_hint",user.getIdToken().getTokenValue());
        ResponseEntity<String> logoutResponse=restTemplate.getForEntity(builder.toUriString(),String.class);
        if(logoutResponse.getStatusCode().is2xxSuccessful()){
            logger.info("Successfull logged out from keycloak");
        }
        else{
            logger.error("Could not propagate logout to keycloak");
        }



    }
}
