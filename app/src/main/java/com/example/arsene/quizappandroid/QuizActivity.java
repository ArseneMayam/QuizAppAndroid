package com.example.arsene.quizappandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.arsene.quizappandroid.managers.QuestionManager;
import com.example.arsene.quizappandroid.managers.ReponseManager;
import com.example.arsene.quizappandroid.managers.ReponseManager;


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
    TextView nomJoeur;
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
    String choixReponses;
    Question laQuestion;


    Random random; // nb aléatoire
    Handler handler;

    // le timer
    CountDown leTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ctx = this;
        idChoixBttn = 156;
        nbReponsesCorrect = 0;

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
        nomJoeur=(TextView) findViewById(R.id.tvNomJoeur);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);


        questionsQuiz =new ArrayList<>();
        questionsSynonmes = QuestionManager.questionsSynonymes(ctx);
        questionsAntonymes = QuestionManager.questionsAntonymes(ctx);
        questionsAdverbes = QuestionManager.questionsAdverbes(ctx);
        lesReponses = ReponseManager.getAll(ctx);
        lesChoix = TestManagerChoix.getAll();

        categorieSelectionnee = getIntent().getStringExtra("categorie"); // catégorie sélectionnée


        // le nombre de buttons affichés en fonction du choix de l'utilisateur
        choixReponses = getIntent().getStringExtra("choix");
        switch (choixReponses){
            case "choix3":
                nombreLigneButton = 1;
                break;
            case "choix6":
                nombreLigneButton = 2;
                break;
            case "choix9":
                nombreLigneButton = 3;
                break;
        }




        Intent intent =getIntent();
        nomJoeur.setText(intent.getStringExtra("edPrenom"));

        // initialise le quiz
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

            case "antonyme":
                for (Question question : questionsAntonymes){
                    questionsQuiz.add(question);
                }
           break;

           case "adverbe":
               for(Question question : questionsAdverbes){
                   questionsQuiz.add(question);
               }
            break;

        }


        // on passe à la question suivante
        chargerQuestionSuivante();
    }


    // methode pour passer à la question suivante
    private void chargerQuestionSuivante(){


        leTimer = new CountDown(20000,1000);
       leTimer.start();

        // à chaque fois qu'on passe à la question suivante
        numeroQuestionCourrante++;

        // Arrivée à la dernière question on affiche un alertdialog
        if(numeroQuestionCourrante == 20){
            leTimer.cancel();
            leTimer = null;
           // questionsQuiz = null;

           System.out.print("timer stopped");
            Intent intent = new Intent();
            intent.setClass(ctx,ResetQuiz.class);
            startActivity(intent);

        }

        //reponseCorrect  = " ";

        if (laQuestion == null){
            laQuestion =questionsQuiz.get(0);

        }
        else if (!(questionsQuiz.isEmpty()) && questionsQuiz != null && questionsQuiz.size() !=0){ // si l'arraylist n'est pas vide
            questionsQuiz.remove(0);
            try {
                laQuestion = questionsQuiz.get(0);
            }catch (IndexOutOfBoundsException e){

                e.printStackTrace();

            }
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
                System.out.print("la reponse : "+ reponseCorrect +" //---");
            }
           System.out.print("Apres le IF :" + reponseCorrect+"---");

        }



        // on affiche le numero question courante
        progressionQuiz.setText("Question: "+numeroQuestionCourrante);

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



    // classe qui herite de countdown timer
    class CountDown extends CountDownTimer{

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            timerQuiz.setText(" "+l/1000);

            if((l/1000)==1 && !(questionsQuiz.isEmpty()) && questionsQuiz != null && questionsQuiz.size() !=0){
                this.cancel();
                this.onFinish();

            }

            if ((l/1000) ==1) {
                chargerQuestionSuivante();
            }

        }

        @Override
        public void onFinish() {
               // chargerQuestionSuivante();
        }

    }


    @Override
    protected void onStop() {

        Log.e("stop","stop");
        super.onStop();
    }
}

