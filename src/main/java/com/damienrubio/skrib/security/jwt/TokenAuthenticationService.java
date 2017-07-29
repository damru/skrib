package com.damienrubio.skrib.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by damien on 29/01/2017.
 */
@Service
public class TokenAuthenticationService {

    @Value("${skrib.sha256}")
    private String SHA;

    private String TOKEN_HEADER_NAME = "Authorization";

    private String TOKEN_PREFIX = "Bearer";

    private long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 10; // 10 days

    public void addAuthentication(HttpServletResponse response, String username) {
        // We generate a token now.
        String JWT = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SHA).compact();
        response.addHeader(TOKEN_HEADER_NAME, TOKEN_PREFIX + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER_NAME);
        if (token != null) {
            // parse the token.
            String username = Jwts.parser().setSigningKey(SHA).parseClaimsJws(token).getBody().getSubject();
            if (username != null) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }

}
