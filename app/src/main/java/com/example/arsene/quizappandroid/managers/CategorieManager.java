package com.example.arsene.quizappandroid.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;
import com.example.arsene.quizappandroid.entities.Categorie;
import com.example.arsene.quizappandroid.services.ConnexionDB;

import java.util.ArrayList;

/**
 * Created by arsenemayam on 13/11/17.
 */

public class CategorieManager {
    // recupere toutes les categories

    public static ArrayList<Categorie> getAll(Context ctx){
        ArrayList<Categorie> retour = new ArrayList<>();

        String query ="select * from "+ ConstDB.categorie.nomTable+";";
        SQLiteDatabase bd = ConnexionDB.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToFirst()){
            int id = c.getInt(0);
            String nom = c.getString(1);

            Categorie uneCategorie = new Categorie(id,nom);
            retour.add(uneCategorie);
        }

        return retour;
    }
}
