package com.example.arsene.quizappandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
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



    }

    // methode pour initialiser le quiz
    private void iniQuiz(){



        // en fonction de la catégorie selectionnée on initialise arraylist questionQuiz
        switch (categorieSelectionnee){

            case "synonyme": ;

            break;

            case "antonyme":;
            break;

            case "adverbe":;
            break;

        }


        // on passe à la question
        chargerQuestionSuivante();
    }


    // methode pour passer à la question suivante
    private void chargerQuestionSuivante(){

        // efface textView resultat
        resultatTxtView.setText(" ");


        





    }





}
