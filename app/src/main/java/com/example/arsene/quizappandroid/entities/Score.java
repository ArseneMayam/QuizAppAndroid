package com.example.arsene.quizappandroid.entities;

/**
 * Created by mayammouarangue on 21/11/17.
 */

public class Score {

    private int id;
    private int id_utilisateur;
    private int score;
    private String prenom;

    public Score(int id, int id_utilisateur, int score, String prenom) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.score = score;
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}
