package com.example.arsene.quizappandroid.services;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.arsene.quizappandroid.Utils.ConstDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by arsenemayam on 13/11/17.
 */

public class GestionBD extends SQLiteOpenHelper {

    // info base de donnee
    private static String DB_NAME = ConstDB.nomBd;
    private static String DB_PATH = " ";

    private SQLiteDatabase mDataBase;
    private Context ctx;
    AssetManager assetManager;
    private boolean mNeedUpdate = false;

    public GestionBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.ctx = context;
        assetManager = ctx.getApplicationContext().getAssets();

        DB_PATH = context.getDatabasePath(ConstDB.nomBd).getAbsolutePath();

        copyDataBase();
        this.getWritableDatabase();
    }

    public void updateDataBase() throws IOException{
        if(mNeedUpdate){
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists()){
                dbFile.delete();
            }
            // appelle copyDataBase()
            //
            mNeedUpdate = false;
        }
    }

    public boolean checkDataBase(){
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    public void copyDataBase(){
//        if (!checkDataBase()){
            this.getWritableDatabase();
            this.close();
            try{
                copyDBFile();
            }catch (IOException e){
                throw new Error("error copy database");
            }
//        }
    }

    private void copyDBFile() throws IOException{

        InputStream mInput =assetManager.open(DB_NAME);
        OutputStream mOutput = new FileOutputStream(DB_PATH);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while((mLength = mInput.read(mBuffer))>0){
            mOutput.write(mBuffer,0,mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
    public boolean openDataBase() throws SQLException{
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase!=null;
    }

    public void close(){
        if (mDataBase !=null){
            if (mDataBase != null){
                mDataBase.close();
            }
        }
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1 > i){
            mNeedUpdate = true;
        }

    }
}
