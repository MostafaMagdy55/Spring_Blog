package com.spring.blog.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {
    private String SECRET_KEY = "secret";
    public String generateToken(Authentication authentication)
    {
        User user= (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

    }


    public boolean validateToken(String jwt)
    {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);
        return  true;
    }

    public String getUsernameFromJwt (String jwt)
    {
        Claims claims=Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();

    }

}
