package com.example.arsene.quizappandroid.entities;


public class Utilisateur {

    //Attributs
    private int id;
    private String prenom;
    private String nom;
    private String pwd;

    //Constructeur
    public Utilisateur(){}  // sans paramètre

    public Utilisateur(int id, String prenom, String nom, String pwd){
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.pwd = pwd;
    }

    //Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
