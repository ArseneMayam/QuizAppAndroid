package com.example.arsene.quizappandroid.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Choix;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by mayammouarangue on 13/11/17.
 */

public class ChoixManager {

    public static ArrayList<Choix> getAll(Context ctx){
        ArrayList<Choix> retour = new ArrayList<>();

        String query ="select * from "+ ConstDB.choix.nomTable+";";
        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToFirst()){
            int id = c.getInt(0);
            String choix = c.getString(1);

            Choix unChoix = new Choix(id,choix);
            retour.add(unChoix);
        }
        return retour;
    }


    // recupere tous les choix des catégories synonymes et antonymes
    public static ArrayList<Choix> getChoixExceptAdverbes(Context ctx){
        ArrayList<Choix> retour = new ArrayList<>();

        String queryGetChoixSynAnt="select * from "+ ConstDB.choix.nomTable+" where id<80;";

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetChoixSynAnt,null);

        while (c.moveToFirst()){
            int id = c.getInt(0);
            String choix = c.getString(1);

            Choix unChoix = new Choix(id,choix);
            retour.add(unChoix);
        }
        return retour;
    }

    // recupere tous les choix de la catégorie adverbes
    public static ArrayList<Choix> getChoixAdverbes(Context ctx){
        ArrayList<Choix> retour = new ArrayList<>();
        String queryGetChoixAdverbe="select * from "+ ConstDB.choix.nomTable+" where id >= 80;";

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetChoixAdverbe,null);

        while (c.moveToFirst()){
            int id = c.getInt(0);
            String choix = c.getString(1);

            Choix unChoix = new Choix(id,choix);
            retour.add(unChoix);
        }
        return retour;
    }

}


