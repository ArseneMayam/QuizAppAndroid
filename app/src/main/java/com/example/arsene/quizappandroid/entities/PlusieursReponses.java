package com.example.arsene.quizappandroid.entities;

/**
 * Created by mayammouarangue on 21/11/17.
 */

public class PlusieursReponses {

    private int id;
    private int id_question;
    private String reponse;

    public PlusieursReponses(int id, int id_question, String reponse) {
        this.id = id;
        this.id_question = id_question;
        this.reponse = reponse;
    }

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
