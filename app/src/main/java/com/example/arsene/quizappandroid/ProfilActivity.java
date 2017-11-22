package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfilActivity extends AppCompatActivity {

    ArrayList<String> keys;
    Context ctx;
    TextView prenomtv,scoretv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ctx =this;

        prenomtv = (TextView) findViewById(R.id.profilNom);
        scoretv = (TextView) findViewById(R.id.profilScore);


        //recupere le prenom du joueur et laffiche dans le textview
        SharedPreferences sharedPref = getSharedPreferences("prenomJoueur",Context.MODE_PRIVATE);
        String prenom =sharedPref.getString("prenom","");
        prenomtv.setText(prenom);

        SharedPreferences sharedPref2 = getSharedPreferences("scoreJoueur",Context.MODE_PRIVATE);
        String score=sharedPref2.getString("score","");
        scoretv.setText(score);

    }
}
