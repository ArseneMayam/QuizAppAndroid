package com.example.arsene.quizappandroid.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Reponse;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by mayammouarangue on 13/11/17.
 */

public class ReponseManager {

    // recupere toutes les reponses
    public static ArrayList<Reponse> getAll(Context ctx){
        ArrayList<Reponse> retour = new ArrayList<>();

        String query = "select * from "+ ConstDB.reponse.nomTable+";";
        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            int id_question = c.getInt(1);
            String reponse = c.getString(2);

            Reponse r = new Reponse(id,id_question,reponse);
            retour.add(r);
        }

        return retour;
    }
}
