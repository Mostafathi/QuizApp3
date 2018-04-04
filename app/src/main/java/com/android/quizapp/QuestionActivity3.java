package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by mostafaf on 3/24/2018.
 */

public class QuestionActivity3 extends AppCompatActivity {

    RadioButton answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(R.string.question3_desc);

        answer3 = (RadioButton) findViewById(R.id.answer3);

        ImageView pic = (ImageView) findViewById(R.id.pic);
        pic.setImageResource(R.drawable.usa);

        Button back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (IntroActivity.totalScore != 0) {
                    IntroActivity.totalScore = IntroActivity.totalScore - 1;
                }
                Intent questionActivity = new Intent(QuestionActivity3.this, QuestionActivity2.class);
                startActivity(questionActivity);
            }
        });

        Button forward = (Button) findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (answer3.isChecked()) {
                    IntroActivity.totalScore = IntroActivity.totalScore + 1;
                }
                Intent questionActivity = new Intent(QuestionActivity3.this, QuestionActivity4.class);
                startActivity(questionActivity);
            }
        });
    }

    public void onBackPressed() {
        if (IntroActivity.totalScore != 0) {
            IntroActivity.totalScore = IntroActivity.totalScore - 1;
        }
        Intent questionActivity = new Intent(QuestionActivity3.this, QuestionActivity2.class);
        startActivity(questionActivity);
    }
}
