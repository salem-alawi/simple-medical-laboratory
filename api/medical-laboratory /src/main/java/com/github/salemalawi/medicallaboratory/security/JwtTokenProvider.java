package com.github.salemalawi.medicallaboratory.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.salemalawi.medicallaboratory.model.User;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String AUTHORITIES_KEY = "roles";

    private final JwtProperties jwtProperties;

    private SecretKey secretKey;

    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        var secret = Base64.getEncoder().encodeToString(this.jwtProperties.getSecretKey().getBytes());
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public TokenBody createToken(User user) {
        Claims claims = Jwts.claims();
        TokenContent tokenContent = new TokenContent(user);
        claims.put(AUTHORITIES_KEY, tokenContent);


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, this.jwtProperties.getValidityInMs());
        Date validity = cal.getTime();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(validity)
                .signWith(this.secretKey, SignatureAlgorithm.HS256)
                .compact();

        return new TokenBody(token, "Bearer");
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(this.secretKey).build().parseClaimsJws(token).getBody();

        Map<String, Object> m = (Map<String, Object>) claims.get(AUTHORITIES_KEY);
        TokenContent tokenContent = mapper.convertValue(m, TokenContent.class);
        UserPrincipal principal = new UserPrincipal(tokenContent);
        return new UsernamePasswordAuthenticationToken(principal, token, principal.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts
                    .parserBuilder().setSigningKey(this.secretKey).build()
                    .parseClaimsJws(token);
            //  parseClaimsJws will check expiration date. No need do here.
            log.info("expiration date: {}", claims.getBody().getExpiration());
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token: {}", e.getMessage());
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }




}
