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
        listeReponse.add(new Reponse(4,1,"devouement"));
        listeReponse.add(new Reponse(5,1,"frontiere"));
        listeReponse.add(new Reponse(6,1,"vacarme"));
        listeReponse.add(new Reponse(7,1,"brouhaha"));
        listeReponse.add(new Reponse(8,1,"villegiature"));
        listeReponse.add(new Reponse(9,1,"raison"));
        listeReponse.add(new Reponse(10,1,"manoir"));
        listeReponse.add(new Reponse(11,1,"courroux"));
        listeReponse.add(new Reponse(12,1,"hurlement"));
        listeReponse.add(new Reponse(13,1,"risque"));
        listeReponse.add(new Reponse(14,1,"introduction"));
        listeReponse.add(new Reponse(15,1,"envers"));
        listeReponse.add(new Reponse(16,1,"malaise"));
        listeReponse.add(new Reponse(17,1,"incertitude"));
        listeReponse.add(new Reponse(18,1,"levant"));
        listeReponse.add(new Reponse(19,1,"vigeur"));
        listeReponse.add(new Reponse(20,1,"amour"));

    }

    public static ArrayList<Reponse> getAll(){
        if(listeReponse == null){
            init();
        }
        return listeReponse;
    }


}
