package com.praveen.cms.api.security;

import com.praveen.cms.api.constant.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {


    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//        String authorities = userPrincipal.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userPrincipal.getEmail())
                .setIssuedAt(new Date())
                //.setIssuer(userPrincipal.getUserType().toString())
               // .claim("AUTHORITIES_KEY", authorities)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    public String getEmailIdFromToken(String token) {
          Claims claims= Jwts.parser()
                            .setSigningKey(SecurityConstants.SECRET)
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject();
    }

    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SecurityConstants.SECRET);

        final Claims claimsJws = jwtParser.parseClaimsJws(token).getBody();

        String user = claimsJws.getSubject();  //email should be saved as subject
        final Collection<SimpleGrantedAuthority> authorities =new HashSet<>();
//                Arrays.stream(claimsJws.get("AUTHORITIES_KEY").toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(user, "", authorities);
    }

    public boolean validateToken(String token){
        Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                        .parseClaimsJws(token);
        return true;
    }

}
