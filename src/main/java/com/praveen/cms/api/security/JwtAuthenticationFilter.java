package com.praveen.cms.api.security;

import com.praveen.cms.api.constant.SecurityConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    private final Logger logger = LogManager.getLogger(getClass().getName());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("\n\n :::Security Step 3::: for Authentication "+getClass().getName() + "\n\n");

        String jwt = getJwtFromRequest(request);
        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        if(jwt != null){
            if(tokenProvider.validateToken(jwt)){
                String email = tokenProvider.getEmailIdFromToken(jwt);
                UserDetails userDetails = jwtUserDetailService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authentication = tokenProvider.getAuthentication(jwt, SecurityContextHolder.getContext().getAuthentication(), userDetails);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  //this line is not needed
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Success Done");
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request){

        String bearerToken = request.getHeader(SecurityConstants.HEADER_STRING);
        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith(SecurityConstants.TOKEN_PREFIX))
            return bearerToken.substring(7);
        else
            return null;
    }
}
