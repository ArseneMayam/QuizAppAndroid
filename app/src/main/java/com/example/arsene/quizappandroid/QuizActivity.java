package com.example.arsene.quizappandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    Context ctx;
    // les différents composants du layout
    TextView timerQuiz;
    TextView progressionQuiz;
    TextView questionTxtView;
    TextView resultatTxtView;
    TableLayout buttonTableLayout;

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
}
