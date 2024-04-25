package com.client.prueba.client_marvel;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class ApiMarvel {

    private final RestClient restClient = RestClient.create();
    private static final String API_KEY = "41930828f30b86ac50eb4c06b7d6127b";
    private static final String PRIVATE_KEY = "08b4770ebb49db175159c2ea5797d3231ae13c03";

    public Object getMarvel(){
        String ts = String.valueOf(System.currentTimeMillis());
        String hash = md5(ts + PRIVATE_KEY + API_KEY);

      return  this.restClient.get()
                .uri("https://gateway.marvel.com:443/v1/public/characters"+ "?ts=" + ts + "&apikey=" + API_KEY + "&hash="+hash)
                .retrieve()
                .body(Object.class);
    }

    public Object getMarvelId(int idCharacter){
        String ts = String.valueOf(System.currentTimeMillis());
        String hash = md5(ts + PRIVATE_KEY + API_KEY);

        return  this.restClient.get()
                .uri("https://gateway.marvel.com:443/v1/public/characters/" + idCharacter + "?ts=" + ts + "&apikey=" + API_KEY + "&hash="+hash)
                .retrieve()
                .body(Object.class);
    }

    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
