package com.example.thesunandmoon;

import android.content.Intent;
import android.widget.ImageButton;

import androidx.constraintlayout.widget.ConstraintLayout;

//메인화면
public interface MainInterface {
    //3번 보고 버튼
    ImageButton btStory = null;
    ImageButton btGame = null;
    ImageButton btExplain = null;
    ImageButton btClose = null;
    //종료하겠냐는 팝업
    //인비저블->비저블
    ConstraintLayout sutGameLayout = null;
    ImageButton btSutGame = null;
    //배경 이미지 설정을 위해
    ConstraintLayout back = null;
    //3.1-1
    static boolean storyClicked = false;
    //3.2
    Intent storyIntent = null;
    //3.3
    Intent gameIntent = null;
    //3.4
    Intent expIntent = null;
    //4번
    //이지모드, 하드모드 모두 클리어해야 true
    //게임은 몇번이고 재도전 가능 (이미 클리어했어도 가능)
    static boolean gameComplete = false;
}
