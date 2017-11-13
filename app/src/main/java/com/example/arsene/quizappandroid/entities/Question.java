package com.example.arsene.quizappandroid.entities;

public class Question {

    //Attributs
    private int id;
    private int id_questionnaire;
    private String question;
    private int type;

    // Constructeur
    public Question(){}

    public Question(int id, int id_questionnaire, String question, int type){
        this.id = id;
        this.id_questionnaire = id_questionnaire;
        this.question = question;
        this.type = type;

    }

    //Methodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_questionnaire() {
        return id_questionnaire;
    }

    public void setId_questionnaire(int id_questionnaire) {
        this.id_questionnaire = id_questionnaire;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
