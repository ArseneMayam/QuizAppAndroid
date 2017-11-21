package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetQuiz extends AppCompatActivity {

    Context ctx;
    Button reset;
    Button profil;
    Button quitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_quiz);
        ctx = this;

        reset = (Button) findViewById(R.id.bttnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ctx, CategorieActivity.class);
                startActivity(intent);
            }
        });



        profil = (Button) findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ctx,ProfilActivity.class);
                startActivity(intent);
            }
        });

        quitter = (Button) findViewById(R.id.quitter);
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });
    }
}
