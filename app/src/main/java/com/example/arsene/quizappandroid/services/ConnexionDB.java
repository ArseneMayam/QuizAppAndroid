package com.example.arsene.quizappandroid.services;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.arsene.quizappandroid.Utils.ConstDB;

import java.io.IOException;

/**
 * Created by arsenemayam on 13/11/17.
 */

public class ConnexionDB {

    private static SQLiteDatabase bd;
    private static int versionBD = 1;

    public static SQLiteDatabase getBd(Context ctx){
        GestionBD gbd = new GestionBD(ctx, ConstDB.nomBd,null,versionBD);



        try{
            bd = gbd.getWritableDatabase();
        }catch (SQLException e){
            throw e;
        }
        return bd;
    }

    public static void close(){
        bd.close();
    }

}
