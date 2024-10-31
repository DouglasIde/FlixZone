package com.douglas.flixzone.dto;

import com.douglas.flixzone.model.Serie;

public record SerieDTO(Long id, String titulo, Integer totalTemporadas,
                       String avaliacao, String genero, String atores,
                       String posters, String sinopse) {

    public SerieDTO(Serie serie) {
        this(serie.getId(), serie.getTitulo(), serie.getTotalTemporadas(),
                serie.getAvaliacao().toString(), serie.getGenero().toString(),
                serie.getAtores(), serie.getPosters(), "");
    }

}
