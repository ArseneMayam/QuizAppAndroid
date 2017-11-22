package com.example.arsene.quizappandroid.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Score;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by mayammouarangue on 21/11/17.
 */

public class ScoreManager {

    public static ArrayList<Score> getAll(Context ctx){
        ArrayList<Score> retour = new ArrayList<>();
        String query = "select * from "+ ConstDB.score.nomTable+";";

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            int id_utilisateur = c.getInt(1);
            int score = c.getInt(2);
            String prenom = c.getString(3);

            Score s = new Score(id, id_utilisateur,score,prenom);
            retour.add(s);
        }

        return retour;

    }

    public static void add(Context ctx, Score score){
        ContentValues cv = new ContentValues();

        cv.put(ConstDB.score.id_utilisateur,score.getId_utilisateur());
        cv.put(ConstDB.score.score,score.getScore());
        cv.put(ConstDB.score.prenom,score.getPrenom());

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        bd.insert(ConstDB.score.nomTable,null,cv);

    }
}
