package com.douglas.flixzone.service;

import com.douglas.flixzone.dto.SerieDTO;
import com.douglas.flixzone.model.Serie;
import com.douglas.flixzone.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> getAllSeries(){
        List<Serie> series = repository.findAll();
        return series.stream().map(SerieDTO::new).collect(Collectors.toList());
    }
}
