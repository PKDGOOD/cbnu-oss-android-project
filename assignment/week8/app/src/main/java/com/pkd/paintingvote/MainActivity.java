package com.pkd.paintingvote;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/* **********************************************
 * 프로젝트명 :  PaintingVote
 * 파일명 : MainActivity
 * 작성일 : 2022.04.30
 * 프로그램 설명 :  9개의 명화를 출력하고 선택시 투표수 1씩 증가시킨다.
 ************************************************/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        ImageView image[] = new ImageView[9];
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

        final String imgName[] = { "천지창조", "atom for peace", "밴조 연주가",
                "새", "캉캉", "포도", "유럽인 초상화", "뱀 피리부는 남자",
                "터키인 초상화" };

        for (int i = 0; i < imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(v -> {

                voteCount[index]++;
                Toast.makeText(getApplicationContext(),
                        imgName[index] + ": 총 " + voteCount[index] + " 표",
                        Toast.LENGTH_SHORT).show();
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),
                    ResultActivity.class);
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);
            startActivity(intent);
        });

    }
}