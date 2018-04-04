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

public class QuestionActivity1 extends AppCompatActivity {

    RadioButton answer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question);

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(R.string.question1_desc);

        answer1 = (RadioButton) findViewById(R.id.answer1);

        ImageView pic = (ImageView) findViewById(R.id.pic);
        pic.setImageResource(R.drawable.egypt);

        Button back = (Button) findViewById(R.id.back);
        back.setText(R.string.back_to_home);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (IntroActivity.totalScore != 0) {
                    IntroActivity.totalScore = IntroActivity.totalScore - 1;
                }
                Intent questionActivity = new Intent(QuestionActivity1.this, IntroActivity.class);
                startActivity(questionActivity);
            }
        });
        Button forward = (Button) findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (answer1.isChecked()) {
                    IntroActivity.totalScore = IntroActivity.totalScore + 1;
                }
                Intent questionActivity = new Intent(QuestionActivity1.this, QuestionActivity2.class);
                startActivity(questionActivity);
            }
        });
    }

    public void onBackPressed() {

        if (IntroActivity.totalScore != 0) {
            IntroActivity.totalScore = IntroActivity.totalScore - 1;
        }

        Intent questionActivity = new Intent(QuestionActivity1.this, IntroActivity.class);
        startActivity(questionActivity);
    }
}
