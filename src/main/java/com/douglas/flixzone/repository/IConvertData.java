package com.douglas.flixzone.repository;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classe);
}
