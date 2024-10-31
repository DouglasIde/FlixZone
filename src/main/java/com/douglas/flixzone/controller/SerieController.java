package com.douglas.flixzone.controller;

import com.douglas.flixzone.dto.SerieDTO;
import com.douglas.flixzone.model.Serie;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.flixzone.repository.SerieRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<SerieDTO> obterSeries(){
        List<Serie> series = repository.findAll();
        List<SerieDTO> seriesDTO = series.stream().map(SerieDTO::new).collect(Collectors.toList());
        return seriesDTO;
    }
}