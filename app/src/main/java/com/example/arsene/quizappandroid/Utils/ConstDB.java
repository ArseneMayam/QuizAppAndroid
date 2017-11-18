package com.example.arsene.quizappandroid.Utils;



public final class ConstDB {

    public static final String nomBd = "quizdb";


    public static class categorie{
        public static final String nomTable ="categorie";

        public static final  String id = "id";
        public static final  String nom = "nom";
    }

    public static final class choix{
        public static final String nomTable ="choix";

        public static final String id = "id";
        public static final String choix="id";
    }

    public static final class question{
        public static final String nomTable ="question";

        public static final String id ="id";
        public static final String id_questionnaire = "id_questionnaire";
        public static final String question = "question";
        public static final String type = "type";

    }

    public static final class questionnaire{
        public static final String nomTable ="questionnaire";

        public static String id = "id";
        public static String id_categorie = "id_categorie";

    }

    public static final class reponse{
        public static final String nomTable ="reponse";

        public static final String id = "id";
        public static final String id_question ="id_question";
        public static final String reponse ="reponse";

    }

    public static final class utilisateur{
        public static final String nomTable ="utilisateur";

        public static final String id = "id";
        public static final String prenom = "prenom";
        public static final String nom = "nom";
        public static final String pwd = "pwd";

    }

    public static final class score{
        public static final String nomTable ="score";

        public static final String id = "id";
        public static final String id_utilisateur = "id_utilisateur";
        public static final String score = "score";
        public static final String prenom = "prenom";

    }

}
