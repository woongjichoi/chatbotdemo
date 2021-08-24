package org.techtown.chatbotdemo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;



public class ImageClickListener implements OnClickListener {



    Context context;

    //-----------------------------------------------------------
    // imageID는 확대해서 보여줄 이미지의 리소스 ID입니다.

    int imageID;

    public ImageClickListener(Context context, int imageID) {
        this.context = context;
        this.imageID = imageID;
    }



    public void onClick(View v) {
        //---------------------------------------------------------
        // 인텐트 객체 정의
        // imageID의 값을 이 객체에 저장
        // 인텐트 객체 정의 후 이 액티비티를 실행

        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("image ID", imageID);
        context.startActivity(intent);
    }
}
