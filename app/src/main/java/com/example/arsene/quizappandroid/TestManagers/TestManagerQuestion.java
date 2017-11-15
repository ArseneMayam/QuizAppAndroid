package com.example.arsene.quizappandroid.TestManagers;

import com.example.arsene.quizappandroid.entities.Question;

import java.util.ArrayList;



public class TestManagerQuestion {
    private static ArrayList<Question> listeQuestion;

    private static void init(){
        listeQuestion = new ArrayList<>();

        listeQuestion.add(new Question(1,1,"adresse",1));
        listeQuestion.add(new Question(2,1,"ami",1));
        listeQuestion.add(new Question(3,1,"arrivee",1));
        listeQuestion.add(new Question(4,1,"bonte",1));
        listeQuestion.add(new Question(5,1,"bout",1));
        listeQuestion.add(new Question(6,1,"bruit",1));
        listeQuestion.add(new Question(6,1,"campagne",1));
        listeQuestion.add(new Question(7,1,"cause",1));
        listeQuestion.add(new Question(8,1,"chateau",1));
        listeQuestion.add(new Question(9,1,"colere",1));
        listeQuestion.add(new Question(10,1,"cri",1));
        listeQuestion.add(new Question(11,1,"danger",1));
        listeQuestion.add(new Question(12,1,"debut",1));
        listeQuestion.add(new Question(13,1,"dos",1));
        listeQuestion.add(new Question(14,1,"douleur",1));
        listeQuestion.add(new Question(15,1,"doute",1));
        listeQuestion.add(new Question(16,1,"est",1));
        listeQuestion.add(new Question(17,1,"force",1));
        listeQuestion.add(new Question(18,1,"foule",1));
        listeQuestion.add(new Question(19,1,"guerre",1));
        listeQuestion.add(new Question(20,1,"paix",1));
    }

    public static ArrayList<Question> getAll(){
        if(listeQuestion == null){
            init();;
        }
        return listeQuestion;
    }

}
