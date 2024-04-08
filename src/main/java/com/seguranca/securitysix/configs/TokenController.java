package com.seguranca.securitysix.configs;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    JwtEncoder encoder;

    @PostMapping("/token")
    public Map<String, Object> token(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        String username = authentication.getName();
        Instant expiration = now.plusSeconds(expiry);

         String scope = authentication.getAuthorities().stream()
                 .map(GrantedAuthority::getAuthority)
                 .collect(Collectors.joining(" "));
         JwtClaimsSet claims = JwtClaimsSet.builder()
                 .issuer("self")
                 .issuedAt(now)
                 .expiresAt(now.plusSeconds(expiry))
                 .subject(authentication.getName())
                 .claim("scope", scope)
                 .build();
         
        Map<String, Object> tokenInfo = new HashMap<>();
        tokenInfo.put("username", username);
        tokenInfo.put("expiration", expiration.toString());
        tokenInfo.put("token",this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());

        return tokenInfo;
    }

}