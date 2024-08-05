package com.example.hotelbooking.config;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretGenerator {

    public static void main(String[] args) {
        byte[] bytes = new byte[32]; // Adjust the byte size as per your security needs
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        String jwtSecret = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Generated JWT Secret: " + jwtSecret);
    }
}