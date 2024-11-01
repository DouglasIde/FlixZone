package com.douglas.flixzone.controller;

import com.douglas.flixzone.dto.EpisodeDTO;
import com.douglas.flixzone.dto.SerieDTO;
import com.douglas.flixzone.model.Serie;
import com.douglas.flixzone.service.SerieService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import com.douglas.flixzone.repository.SerieRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries(){
        return service.getAllSeries();
    }

    @GetMapping("/series/top5")
    public List<SerieDTO> top5Series(){
        return service.getTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> lancamentos(){
        return service.getRelease();
    }

    @GetMapping("/{id}")
    public SerieDTO getByID(@PathVariable Long id){
        return service.getByID(id);
    }

    @GetMapping("/{id}/temporadas/all")
    public List<EpisodeDTO> getAllSeasons(@PathVariable Long id){
        return service.getAllSeasons(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodeDTO> getSeasonByNumber(@PathVariable Long id, @PathVariable Integer numero){
        return service.getSeasonByNumber(id, numero);
    }
}