package com.client.prueba.controller;

import com.client.prueba.service.DatosService;
import com.google.gson.JsonArray;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private DatosService service;

    @Operation(
            summary = "Retorna numero de heroes tiene el catalogo",
            description = "Retorna todo el catalogo de heroes sirve extraer su id.",
            tags = "Heroes")
    @GetMapping("/heroes")
    public ResponseEntity<JsonArray> tipoHeroeUser(){

        return ResponseEntity.ok(this.service.extractionDatos().get("data").getAsJsonObject().get("results").getAsJsonArray());
    }

    @Operation(
            summary = "Retorna information de heroes por id",
            description = "Retorna todo el catalogo de heroes por id.",
            tags =  "heoreId" )
    @GetMapping("/heroesId")
    public ResponseEntity<JsonArray> heroesId(@RequestParam Integer idCharacter){

        return ResponseEntity.ok(this.service.datosId(idCharacter).get("data").getAsJsonObject().get("results").getAsJsonArray());
    }



}
