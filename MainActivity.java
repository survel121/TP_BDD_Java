package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

/*
  Je t'ai mis en commentaire toutes les fonctions de création, suppression et mise à jour pour que tu ne crée pas en boucle les même choses
  Tu va surement devoir copier la classe et ajouter tous les packages nécessaires avec le raccourci "Alt + entrée" en les ajoutant 1 par 1,
        ça tévitera des problèmes sur l'intégration de ce code dans ton projet
        
  Rappel : Tu peux tout modifier, il n'y a pas de licence sur les fichiers de ce projet
*/


public class MainActivity extends AppCompatActivity {

    Manager myManager;
    TextView myTxtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTxtView1 = findViewById(R.id.txtView1);

        myManager = new Manager(this);
        //myManager.insert_Data();
        //myManager.update_Data();
        //myManager.delete_Data();
        //myManager.delete_Table();
        String resultat = myManager.read_Data();
        myTxtView1.setText(resultat);
    }
}
