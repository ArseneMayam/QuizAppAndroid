package com.example.arsene.quizappandroid.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Question;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by arsenemayam on 13/11/17.
 */

public class QuestionManager {

    // recupere toutes les questions
    public static ArrayList<Question> getAll(Context ctx){
        ArrayList<Question> retour = new ArrayList<>();
        String queryGetAll = "select * from " + ConstDB.question.nomTable+";";


        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            int id_questionnaire = c.getInt(1);
            String question = c.getString(2);
            int type = c.getInt(3);

            Question q= new Question(id,id_questionnaire,question,type);
            retour.add(q);
        }


        return retour;
    }

}
