package com.example.android.clicker;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.clicker.R;

public class PlayActivity extends AppCompatActivity {

    private TextView timer;
    private TextView count_text_view;
    private Button click;
    private TextView znach;
    public static int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        timer = findViewById(R.id.timer);
        click = findViewById(R.id.click);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awokeTimer();
            }
        });


    }

    private void awokeTimer() {

        display(count);
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

                timer.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {

                Inc();
            }


        }.start();

        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                doTap();
            }
        });
    }

    private void doTap() {
        count++;
        display(count);

    }

    public void Inc() {

        Intent perehod = new Intent(this, ResultActivity.class);
        perehod.putExtra("intVariableName", count);
        startActivity(perehod);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.count_text_view);
        quantityTextView.setText("" + number);
    }
}