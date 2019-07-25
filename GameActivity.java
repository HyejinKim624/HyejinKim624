package com.example.thesunandmoon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {
    //동아줄, 캐릭터, 게임클리어문구
    ImageView rope, charactor, clearText;
    //일시정지, 올라가기 버튼
    ImageView btPause, btUp;
    //배경 레이아웃
    ConstraintLayout backLayout;
    //미끄러짐
    Handler h;
    //게임 성공여부
    boolean completeGame = false;
    //터치 동작 가능
    boolean onTouch = true;
    //캐릭터 모션 바꾸기 위한 변수
    int i = 1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btPause = findViewById(R.id.btPause);
        btUp = findViewById(R.id.btUp);
        rope = findViewById(R.id.rope);

        charactor = findViewById(R.id.charactor);
        charactor.setImageDrawable(getResources().getDrawable(R.drawable.charactor1));

        clearText = findViewById(R.id.clearText);
        clearText.setVisibility(View.INVISIBLE);

        backLayout = findViewById(R.id.backLayout);
        backLayout.setBackgroundResource(R.drawable.background);

        //미끄러짐 구현
        h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                charactor.setY(charactor.getY() + 2);
                sendEmptyMessageDelayed(0, 30);
            }
        };

        //일시정지 버튼 구현
        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (completeGame == false)
                    pausedGame();
            }
        });

        //올라가기 구현
        btUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //게임 종료 판단
                if (charactor.getY() <= backLayout.getY())
                    clearGame();

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN && onTouch == false) {
                    //캐릭터 모션 바꾸기
                    if (i == 1) {
                        charactor.setImageDrawable(getResources().getDrawable(R.drawable.charactor2));
                        i++;
                    }else {
                        charactor.setImageDrawable(getResources().getDrawable(R.drawable.charactor1));
                        i--;
                    }

                    charactor.setY(charactor.getY() - 35);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //게임 완료했거나, 핸들러가 돌아가는 중에는 터치 X
        if (completeGame == true || h.hasMessages(0)) {
            return false;
        //핸들러 안돌아가는 중이면 시작하고 터치O
        }else if (onTouch == true) {
            h.sendEmptyMessage(0);
            onTouch = false;
            return true;
        }else {
            return false;
        }
    }

    //백키 -> 일시정지
    @Override
    public void onBackPressed() {
        if (completeGame == false)
            pausedGame();
    }

    //일시정지시 호출됨
    public void pausedGame() {
        //핸들러 멈추고
        h.removeMessages(0);
        //터치할 수 있게
        onTouch = true;
        Intent popup = new Intent(GameActivity.this, PausePopupActivity.class);
        startActivity(popup);
    }

    //게임 클리어시 호출됨
    public void clearGame() {
        //핸들러 종료
        h.removeMessages(0);
        //버튼 비활성화
        btUp.setEnabled(false);
        btPause.setEnabled(false);
        //클리어 문구 보이기
        clearText.setVisibility(View.VISIBLE);

        //2초 뒤 메인으로 나가기
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(GameActivity.this, MainActivity.class);
                mainIntent.putExtra("gameComplete", true);
                startActivity(mainIntent);
            }
        }, 2000);
    }
}