package com.example.thesunandmoon;

import android.content.Intent;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

//시작화면
//타이틀바는 모든 화면에서 없앰
public interface IntroInterface {
    //1.3
    ImageView startText = null;
    //1.2
    ConstraintLayout backLayout = null;
    //2.1
    //아무곳이나 터치하면 화면 넘어감
    Intent intent = null;
}
