package com.example.prishanf.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView resultTextView;
    TextView timerTextView;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = findViewById(R.id.questionTextView);
        resultTextView = findViewById(R.id.resultTextView);
        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        setNextQuestion();
    }

    public void setNextQuestion(){

        Random random = new Random();
        int part1 = random.nextInt(19) + 1;
        int part2 = random.nextInt(19) + 1;
        questionTextView.setText(part1 + " + " + part2);
        int correctAnswer = part1 + part2;

        locationOfCorrectAnswer = random.nextInt(4);

        answers.clear();

        for (int i=0; i<4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(part1+part2);
            } else {
                int wrongAnswer = random.nextInt(41);

                while (wrongAnswer == part1+part2) {
                    wrongAnswer = random.nextInt(41);
                }

                answers.add(wrongAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));




    }

    public void chooseAnswer(View view){

        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("Correct!");
            score++;
        } else {
            resultTextView.setText("Wrong :(");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        setNextQuestion();
    }
}
