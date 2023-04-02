package com.pkd.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* **********************************************
 * 프로젝트명 :  Week4
 * 작성일 : 2022.04.01
 * 프로그램 설명 :  4주차 실습
 ************************************************/
public class MainActivity extends AppCompatActivity {
    CheckBox cbEnable;
    CheckBox cbClickable;
    CheckBox cbRotate;

    Button button;

    EditText editText1;

    Button button2;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button) ;

        cbEnable = (CheckBox) findViewById(R.id.cb_enable);
        cbEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(button.isEnabled()) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        });

        cbClickable = (CheckBox) findViewById(R.id.cb_clickable);
        cbClickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(button.isClickable()) {
                    button.setClickable(false);
                } else {
                    button.setClickable(true);
                }
            }
        });
        cbRotate = (CheckBox) findViewById(R.id.cb_rotate);
        cbRotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                button.setRotation(button.getRotation()+45);
            }
        });


        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnKeyListener(new View.OnKeyListener() {
           @Override
           public boolean onKey(View view, int i, KeyEvent keyEvent) {
               Toast myToast = Toast.makeText(getApplicationContext(),editText1.getText(), Toast.LENGTH_SHORT);
               myToast.show();
               return false;
           }
        });

        button2 = (Button) findViewById(R.id.button2) ;
        imageView2 = (ImageView) findViewById(R.id.imageView2) ;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setRotation(imageView2.getRotation()+10);
            }
        });
    }
}