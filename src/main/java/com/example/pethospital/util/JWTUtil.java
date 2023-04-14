package com.example.pethospital.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.pethospital.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static final int EXPIRATION_TIME = 12 * 3600 * 1000;
    private static final String SECRET = "petHospital";

    public static String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Map<String, Object> header = new HashMap<>();
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        return JWT.create()
                .withHeader(header)
                .withSubject(user.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }

    public static String validate(String token){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        token = token.substring(7);
        return verifier.verify(token).getSubject();
    }
}
