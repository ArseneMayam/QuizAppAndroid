package com.example.arsene.quizappandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixActivity extends AppCompatActivity {

    Button choix1,choix2,choix3;
    Context ctx;
    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        ctx=this;

       // categorie = getIntent().getStringExtra("categorie");
      //  System.out.println(categorie);
        extra = getIntent().getStringExtra("categorie");

        choix1=(Button) findViewById(R.id.btn3choix);
        choix2=(Button) findViewById(R.id.btn6choix);
        choix3=(Button) findViewById(R.id.btn9choix);

        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix3");
                intent.putExtra("categorie",extra);
                startActivity(intent);
            }
        });

        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix6");
                intent.putExtra("categorie",extra);
                startActivity(intent);
            }
        });

        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix9");
                intent.putExtra("categorie",extra);
                startActivity(intent);
            }
        });

    }
}
