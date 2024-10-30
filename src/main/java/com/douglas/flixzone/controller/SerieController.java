package com.douglas.flixzone.controller;

import org.springframework.web.bind.annotation.RestController;

import com.douglas.flixzone.model.DataSeries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SerieController {
    
    @GetMapping("/series")
    public List<DataSeries> getSeries(@RequestParam String param) {
        return "Aqui vão as séries para o parâmetro " + param;
    }
    
}