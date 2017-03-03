package com.example.estudiante.pdam1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by estudiante on 3/2/17.
 */

public class HangmanGameActivity extends AppCompatActivity {


    String word;
    ArrayList<Character> letters;
    String[] words = new String[10];
    EditText letra;
    TextView coveredText;
    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initializeObjectsView();
        startNewGame();
    }

    private void initializeObjectsView() {
        coveredText = (TextView) findViewById(R.id.covered_text);
        letra = (EditText) findViewById(R.id.enter_text);
    }

    private void startNewGame() {
        word = getRandomWord();
        coveredText.setText(generateCoveredText(word));
        findViewById(R.id.text_screen1);
    }

    private String generateCoveredText(String word) {
        for (int i = 0; i < word.length(); i++){
            sb.append("*");
        }
        return sb.toString();
    }


    public String getRandomWord() {
        words[0] = "padre";
        words[1] = "madre";
        words[2] = "juego";
        words[3] = "jueguete";
        words[4] = "perro";
        words[5] = "carro";
        words[6] = "computador";
        words[7] = "agujero";
        words[8] = "libro";
        words[9] = "nada";
        Random generator = new Random();
        int i = generator.nextInt(10);
        letters = new ArrayList<>();
        return words[i];
    }

    public void checkNSend(View view) {
        String c = letra.getText().toString();
        letra.setText("");
        char[] cArray = c.toCharArray();
        char[] wordArray = word.toCharArray();
        System.out.println(word);
        System.out.println(c);
        for(int i = 0; i < wordArray.length; i++){
            System.out.println(wordArray[i]);
            for (int j = 0; j < cArray.length; j ++){
                System.out.println(cArray[j]);
                if(wordArray[i] == cArray[j]){
                    uncoverLetter(i, cArray[j]);
                }
            }
        }
    }

    private void uncoverLetter(int i, char s) {
        String actualWord = sb.toString();
        char[] awArray = actualWord.toCharArray();
        System.out.println(actualWord);
        awArray[i] = s;
        StringBuffer sbb = new StringBuffer();
        for (int x=0;x<awArray.length;x++){
            sbb = sbb.append(awArray[x]);
        }
        sb = new StringBuilder();
        sb.append(sbb);
        coveredText.setText(sb.toString());
        if(!sb.toString().contains("*")){
            TextView tv = (TextView) findViewById(R.id.banner);
            tv.setText("Ha ganado!!!");
        }
    }
}
