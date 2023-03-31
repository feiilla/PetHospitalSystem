package com.example.pethospital.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtRequestFilter extends BasicAuthenticationFilter {
    public JwtRequestFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        JSONObject json = new JSONObject();

        if(header == null || !header.startsWith("Bearer ")){
            chain.doFilter(request, response);
            //json.put("code", 403);
            //json.put("msg", "no token");
            //response.setCharacterEncoding("UTF-8");
            //response.getWriter().write(JSON.toJSONString(json));
            return;
        }

        try{
            String userName = JWTUtil.validate(header);
            UsernamePasswordAuthenticationToken authentication = null;
            if(userName != null && !userName.equals("")){
                authentication = new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }
        catch (ExpiredJwtException e){
            json.put("code", 403);
            json.put("msg", "token expired");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(json));
        }
        catch (UnsupportedJwtException e){
            json.put("code", 403);
            json.put("msg", "token 格式错误");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(json));
        }
        catch (SignatureException e){
            json.put("code", 403);
            json.put("msg", "token 签名失败");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(json));
        }
        catch (Exception e){
            json.put("code", 403);
            json.put("msg", "invalid token");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(json));
        }
    }
}
