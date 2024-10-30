package com.douglas.flixzone.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


@Getter
@Setter
@Entity
@Table(name = "series")
public class Serie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;

    @Enumerated(EnumType.STRING)
    private Category genero;
    private String atores;
    private String posters;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodios = new ArrayList<>();

    public Serie() {}

    public Serie(DataSeries dataSeries){
        this.titulo = dataSeries.titulo();
        this.totalTemporadas = dataSeries.temporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dataSeries.avaliacao())).orElse(0);
        this.genero = Category.fromString(dataSeries.genero().split(",")[0].trim());
        this.atores = dataSeries.atores();
        this.posters = dataSeries.posters();
    }

    @Override
    public String toString(){
        return
            "genero=" + genero +
            ", titulo='" + titulo + '\'' +
            ", totalTemporadas=" + totalTemporadas +
            ", avaliacao=" + avaliacao +
            ", atores='" + atores + '\'' +
            ", posters='" + posters + '\'';
    }
}