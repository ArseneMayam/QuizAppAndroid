package com.example.arsene.quizappandroid.entities;



public class Choix {

    // Attributs
    private int id;
    private String choix;

    // Constructeur
    public Choix(){}

    public Choix(int id, String choix){
        this.id=id;
        this.choix=choix;
    }
    //Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }
}
