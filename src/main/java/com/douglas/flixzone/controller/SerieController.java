package com.douglas.flixzone.controller;

import org.springframework.web.bind.annotation.RestController;

import com.douglas.flixzone.model.Serie;
import com.douglas.flixzone.repository.SerieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SerieController {

    @Autowired
    private SerieRepository repository;
    
    @GetMapping("/series")
    public List<Serie> obterSeries(){
        return repository.findAll();
    }
}