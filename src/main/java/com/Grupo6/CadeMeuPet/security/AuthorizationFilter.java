package com.Grupo6.CadeMeuPet.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import static com.Grupo6.CadeMeuPet.security.SecurityConstants.HEADER_NAME;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_NAME);

        if(header == null){
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req,res);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request){
        String token = request.getHeader(HEADER_NAME);

        if(token != null){
            Claims user = Jwts.parser()
                    .parseClaimsJws(token)
                    .getBody();
            if(user != null) {
                return new UsernamePasswordAuthenticationToken(user, null);
            }else{
                return null;
            }
        }
        return null;
    }
}
