package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.arsene.quizappandroid.entities.Utilisateur;
import com.example.arsene.quizappandroid.managers.UtilisateurManager;

import java.sql.DatabaseMetaData;


public class InscriptionActivity extends AppCompatActivity {

    Context ctx;

    EditText edPrenom,edNom,edPwd;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        ctx=this;

        edPrenom=(EditText) findViewById(R.id.edPrenomInscrip);
        edNom=(EditText) findViewById(R.id.edNomInscrip);
        edPwd=(EditText) findViewById(R.id.edPwInscrip);
        btn1=(Button) findViewById(R.id.btnContinuerInscrip);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilisateur u = new Utilisateur(-1,edPrenom.getText().toString(),
                                                edNom.getText().toString(),
                                                edPwd.getText().toString());
                UtilisateurManager.insert(getBaseContext(),u);
                Intent intent = new Intent(ctx,FormulaireActivity.class );
                startActivity(intent);
            }
        });


    }
}
