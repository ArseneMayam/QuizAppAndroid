package com.example.arsene.quizappandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    Context ctx;
    TextView nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ctx =this;

        nom = (TextView) findViewById(R.id.profilNom);

    }
}
