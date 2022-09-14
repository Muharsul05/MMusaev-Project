package ru.musaev.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import ru.musaev.dataObjects.User;
import ru.musaev.dataObjects.UserInfo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class TokenServiceGenerator implements TokenService {

    @Override
    public String generateToken(User user) {
        Instant expirationTime = Instant.now().plus(1, ChronoUnit.HOURS);
        Date expirationDate = Date.from(expirationTime);

        String compactTokenString = Jwts.builder()
                .claim("id", user.getId())
                .claim("sub", user.getUsername())
                .claim("admin", user.isAdmin())
                .setExpiration(expirationDate)
                .compact();
        return "Bearer " + compactTokenString;
    }

    @Override
    public UserInfo parseToken(String token) {
        Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .build()
                .parseClaimsJws(token);

        String username = jwsClaims.getBody().getSubject();
        Integer userId = jwsClaims.getBody().get("id", Integer.class);
        boolean isAdmin = jwsClaims.getBody().get("admin", Boolean.class);

        return new UserInfo(userId, username, isAdmin);
    }
}
