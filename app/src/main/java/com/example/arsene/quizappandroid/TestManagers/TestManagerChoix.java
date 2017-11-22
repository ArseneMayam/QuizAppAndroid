package com.example.arsene.quizappandroid.TestManagers;


import com.example.arsene.quizappandroid.entities.Choix;

import java.util.ArrayList;

public class TestManagerChoix {
    private static ArrayList<Choix> listeChoix;
    private static ArrayList<Choix> choixAdverbes;

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
        listeChoix.add(new Choix(15,"chantage"));
        listeChoix.add(new Choix(16,"gentille"));
        listeChoix.add(new Choix(16,"retirer"));
        listeChoix.add(new Choix(17,"rossignol"));
        listeChoix.add(new Choix(18,"roue"));
        listeChoix.add(new Choix(19,"rayure"));
        listeChoix.add(new Choix(20,"renard"));
        listeChoix.add(new Choix(21,"blond"));
        listeChoix.add(new Choix(22,"noirceur"));
        listeChoix.add(new Choix(23,"radis"));
        listeChoix.add(new Choix(24,"sept"));
        listeChoix.add(new Choix(25,"rive"));
        listeChoix.add(new Choix(26,"blessure"));
        listeChoix.add(new Choix(27,"decollage"));
        listeChoix.add(new Choix(28,"surssaut"));
        listeChoix.add(new Choix(29,"envahie"));
        listeChoix.add(new Choix(30,"inattendue"));
        listeChoix.add(new Choix(31,"surtout"));
        listeChoix.add(new Choix(32,"trace"));
        listeChoix.add(new Choix(33,"entasseé"));
        listeChoix.add(new Choix(34,"valide"));
        listeChoix.add(new Choix(35,"culotter"));
        listeChoix.add(new Choix(36,"abbatiales"));
        listeChoix.add(new Choix(37,"aboie"));
        listeChoix.add(new Choix(38,"acourus"));
        listeChoix.add(new Choix(39,"certifié"));
        listeChoix.add(new Choix(40,"adverse"));
        listeChoix.add(new Choix(41,"fracas"));
        listeChoix.add(new Choix(42,"devoeur"));
        listeChoix.add(new Choix(43,"mystifié"));
        listeChoix.add(new Choix(44,"vécu"));
        listeChoix.add(new Choix(45,"reconnaitre"));

    }

    public static ArrayList<Choix> getAll(){
        if (listeChoix == null){
            init();
        }
        return listeChoix;
    }


    private static void initChoixAdverbes(){
        choixAdverbes = new ArrayList<>();
        choixAdverbes.add(new Choix(1,"Négation"));
        choixAdverbes.add(new Choix(2,"Interrogation"));
        choixAdverbes.add(new Choix(3,"Justesse"));
        choixAdverbes.add(new Choix(4,"Arrogance"));
        choixAdverbes.add(new Choix(5,"Emancipation"));
        choixAdverbes.add(new Choix(6,"Vérité"));
        choixAdverbes.add(new Choix(7,"Ignorance"));
        choixAdverbes.add(new Choix(8,"Instance"));
        choixAdverbes.add(new Choix(9,"0bjective"));
        choixAdverbes.add(new Choix(10,"Sympathie"));
    }

    public static ArrayList<Choix> getAllAdverbes(){
        if (choixAdverbes == null)
            initChoixAdverbes();

        return choixAdverbes;
    }
}
