package com.example.thesunandmoon;

import android.content.Intent;

import androidx.constraintlayout.widget.ConstraintLayout;

//첫번째 이야기
//중간데 백키를 눌러도 뒤로갈 수 있음
public interface Story1Interface {
    //배경 삽화
    ConstraintLayout back = null;
    //초안
    //화면에 꽉 채운 레이아웃
    //햇님달님 이야기를 이미지 소스로 레이아웃에 넣음
    //터치리스너로 클릭하면 다음페이지(레이아웃의 이미지소스 갱신) 보여줌
    ConstraintLayout cartoon = null;
    //페이지를 카운트
    int pageCount = 0;
    //마지막 페이지가 되면 자동으로 인텐트 실행
    Intent storyIntent = null;
}
