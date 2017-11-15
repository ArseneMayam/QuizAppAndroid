package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormulaireActivity extends AppCompatActivity {

    Context ctx;
    Button btnForm;
    EditText ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        ctx=this;
        btnForm =(Button) findViewById(R.id.btnContinuer);
        ed1=(EditText) findViewById(R.id.edPrenom);
        ed2=(EditText) findViewById(R.id.edNom);
        ed3=(EditText) findViewById(R.id.edPw);

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(ctx,CategorieActivity.class );
                 startActivity(intent);
            }
        });


    }
}
