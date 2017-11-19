package com.example.arsene.quizappandroid.managers;

/**
 * Created by Tania on 2017-11-19.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.entities.Utilisateur;
import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.services.ConnexionDB;
import com.example.arsene.quizappandroid.Utils.ConstDB;



public class SeConnecterManager {
    private static final String queryLoginPwd = "select * from "+ ConstDB.utilisateur.nomTable+" where prenom like ? and nom like ? and pwd like ?";


    public static Utilisateur getByLoginPwd(Context ctx, Utilisateur utilisateur) {
        Utilisateur retour = null;

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(queryLoginPwd, new String[]{utilisateur.getPrenom(),utilisateur.getNom(), utilisateur.getPwd()});

        if (c.moveToNext())
            retour = new Utilisateur(c.getInt(c.getColumnIndex(ConstDB.utilisateur.id)),
                    c.getString(c.getColumnIndex(ConstDB.utilisateur.prenom)),
                    c.getString(c.getColumnIndex(ConstDB.utilisateur.nom)),
                    c.getString(c.getColumnIndex(ConstDB.utilisateur.pwd)));


        return retour;
    }

}
