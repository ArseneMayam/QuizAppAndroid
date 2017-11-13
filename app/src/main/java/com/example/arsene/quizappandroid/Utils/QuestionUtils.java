package com.example.arsene.quizappandroid.Utils;

import com.example.arsene.quizappandroid.entities.Question;

import java.util.ArrayList;

/**
 * Created by arsenemayam on 13/11/17.
 */

public class QuestionUtils {

    public static ArrayList<String> getString(ArrayList<Question> questions){
        ArrayList<String> retour = new ArrayList<>();

        for(Question q :questions ){
            retour.add(q.toString());
        }
        return retour;
    }
}
