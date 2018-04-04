package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mostafaf on 3/24/2018.
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("Thank You,\n" + IntroActivity.name);
        TextView fullMark = (TextView) findViewById(R.id.full_mark);
        if (IntroActivity.totalScore == 6) {
            fullMark.setText(R.string.full_mark);
        } else {
            fullMark.setText(R.string.not_all_correct);
        }
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(IntroActivity.totalScore + "/6");
    }

    @Override
    public void onBackPressed() {
        if (IntroActivity.totalScore != 0) {
            IntroActivity.totalScore = IntroActivity.totalScore - 1;
        }
        Intent questionActivity = new Intent(ResultActivity.this, QuestionActivity6.class);
        startActivity(questionActivity);
    }
}
