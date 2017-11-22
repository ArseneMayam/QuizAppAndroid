package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeQuiz extends AppCompatActivity {
    Context ctx;
    Button reponseUnique;
    Button reponseMultiple;

    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_quiz);
        ctx = this;

        extra = getIntent().getStringExtra("categorie");

        reponseUnique =(Button) findViewById(R.id.reponseUnique);
        reponseUnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("categorie",extra);
                intent.setClass(ctx,ChoixActivity.class);
                startActivity(intent);
            }
        });

        reponseMultiple = (Button) findViewById(R.id.reponseMultiple);
        reponseMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ctx,Quiz_Checkbox_Activity.class);
                startActivity(intent);
            }
        });

    }
}
