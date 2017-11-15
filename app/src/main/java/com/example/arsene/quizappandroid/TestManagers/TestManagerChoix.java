package com.example.arsene.quizappandroid.TestManagers;


import com.example.arsene.quizappandroid.entities.Choix;

import java.util.ArrayList;

public class TestManagerChoix {
    private static ArrayList<Choix> listeChoix;

    private static void init(){
        listeChoix = new ArrayList<>();

        listeChoix.add(new Choix(1,"descendre"));
        listeChoix.add(new Choix(2,"retirer"));
        listeChoix.add(new Choix(3,"malpropre"));
        listeChoix.add(new Choix(4,"crasseux"));
        listeChoix.add(new Choix(5,"anguleux"));
        listeChoix.add(new Choix(6,"enjoué"));
        listeChoix.add(new Choix(7,"inerte"));
        listeChoix.add(new Choix(8,"pointu"));
        listeChoix.add(new Choix(9,"faux"));
        listeChoix.add(new Choix(10,"poli"));
        listeChoix.add(new Choix(11,"baille"));
        listeChoix.add(new Choix(12,"conviction"));
        listeChoix.add(new Choix(13,"tache"));
        listeChoix.add(new Choix(14,"politesse"));
        listeChoix.add(new Choix(15,"engouement"));
        listeChoix.add(new Choix(16,"gentille"));

    }

    public static ArrayList<Choix> getAll(){
        if (listeChoix == null){
            init();
        }
        return listeChoix;
    }

}
