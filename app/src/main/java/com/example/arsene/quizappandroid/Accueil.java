package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    Context ctx;
    // les différents composants du layout
    Button bttnCommencer;
    Button bttnCategorie;
    Button bttnQuitter;
    // Intent pour la redirection
    Intent redirection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        ctx=this;

        // Les réferences aux composants
        bttnCommencer = (Button) findViewById(R.id.bttnCommencer);
        bttnCategorie = (Button) findViewById(R.id.bttnCategorie);
        bttnQuitter = (Button) findViewById(R.id.bttnQuitter);

        // Ecoute sur les bouttons
        bttnCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, FormulaireActivity.class);
                startActivity(intent);
            }
        });


        bttnCategorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, CategorieActivity.class);

                startActivity(intent);

            }
        });

        bttnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Quitte L'App
                finish();
                System.exit(0);
            }
        });

    }
}
