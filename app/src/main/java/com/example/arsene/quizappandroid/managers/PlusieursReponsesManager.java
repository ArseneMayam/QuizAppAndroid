package com.example.arsene.quizappandroid.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.PlusieursReponses;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by mayammouarangue on 21/11/17.
 */

public class PlusieursReponsesManager {

    public static ArrayList<PlusieursReponses> getAll(Context ctx){
        ArrayList<PlusieursReponses> retour = new ArrayList<>();
        String query = "select * from "+ ConstDB.plusieursreponses.nomTable+";";

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            int id_question = c.getInt(1);
            String reponse = c.getString(2);

            PlusieursReponses r = new PlusieursReponses(id,id_question,reponse);
            retour.add(r);
        }

        return retour;

    }
}
