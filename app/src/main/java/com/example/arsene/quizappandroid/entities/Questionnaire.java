package com.example.arsene.quizappandroid.entities;


public class Questionnaire {

    //Attributs
    private int id;
    private int id_categorie;

    // Constructeur
    public Questionnaire(){}


    //Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
}
