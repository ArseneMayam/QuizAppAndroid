package com.example.arsene.quizappandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.arsene.quizappandroid.entities.Choix;
import com.example.arsene.quizappandroid.entities.Question;
import com.example.arsene.quizappandroid.entities.Reponse;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    Context ctx;
    // les différents composants du layout
    TextView timerQuiz;
    TextView progressionQuiz;
    TextView questionTxtView;
    TextView resultatTxtView;
    TableLayout buttonTableLayout;

    // Les arraylists questions
    ArrayList<Question> questionsSynonmes;
    ArrayList<Question> questionsAntonymes;
    ArrayList<Question> questionsAdverbes;

    // les arraylists de reponse
    ArrayList<Reponse> lesReponses;
    ArrayList<Reponse> reponsesAdverbes;

    // arraylist de choix
    ArrayList<Choix> lesChoix;

    // arraylist question quiz courrant
    ArrayList<Question> questionsQuiz;


    // variables globales

    int idQuestion;  // id de la question courrante
    int nombreChoixAff; // nbre de choix reponse sélectionné par l'utilisateur
    int nombreLigneButton ; // 1 ligne = 3 buttons
    int numeroQuestionCourrante;  // pour la barre de progression
    String categorieSelectionnee;  // catégorie selectionné par l'utilisateur




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ctx = this;

        // Les réferences aux composants
        timerQuiz = (TextView) findViewById(R.id.timerQuiz);
        progressionQuiz = (TextView) findViewById(R.id.progressionQuiz);
        questionTxtView = (TextView) findViewById(R.id.questionQuiz);
        resultatTxtView = (TextView) findViewById(R.id.resultatQuiz);
        buttonTableLayout = (TableLayout) findViewById(R.id.buttonTableLayout);


        iniQuiz();

    }

    // methode pour initialiser le quiz
    private void iniQuiz(){
        // initialise progression quiz
        numeroQuestionCourrante = 0;



        // en fonction de la catégorie selectionnée on initialise arraylist questionQuiz
        switch (categorieSelectionnee){

            case "synonyme": ;

            break;

            case "antonyme":;
            break;

            case "adverbe":;
            break;

        }


        // on passe à la question suivante
        chargerQuestionSuivante();
    }


    // methode pour passer à la question suivante
    private void chargerQuestionSuivante(){
        // à chaque fois qu'on passe à la question suivante
        numeroQuestionCourrante++;

        // efface textView resultat
        resultatTxtView.setText(" ");

        // efface les buttons de choix précédents
        for (int row = 0; row < buttonTableLayout.getChildCount(); row++){
            ((TableRow) buttonTableLayout.getChildAt(row)).removeAllViews();
        }

        // ajoute 3, 6 ou 9 buttons en fonction de nombreChoixAff
        for (int row = 0; row < 3; row++){
            TableRow ligneBttnCourrant = getTableRow(row);

            // inflate le button choix
            for (int column = 0; column < 3; column++){
                //inflate button
                Button newChoixBttn = (Button) getLayoutInflater().inflate(R.layout.choix_bttn,null);

                // get liste des choix et set text des buttons

                // ecoute sur les buttons
                newChoixBttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        submitButton((Button) view);
                    }
                });
                // ajoute button au tableRow courrant
                ligneBttnCourrant.addView(newChoixBttn);
            }
        }

        // on remplace le text d'un boutton par la reponse correct
        // set sont id = id_question


    }

    // methode retourne le tableRow courrant
    private TableRow getTableRow(int row){
        return (TableRow) buttonTableLayout.getChildAt(row);
    }

    // methode appellée lorsque utilisateur clique un bttn choix
    private void submitButton(Button button){



    }





}
