package com.example.pethospital.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    private static final String SECRET = "petHospital";

    public static String MD5Encrypt(String password){
        String salt = password + SECRET;
        String md5 = DigestUtils.md5DigestAsHex(salt.getBytes());
        return md5;
    }
}
