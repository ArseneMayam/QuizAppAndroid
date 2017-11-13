package com.example.arsene.quizappandroid.entities;


public class Reponse {

    // Attributs
    private int id;
    private int id_question;
    private String reponse;

    //constructeur
    public Reponse(){}

    public Reponse(int id, int id_question,String reponse){
        this.id = id;
        this.id_question = id_question;
        this.reponse = reponse;
    }

    // Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
