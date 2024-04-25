package com.client.prueba.service;

import com.client.prueba.client_marvel.ApiMarvel;
import com.client.prueba.service.impl.IDatosService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosService implements IDatosService {


    @Autowired
    private ApiMarvel apiMarvel;

    private Gson conver = new Gson().newBuilder().create();



    @Override
    public JsonObject extractionDatos(){
        String datosConvert = conver.toJson(apiMarvel.getMarvel());
        return conver.fromJson(datosConvert, JsonObject.class);

    }


    @Override
    public JsonObject datosId(int idCharacter){
        String datosConvert = conver.toJson(apiMarvel.getMarvelId(idCharacter));
        return conver.fromJson(datosConvert, JsonObject.class);

    }

}
