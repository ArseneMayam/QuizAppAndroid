package com.example.arsene.quizappandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arsene.quizappandroid.TestManagers.TestManagerChoix;
import com.example.arsene.quizappandroid.TestManagers.TestManagerMultipleReponse;
import com.example.arsene.quizappandroid.TestManagers.TestManagerQuestion;
import com.example.arsene.quizappandroid.TestManagers.TestManagerReponse;
import com.example.arsene.quizappandroid.entities.Choix;
import com.example.arsene.quizappandroid.entities.PlusieursReponses;
import com.example.arsene.quizappandroid.entities.Question;
import com.example.arsene.quizappandroid.entities.Reponse;
import com.example.arsene.quizappandroid.managers.PlusieursReponsesManager;
import com.example.arsene.quizappandroid.managers.QuestionManager;
import com.example.arsene.quizappandroid.managers.ReponseManager;

import java.util.ArrayList;
import java.util.Random;

public class Quiz_Checkbox_Activity extends AppCompatActivity {

    Context ctx;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;

    Button btnQuiz;
    // les différents composants du layout
    TextView timerQuiz;
    TextView progressionQuiz;
    TextView questionTxtView;
    TextView resultatTxtView;
    TextView scoreTextView;
    TextView nomJoeur;
    TableLayout checkboxTableLayout2;


    // Les arraylists questions
    ArrayList<Question> questionsSynonmes;
    ArrayList<Question> questionsAntonymes;
    ArrayList<Question> questionsAdverbes;

    // les arraylists de reponse
    ArrayList<PlusieursReponses> lesReponses;
    ArrayList<Reponse> reponsesAdverbes;
    ArrayList<PlusieursReponses> reponseQuestionCourante;

    // arraylist de choix
    ArrayList<Choix> lesChoix;

    // arraylist question quiz courrant
    ArrayList<Question> questionsQuiz;


    // variables globales
    int idChoixCheckbox; // id des buttons choix
    int idQuestion;  // id de la question courrante
    int nombreChoixAff; // nbre de choix reponse sélectionné par l'utilisateur
    int nombreLigneCheckbox; // 1 ligne = 3 buttons
    int numeroQuestionCourrante;  // pour la barre de progression
    int nbReponsesCorrect; // nombre de reponse corrects

    String categorieSelectionnee;  // catégorie selectionné par l'utilisateur
    String reponseCorrect; // la reponse correct
    Question laQuestion;

    Choix unChoix;

    Random random; // nb aléatoire
    Handler handler;

    // le timer
    QuizActivity.CountDown leTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_checkbox);
        ctx = this;
        idChoixCheckbox = 156;
        nbReponsesCorrect = 0;
        nombreLigneCheckbox = 2;
        random = new Random();
        laQuestion = null;
        handler = new Handler();
        reponseCorrect =" ";
        reponseQuestionCourante= new ArrayList<>();



        //les 6 checkbox
/*        cb1=(CheckBox)findViewById(R.id.checkBox1);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        cb5=(CheckBox)findViewById(R.id.checkBox5);
        cb6=(CheckBox)findViewById(R.id.checkBox6);*/

        // Les réferences aux composants
        timerQuiz = (TextView) findViewById(R.id.timerQuiz2);
        progressionQuiz = (TextView) findViewById(R.id.progressionQuiz2);
        questionTxtView = (TextView) findViewById(R.id.questionQuiz2);
        resultatTxtView = (TextView) findViewById(R.id.resultatQuiz2);
        nomJoeur=(TextView) findViewById(R.id.tvNomJoeur2);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView2);
        checkboxTableLayout2 = (TableLayout) findViewById(R.id.checkboxTableLayout2);
        btnQuiz=(Button) findViewById(R.id.btnQuizCheckbox);



        categorieSelectionnee = getIntent().getStringExtra("categorie");
       // questionsQuiz =new ArrayList<>();
        //questionsSynonmes = TestManagerQuestion.getAll();
       // lesReponses = TestManagerReponse.getAll();
        //lesChoix = TestManagerChoix.getAll();

        questionsQuiz =new ArrayList<>();
        questionsSynonmes = QuestionManager.questionsSynonymes(ctx);
        questionsAntonymes = QuestionManager.questionsAntonymes(ctx);
        questionsAdverbes = QuestionManager.questionsAdverbes(ctx);
        lesReponses = PlusieursReponsesManager.getAll(ctx);
        lesChoix = TestManagerChoix.getAll();


        Intent intent =getIntent();
        nomJoeur.setText(intent.getStringExtra("edPrenom"));

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
        changerQuestionSuivante();
    }


    private void changerQuestionSuivante(){

       // reponseQuestionCourante=null;

        if (laQuestion==null){
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

        int taille=reponseQuestionCourante.size();

        System.out.print("AVANT"+reponseQuestionCourante.size());
        Log.d("taille",""+taille);

        // get la reponse correct
        for (PlusieursReponses reponse : lesReponses){

            if(reponse.getId_question() == idQuestion){
                reponseQuestionCourante.add(reponse);
                System.out.print("PENDANT"+reponseQuestionCourante.size());
                Log.d("taille",""+reponseQuestionCourante.size());

                //reponseCorrect = reponse.getReponse();
            }

        }
        System.out.print("APRES"+reponseQuestionCourante.size());
        Log.d("taille",""+reponseQuestionCourante.size());


        // à chaque fois qu'on passe à la question suivante
        numeroQuestionCourrante++;

        // on affiche le numero question courante
        progressionQuiz.setText("Question: "+numeroQuestionCourrante);

        // efface textView resultat
        resultatTxtView.setText(" ");


        for (int row = 0; row < checkboxTableLayout2.getChildCount(); row++){
            ((TableRow) checkboxTableLayout2.getChildAt(row)).removeAllViews();
        }

        for (int row = 0; row < nombreLigneCheckbox; row++){
            TableRow ligneCheckboxCourrant = getTableRow(row);

            for (int column = 0; column < 3; column++){
                final CheckBox lesCheckBox = (CheckBox) getLayoutInflater().inflate(R.layout.choix_checkbox,null);


                Choix unChoix = lesChoix.get((row*3)+column);
                lesCheckBox.setText(unChoix.getChoix());
                lesCheckBox.setTextColor(getResources().getColor(R.color.bleuQuiz));
                lesCheckBox.setTextSize(18);
                lesCheckBox.setId(idChoixCheckbox);
                btnQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //   submitButton(lesCheckBox);

                        if(lesCheckBox.isChecked()&&lesCheckBox.getId()==idQuestion){
                            nbReponsesCorrect++;

                            // reponse correcte, on l'affiche dans le textView resultat
                            String bonneReponse = lesCheckBox.getText().toString();
                            resultatTxtView.setText("Correct !");
                            resultatTxtView.setTextColor(getResources().getColor(R.color.reponseCorrect));
                            scoreTextView.setText(nbReponsesCorrect+" / 20");
                            scoreTextView.setTextColor(getResources().getColor(R.color.reponseCorrect));
                           // Toast.makeText(Quiz_Checkbox_Activity.this,"CORRECT",Toast.LENGTH_LONG).show();



                        }
                        else {
                            resultatTxtView.setText("Incorrect !");
                            resultatTxtView.setTextColor(getResources().getColor(R.color.reponseIncorrect));
                            //Toast.makeText(Quiz_Checkbox_Activity.this,"MAUVAIS",Toast.LENGTH_LONG).show();

                        }
                        // on passe à la question suivante

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                changerQuestionSuivante();
                            }
                        },1000); // passe à la question suivante après 1 sec


                    }
                });

                lesCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     /*   if(lesCheckBox.isChecked()&&lesCheckBox.getId()==idQuestion) {
                            Toast.makeText(Quiz_Checkbox_Activity.this,"bonne reponse",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Quiz_Checkbox_Activity.this,"Dans le else",Toast.LENGTH_LONG).show();

                        }*/
                    }
                });

                ligneCheckboxCourrant.addView(lesCheckBox);


            }
        }


        for(PlusieursReponses reponse:reponseQuestionCourante){
            // on get les choix
            int row = random.nextInt(nombreLigneCheckbox);
            int column = random.nextInt(3);
            TableRow randomTableRow = getTableRow(row);
            ((CheckBox) randomTableRow.getChildAt(column)).setText(reponse.getReponse());
            ((CheckBox) randomTableRow.getChildAt(column)).setId(idQuestion);

        }

    }
    private TableRow getTableRow(int row){
        return (TableRow) checkboxTableLayout2.getChildAt(row);
    }
/*
    private void submitButton(CheckBox checkbox){

       // if(lesCheckBox.isChecked()&&lesCheckBox.getId()==idQuestion) {


            if(checkbox.getId() == idQuestion){
            nbReponsesCorrect++;

            // reponse correcte, on l'affiche dans le textView resultat
            String bonneReponse = checkbox.getText().toString();
            resultatTxtView.setText("Correct !");
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
                changerQuestionSuivante();
            }
        },1000); // passe à la question suivante après 1 sec


    }*/


}


