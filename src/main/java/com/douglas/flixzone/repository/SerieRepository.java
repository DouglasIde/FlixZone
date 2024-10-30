package com.douglas.flixzone.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus.Series;

import com.douglas.flixzone.model.Category;
import com.douglas.flixzone.model.Episode;


public interface SerieRepository extends JpaRepository<Series, Long>{
    Optional<Series> findByTituloContainingIgnoreCase(String titulo);

    List<Series> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String atores, Double avaliacao);

    List<Series> findTop5ByOrderByAvaliacaoDesc();

    List<Series> findByGenero(Category categoria);

    List<Series> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int temporadas, Double avaliacao);
    @Query("SELECT s FROM Series s WHERE s.temporadas <= :temporadas AND s.avaliacao >= :avaliacao")
    List<Series> seriesPorTemporadaEAvaliacao(int temporadas, Double avaliacao);
    @Query("SELECT e FROM Series e JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episode> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Series s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episode> findTopEpisodiosPorSerie(Series serie);

    @Query("SELECT e FROM Series s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episode> episodiosPorSerieEAno(Series serie, int anoLancamento);
}
