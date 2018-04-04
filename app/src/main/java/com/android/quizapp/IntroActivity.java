package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroActivity extends AppCompatActivity {

    static int totalScore;
    static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button startQuizButton = (Button) findViewById(R.id.start_quiz);

        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name_entry);
                IntroActivity.name = name.getText().toString();
                Intent questionActivity = new Intent(IntroActivity.this, QuestionActivity1.class);
                startActivity(questionActivity);
            }


        });
    }
}
