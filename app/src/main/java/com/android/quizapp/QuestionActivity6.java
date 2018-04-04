package com.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mostafaf on 3/24/2018.
 */

public class QuestionActivity6 extends AppCompatActivity {

    static String threePyramidsAnswer;
    EditText threePyramids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_2);

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(R.string.question6_desc);

        TextView questionDesc1 = (TextView) findViewById(R.id.ques_desc1);
        questionDesc1.setText(R.string.question_desc1_2);

        TextView questionDesc2 = (TextView) findViewById(R.id.ques_desc2);
        questionDesc2.setText(R.string.question_desc2_2);

        ImageView pic = (ImageView) findViewById(R.id.pic);
        pic.setImageResource(R.drawable.three_pyramids);

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (IntroActivity.totalScore != 0) {
                    IntroActivity.totalScore = IntroActivity.totalScore - 1;
                }
                Intent questionActivity = new Intent(QuestionActivity6.this, QuestionActivity5.class);
                startActivity(questionActivity);
            }
        });

        Button forward = (Button) findViewById(R.id.forward);
        forward.setText(R.string.forward_done);
        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                threePyramids = (EditText) findViewById(R.id.three_pyramids_answer);
                QuestionActivity6.threePyramidsAnswer = threePyramids.getText().toString().toLowerCase();

                if (QuestionActivity6.threePyramidsAnswer.equals("khufu")) {
                    IntroActivity.totalScore = IntroActivity.totalScore + 1;
                }

                Intent questionActivity = new Intent(QuestionActivity6.this, ResultActivity.class);
                startActivity(questionActivity);

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, IntroActivity.totalScore + "/6", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void onBackPressed() {
        if (IntroActivity.totalScore != 0) {
            IntroActivity.totalScore = IntroActivity.totalScore - 1;
        }
        Intent questionActivity = new Intent(QuestionActivity6.this, QuestionActivity5.class);
        startActivity(questionActivity);
    }
}