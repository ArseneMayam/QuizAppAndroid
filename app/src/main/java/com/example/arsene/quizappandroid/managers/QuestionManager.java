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
        String queryGetSynonyme ="select * from "+ ConstDB.categorie.nomTable+" where id=1;";
        String queryGetAntonyme ="select * from "+ ConstDB.categorie.nomTable+" where id=2;";
        String queryGetAdverbe ="select * from "+ ConstDB.categorie.nomTable+" where id=3;";
        String queryGetChoixAdverbe="select * from "+ ConstDB.choix.nomTable+" where id>=80;";
        String queryGetChoixSynAnt="select * from "+ ConstDB.choix.nomTable+" where id<80;";
        String queryGetReponse="select * from "+ ConstDB.reponse.nomTable+" where id_question=?;";
        String queryGetScoreById="SELECT * FROM "+ ConstDB.score.nomTable+" INNER JOIN "+ ConstDB.utilisateur.nomTable+" ON score.id_utilisateur = utilisateur.id where id_utilisateur=?;";


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

    // recupere toutes les questions catégorie synonymes
    public static ArrayList<Question> questionsSynonymes(Context ctx){
        ArrayList<Question> retour = new ArrayList<>();

        String query = "select * from "+ ConstDB.question.nomTable+" where "+ConstDB.question.id_questionnaire+
                " =1;";

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            int id_questionnaire = c.getInt(1);
            String question = c.getString(2);
            int type = c.getInt(3);

            Question q = new Question(id,id_questionnaire,question,type);
            retour.add(q);

        }
        return retour;
    }
}
