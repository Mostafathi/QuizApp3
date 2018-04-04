package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mostafaf on 3/24/2018.
 */

public class QuestionActivity5 extends AppCompatActivity {

    CheckBox answer1;
    CheckBox answer2;
    CheckBox answer3;
    CheckBox answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_1);

        answer1 = (CheckBox) findViewById(R.id.Multi_answer1);
        answer2 = (CheckBox) findViewById(R.id.Multi_answer2);
        answer3 = (CheckBox) findViewById(R.id.Multi_answer3);
        answer4 = (CheckBox) findViewById(R.id.Multi_answer4);

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(R.string.question5_desc);

        TextView questionDesc1 = (TextView) findViewById(R.id.ques_desc1);
        questionDesc1.setText(R.string.question_desc1_1);

        TextView questionDesc2 = (TextView) findViewById(R.id.ques_desc2);
        questionDesc2.setText(R.string.question_desc2_1);

        ImageView pic = (ImageView) findViewById(R.id.pic);
        pic.setImageResource(R.drawable.multi_ques);

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (IntroActivity.totalScore != 0) {
                    IntroActivity.totalScore = IntroActivity.totalScore - 1;
                }
                Intent questionActivity = new Intent(QuestionActivity5.this, QuestionActivity4.class);
                startActivity(questionActivity);
            }
        });

        Button forward = (Button) findViewById(R.id.forward);
        forward.setText(R.string.forward);
        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (answer1.isChecked() && answer2.isChecked() && !(answer3.isChecked()) && !(answer4.isChecked())) {
                    IntroActivity.totalScore = IntroActivity.totalScore + 1;
                }
                Intent questionActivity = new Intent(QuestionActivity5.this, QuestionActivity6.class);
                startActivity(questionActivity);
            }
        });
    }

    public void onBackPressed() {
        if (IntroActivity.totalScore != 0) {
            IntroActivity.totalScore = IntroActivity.totalScore - 1;
        }
        Intent questionActivity = new Intent(QuestionActivity5.this, QuestionActivity4.class);
        startActivity(questionActivity);
    }
}