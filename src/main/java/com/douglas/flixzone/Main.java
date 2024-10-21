package com.douglas.flixzone;

import com.douglas.flixzone.model.DataSeason;
import com.douglas.flixzone.model.DataSeries;
import com.douglas.flixzone.service.ApiUsage;
import com.douglas.flixzone.service.ConvertingData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiUsage APIuse = new ApiUsage();
    private ConvertingData convertData = new ConvertingData();

    // É permitido fazer até 1000 requisições da API por dia
    private final String Address = "https://www.omdbapi.com/t=";
    private final String API_KEY = "&apikey=846e80cb";

    public void Menu(){
        var menu = """
                1 - Buscar série
                2 - Buscar episódio
                
                0 - Sair
                """;

        System.out.println(menu);
        var option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1 -> buscarSerie();
            case 2 -> buscarEpisodioPorSerie();
            case 0 -> System.exit(0);
            default -> System.out.println("Opção inválida");
        }
    }

    private void buscarSerie(){
        DataSeries dados = getDataSeries();
        System.out.println(dados);
    }

    private DataSeries getDataSeries(){
        System.out.println("Digite o nome da série para buscar: ");
        var seriesName = scanner.nextLine();
        var json = APIuse.obterDados(Address + seriesName.replace(" ", "+") + API_KEY);
        DataSeries dados = convertData.obterDados(json, DataSeries.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        DataSeries dadosSerie = getDataSeries();
        List<DataSeason> temporadas = new ArrayList<>();

        for(int i = 1; i <= dadosSerie.temporadas(); i++){
            var json = APIuse.obterDados(Address + dadosSerie.titulo().replace(" ", "+") +
                                         "&Season=" + i + API_KEY);
            DataSeason dadosTemporada = convertData.obterDados(json, DataSeason.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }



}
