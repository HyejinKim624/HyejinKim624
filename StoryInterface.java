package com.example.thesunandmoon;

import android.content.Intent;
import android.widget.ImageButton;

import androidx.constraintlayout.widget.ConstraintLayout;

//스토리
public interface StoryInterface {
    //게임완료 전에 볼 수 있는 스토리
    ImageButton story1 = null;
    //게임완료 후 볼 수 있는 스토리
    ImageButton story2 = null;
    //뒤로가기
    //인텐트로 뒤로가기
    ImageButton btBack = null;
    //배경 삽화
    ConstraintLayout backLayout = null;
    Intent story1Intent = null;
    Intent story2Intent = null;
    //메인 화면으로 돌아가는 것도 인텐트
    //백버튼을 눌러도 메인으로 돌아갈 수 있음
    Intent mainIntent = null;
    //4번
    //true - story2활성화, false - story2비활성화
    //true - main에 넘김, false - main에 안넘김
    boolean gameComplete = false;
}
