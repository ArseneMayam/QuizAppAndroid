package com.example.arsene.quizappandroid.TestManagers;


import com.example.arsene.quizappandroid.entities.Reponse;

import java.util.ArrayList;

public class TestManagerReponse {

    private static ArrayList<Reponse> listeReponse;

    private static void init(){
        listeReponse = new ArrayList<>();

        listeReponse.add(new Reponse(1,1,"habilete"));
        listeReponse.add(new Reponse(2,1,"compagnon"));
        listeReponse.add(new Reponse(3,1,"venue"));
        listeReponse.add(new Reponse(4,2,"devouement"));
        listeReponse.add(new Reponse(5,2,"frontiere"));
        listeReponse.add(new Reponse(6,3,"vacarme"));
        listeReponse.add(new Reponse(7,3,"brouhaha"));
        listeReponse.add(new Reponse(8,3,"villegiature"));
        listeReponse.add(new Reponse(9,9,"raison"));
        listeReponse.add(new Reponse(10,10,"manoir"));
        listeReponse.add(new Reponse(11,11,"courroux"));
        listeReponse.add(new Reponse(12,12,"hurlement"));
        listeReponse.add(new Reponse(13,13,"risque"));
        listeReponse.add(new Reponse(14,14,"introduction"));
        listeReponse.add(new Reponse(15,15,"envers"));
        listeReponse.add(new Reponse(16,16,"malaise"));
        listeReponse.add(new Reponse(17,17,"incertitude"));
        listeReponse.add(new Reponse(18,18,"levant"));
        listeReponse.add(new Reponse(19,19,"vigeur"));
        listeReponse.add(new Reponse(20,20,"amour"));

    }

    public static ArrayList<Reponse> getAll(){
        if(listeReponse == null){
            init();
        }
        return listeReponse;
    }


}
