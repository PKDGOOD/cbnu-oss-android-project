package com.pkd.datetimeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart;
    RadioButton radioDate;
    RadioButton radioTime;

    DatePicker datePicker;
    TimePicker timePicker;

    Button btnEnd;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer1);
        btnStart = findViewById(R.id.btnStart);

        radioDate = findViewById(R.id.radioDate);
        radioTime = findViewById(R.id.radioTime);
        timePicker = findViewById(R.id.timepicker);
        datePicker = findViewById(R.id.datepicker);

        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        btnEnd = findViewById(R.id.btnEnd);
        resultText = findViewById(R.id.resultText);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                String tmp = "";
                tmp = datePicker.getYear() + "년 " + datePicker.getMonth() + "월 " + datePicker.getDayOfMonth() + "일 ";
                tmp += timePicker.getHour() + "시 " + timePicker.getMinute() + "분에 예약됨";
                resultText.setText(tmp);
            }
        });
    }
}