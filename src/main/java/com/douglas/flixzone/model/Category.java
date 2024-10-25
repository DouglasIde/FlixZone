package com.douglas.flixzone.model;

public enum Category {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    TERROR("Horror", "Terror"),
    DRAMA("Drama", "Drama"),
    COMEDIA("Comedy", "Comédia"),
    CRIME("Crime", "Crime");

    private String categoryOmbd;
    private String categoryPortuguese;

    Category(String categoryOmdb, String categoryPortuguese){
        this.categoryOmbd = categoryOmdb;
        this.categoryPortuguese = categoryPortuguese;
    }

    public static Category fromString(String text){
        for (Category category : Category.values()){
            if (category.categoryOmbd.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Categoria inválida");
    }

    public static Category fromPortuguese(String text){
        for(Category category : Category.values()){
            if(category.categoryOmbd.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Categoria inválida");
    }
}
