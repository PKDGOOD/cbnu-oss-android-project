package com.pkd.caculatorproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* **********************************************
 * 프로젝트명 :  CaculatorProject
 * 작성일 : 2022.04.02
 * 프로그램 설명 :  간단 계산기 만들기
 ************************************************/
public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    List<Button> btnNumList = new ArrayList<>();
    List<Integer> btnNumIdList = Arrays.asList(R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3,
            R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8,
            R.id.btnNum9);
    Button btnPlus, btnMinus, btnMul, btnDiv;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum2 = (EditText) findViewById(R.id.editNum2);

        btnNumIdList.forEach(id -> btnNumList.add((Button) findViewById(id)));
        btnNumList.forEach(btn -> {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (editNum1.isFocused() == true) {
                            editNum1.setText(editNum1.getText().toString() + btn.getText().toString());
                        } else  if (editNum2.isFocused() == true) {
                            editNum2.setText(editNum2.getText().toString() + btn.getText().toString());
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        );

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        textView = (TextView) findViewById(R.id.textView);

        btnPlus.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int result = Integer.parseInt(editNum1.getText().toString()) + Integer.parseInt(editNum2.getText().toString());
                textView.setText("계산 결과 : " + result);
                return false;
            }
        });

        btnMinus.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int result = Integer.parseInt(editNum1.getText().toString()) - Integer.parseInt(editNum2.getText().toString());
                textView.setText("계산 결과 : " + result);
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int result = Integer.parseInt(editNum1.getText().toString()) * Integer.parseInt(editNum2.getText().toString());
                textView.setText("계산 결과 : " + result);
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                int result = Integer.parseInt(editNum1.getText().toString()) / Integer.parseInt(editNum2.getText().toString());
                textView.setText("계산 결과 : " + result);
                return false;
            }
        });
    }
}