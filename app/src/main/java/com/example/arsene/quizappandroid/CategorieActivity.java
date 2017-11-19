package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategorieActivity extends AppCompatActivity {

    Context ctx;
    Button btnRetour;
    Button btnCategorie1,btnCategorie2,btnCategorie3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        ctx=this;


        btnRetour=(Button) findViewById(R.id.btnRetour);
        btnCategorie1=(Button) findViewById(R.id.btnSynonyme);
        btnCategorie2=(Button) findViewById(R.id.btnAntonyme);
        btnCategorie3=(Button) findViewById(R.id.btnAdverbe);

        btnCategorie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,TypeQuiz.class );
                intent.putExtra("categorie","synonyme");
                startActivity(intent);
            }
        });

        btnCategorie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,TypeQuiz.class );
                intent.putExtra("categorie","antonyme");
                startActivity(intent);
            }
        });

        btnCategorie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,TypeQuiz.class );
                intent.putExtra("categorie","adverbe");
                startActivity(intent);
            }
        });


        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
}
