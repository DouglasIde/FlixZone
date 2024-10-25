package com.douglas.flixzone.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.flixzone.model.Series;

public interface SerieRepository extends JpaRepository<Series, Long>{
    Optional<Series> findByTituloContainingIgnoreCase(String titulo);

    List<Series> findBy
}
