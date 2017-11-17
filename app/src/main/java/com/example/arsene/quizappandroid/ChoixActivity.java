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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        ctx=this;

        choix1=(Button) findViewById(R.id.btn3choix);
        choix2=(Button) findViewById(R.id.btn6choix);
        choix3=(Button) findViewById(R.id.btn9choix);

        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix3");
                startActivity(intent);
            }
        });

        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix6");
                startActivity(intent);
            }
        });

        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,QuizActivity.class );
                intent.putExtra("choix","choix9");
                startActivity(intent);
            }
        });

    }
}
