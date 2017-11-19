package com.example.arsene.quizappandroid.TestManagers;

import com.example.arsene.quizappandroid.entities.Reponse;

import java.util.ArrayList;

/**
 * Created by Tania on 2017-11-18.
 */

public class TestManagerMultipleReponse {
    private static ArrayList<Reponse> listeReponse;

    private static void init(){
        listeReponse = new ArrayList<>();

        listeReponse.add(new Reponse(1,1,"habilete"));
        listeReponse.add(new Reponse(2,3,"compagnon"));
        listeReponse.add(new Reponse(3,4,"Complice"));
        listeReponse.add(new Reponse(4,5,"venue"));
        listeReponse.add(new Reponse(5,6,"devouement"));
        listeReponse.add(new Reponse(6,7,"frontiere"));
        listeReponse.add(new Reponse(7,8,"vacarme"));
        listeReponse.add(new Reponse(8,9,"brouhaha"));
        listeReponse.add(new Reponse(9,10,"villegiature"));
        listeReponse.add(new Reponse(10,11,"raison"));
        listeReponse.add(new Reponse(11,12,"manoir"));
        listeReponse.add(new Reponse(12,13,"courroux"));
        listeReponse.add(new Reponse(13,14,"hurlement"));
        listeReponse.add(new Reponse(14,15,"risque"));
        listeReponse.add(new Reponse(15,16,"introduction"));
        listeReponse.add(new Reponse(16,17,"envers"));
        listeReponse.add(new Reponse(17,18,"malaise"));
        listeReponse.add(new Reponse(18,19,"incertitude"));
        listeReponse.add(new Reponse(19,20,"levant"));
        listeReponse.add(new Reponse(20,21,"vigeur"));
        listeReponse.add(new Reponse(21,22,"amour"));

    }

    public static ArrayList<Reponse> getAll(){
        if(listeReponse == null){
            init();
        }
        return listeReponse;
    }

}
