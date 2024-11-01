package com.douglas.flixzone.service;

import com.douglas.flixzone.dto.EpisodeDTO;
import com.douglas.flixzone.dto.SerieDTO;
import com.douglas.flixzone.model.Serie;
import com.douglas.flixzone.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> getAllSeries(){
        return convertData(repository.findAll());
    }

    public SerieDTO getByID(Long id){
        return new SerieDTO(repository.findById(id).orElseThrow());
    }

    public List<SerieDTO> getTop5Series(){
        return convertData((repository.findTop5ByOrderByAvaliacaoDesc()));
    }

    public List<SerieDTO> getRelease(){
        return convertData(repository.latestRelease());
    }

    public List<EpisodeDTO> getAllSeasons(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if(serie.isPresent()) {
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodeDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                    .collect(Collectors.toList());

        }
        return List.of();
    }

    public List<EpisodeDTO> getSeasonByNumber(Long id, Integer numero){
        return repository.obterEpisodiosPorTemporada(id, numero).stream()
                .map(e -> new EpisodeDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    private List<SerieDTO> convertData(List<Serie> series){
        return series.stream().map(SerieDTO::new).collect(Collectors.toList());
    }

}
