package com.example.arsene.quizappandroid;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.arsene.quizappandroid.TestManagers.TestManagerChoix;
import com.example.arsene.quizappandroid.TestManagers.TestManagerQuestion;
import com.example.arsene.quizappandroid.TestManagers.TestManagerReponse;
import com.example.arsene.quizappandroid.entities.Choix;
import com.example.arsene.quizappandroid.entities.Question;
import com.example.arsene.quizappandroid.entities.Reponse;


import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Context ctx;
    // les différents composants du layout
    TextView timerQuiz;
    TextView progressionQuiz;
    TextView questionTxtView;
    TextView resultatTxtView;
    TextView scoreTextView;
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
    int idChoixBttn; // id des buttons choix
    int idQuestion;  // id de la question courrante
    int nombreChoixAff; // nbre de choix reponse sélectionné par l'utilisateur
    int nombreLigneButton ; // 1 ligne = 3 buttons
    int numeroQuestionCourrante;  // pour la barre de progression
    int nbReponsesCorrect; // nombre de reponse corrects

    String categorieSelectionnee;  // catégorie selectionné par l'utilisateur
    String reponseCorrect; // la reponse correct
    Question laQuestion;


    Random random; // nb aléatoire
    Handler handler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ctx = this;
        idChoixBttn = 156;
        nbReponsesCorrect = 0;
        nombreLigneButton = 2;
        random = new Random();
        laQuestion = null;
        handler = new Handler();
        reponseCorrect =" ";

        // Les réferences aux composants
        timerQuiz = (TextView) findViewById(R.id.timerQuiz);
        progressionQuiz = (TextView) findViewById(R.id.progressionQuiz);
        questionTxtView = (TextView) findViewById(R.id.questionQuiz);
        resultatTxtView = (TextView) findViewById(R.id.resultatQuiz);
        buttonTableLayout = (TableLayout) findViewById(R.id.buttonTableLayout);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);

        categorieSelectionnee = "synonyme";
        questionsQuiz =new ArrayList<>();
        questionsSynonmes = TestManagerQuestion.getAll();
        lesReponses = TestManagerReponse.getAll();
        lesChoix = TestManagerChoix.getAll();

        iniQuiz();

    }

    // methode pour initialiser le quiz
    private void iniQuiz(){
        // initialise progression quiz
        numeroQuestionCourrante = 0;



        // en fonction de la catégorie selectionnée on initialise arraylist questionQuiz
        switch (categorieSelectionnee){

          case "synonyme":

              for (Question question : questionsSynonmes){
                  questionsQuiz.add(question);
              }

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

        //reponseCorrect  = " ";


        if (laQuestion == null){
            laQuestion =questionsQuiz.get(0);


        }else {
            questionsQuiz.remove(0);
            laQuestion = questionsQuiz.get(0);
        }
        // get id de la question
        idQuestion = laQuestion.getId();

        System.out.println("id de la question : "+laQuestion.getId());

        // affiche la question
        questionTxtView.setText(laQuestion.getQuestion());

        // get la reponse correct
        for (Reponse reponse : lesReponses){
            System.out.print("---DANS LA BOUCLE REPONSE ---");

            if(reponse.getId() == idQuestion){
                reponseCorrect = reponse.getReponse();
                System.out.print("la reponse : "+ reponseCorrect +" ---");
            }
            System.out.print("Apres le IF :" + reponseCorrect+"---");

        }


        // à chaque fois qu'on passe à la question suivante
        numeroQuestionCourrante++;

        // efface textView resultat
        resultatTxtView.setText(" ");




        // efface les buttons de choix précédents
        for (int row = 0; row < buttonTableLayout.getChildCount(); row++){
            ((TableRow) buttonTableLayout.getChildAt(row)).removeAllViews();
        }

        // ajoute 3, 6 ou 9 buttons en fonction de nombreChoixAff
        for (int row = 0; row < nombreLigneButton; row++){
            TableRow ligneBttnCourrant = getTableRow(row);

            // inflate le button choix
            for (int column = 0; column < 3; column++){
                //inflate button
                Button newChoixBttn = (Button) getLayoutInflater().inflate(R.layout.choix_bttn,null);

                // on get les choix
                Choix unChoix = lesChoix.get((row*3)+column);
                // get liste des choix et set text des buttons et id
                newChoixBttn.setText(unChoix.getChoix());
                newChoixBttn.setId(idChoixBttn);

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

        // on remplace le text d'un boutton aléatoire par la reponse correct
        // set sont id = id_question
        int row = random.nextInt(nombreLigneButton);
        int column = random.nextInt(3);
        TableRow randomTableRow = getTableRow(row);
        ((Button) randomTableRow.getChildAt(column)).setText(reponseCorrect);
        ((Button) randomTableRow.getChildAt(column)).setId(idQuestion);

    }

    // methode retourne le tableRow courrant
    private TableRow getTableRow(int row){
        return (TableRow) buttonTableLayout.getChildAt(row);
    }

    // methode appellée lorsque utilisateur clique un bttn choix
    private void submitButton(Button button){


        if(button.getId() == idQuestion){
            nbReponsesCorrect++;

            // reponse correcte, on l'affiche dans le textView resultat
            String bonneReponse = button.getText().toString();
            resultatTxtView.setText(bonneReponse+"!");
            resultatTxtView.setTextColor(getResources().getColor(R.color.reponseCorrect));
            scoreTextView.setText(nbReponsesCorrect+" / 20");
            scoreTextView.setTextColor(getResources().getColor(R.color.reponseCorrect));



        }
        else {
            resultatTxtView.setText("Incorrect !");
            resultatTxtView.setTextColor(getResources().getColor(R.color.reponseIncorrect));
        }
        // on passe à la question suivante

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                chargerQuestionSuivante();
            }
        },1000); // passe à la question suivante après 1 sec







    }


}
