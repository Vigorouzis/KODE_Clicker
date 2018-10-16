package com.example.android.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int intValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("intVariableName", 0);
        display(intValue);
        if (intValue >= 50) {
            TextView ocenka = (TextView) findViewById(R.id.ocenka);
            ocenka.setText("Отлично");
        } else if ((intValue >= 30) && (intValue < 50)) {
            TextView ocenka = (TextView) findViewById(R.id.ocenka);
            ocenka.setText("Хорошо");
        } else if (intValue < 30) {
            TextView ocenka = (TextView) findViewById(R.id.ocenka);
            ocenka.setText("Плохо");
        }
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.result_count);
        quantityTextView.setText("" + number);
    }

    private void Increment(View view) {

        Intent restart = new Intent(this, PlayActivity.class);
        startActivity(restart);
    }

}

