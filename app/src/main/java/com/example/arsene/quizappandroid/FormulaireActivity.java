package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arsene.quizappandroid.entities.Utilisateur;
import com.example.arsene.quizappandroid.managers.SeConnecterManager;
import com.example.arsene.quizappandroid.managers.UtilisateurManager;


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
                Utilisateur utilisateur=null;

                utilisateur= SeConnecterManager.getByLoginPwd(ctx,new Utilisateur(-1,
                                                                    ed1.getText().toString(),
                                                                    ed2.getText().toString(),
                                                                    ed3.getText().toString()));

                if (utilisateur != null) {
               Intent intent = new Intent(ctx,CategorieActivity.class );
               intent.putExtra("edPrenom",ed1.getText().toString());
               intent.putExtra("edNom",ed2.getText().toString());
               startActivity(intent);
                }else{
                    Toast.makeText(ctx, "Mauvais mot de passe ou nom/prenom", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
