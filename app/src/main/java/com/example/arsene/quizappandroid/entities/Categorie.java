package com.example.arsene.quizappandroid.entities;


public class Categorie {
    // Attributs
    private int id;
    private String nom;

    // Constructeur
    public Categorie(){}

    public Categorie(int id, String nom){
        this.id = id;
        this.nom =nom;
    }

    // Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
