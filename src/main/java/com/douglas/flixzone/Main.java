package com.douglas.flixzone;

import com.douglas.flixzone.service.ApiUsage;
import com.douglas.flixzone.service.ConvertingData;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiUsage APIuse = new ApiUsage();
    private ConvertingData convertData = new ConvertingData();

    // É permitido fazer até 1000 requisições da API por dia
    private final String Address = "https://www.omdbapi.com/t=";
    private final String API_KEY = "&apikey=846e80cb";


}
