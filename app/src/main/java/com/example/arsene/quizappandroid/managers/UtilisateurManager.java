package com.example.arsene.quizappandroid.managers;

import android.content.ContentValues;
import android.content.Context;
import com.example.arsene.quizappandroid.entities.Utilisateur;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Categorie;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by Tania on 2017-11-16.
 */

public class UtilisateurManager {


    public static void insert(Context ctx, Utilisateur utilisateur) {
        ContentValues cv = new ContentValues();


        cv.put(ConstDB.utilisateur.pwd , utilisateur.getPwd());
        cv.put(ConstDB.utilisateur.nom , utilisateur.getNom());
        cv.put(ConstDB.utilisateur.prenom, utilisateur.getPrenom());

        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        bd.insert(ConstDB.utilisateur.nomTable, null, cv);

        bd.close();
    }

    public static ArrayList <Utilisateur> getAll(Context ctx){

        ArrayList<Utilisateur> retour =new ArrayList<>();

        String query ="select * from "+ ConstDB.utilisateur.nomTable+";";
        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToFirst()){
            int id = c.getInt(0);
            String prenom = c.getString(1);
            String nom = c.getString(2);
            String pwd = c.getString(3);

            Utilisateur unUtilisateur = new Utilisateur(id,prenom,nom,pwd);
            retour.add(unUtilisateur);
        }

        return retour;
    }



}
