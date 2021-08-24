package org.techtown.chatbotdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_image);

        //----------------------------------------------------------------
        // 이미지 확대 view 설정
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        setImage(imageView);
    }

    private void setImage(ImageView imageView) {
        //----------------------------------------------------------------
        // 초기 액티비티의 GridView 뷰의 이미지 항목을 클릭할 때 생성된 인텐트
        // getIntent 메소드 호출하여 접근
        Intent receivedIntent = getIntent();

        //----------------------------------------------------------------
        // 이미지의 ID 인텐트 -> ImageView 이미지 리소스로 설정

        int imageID = (Integer)receivedIntent.getExtras().get("image ID");
        imageView.setImageResource(imageID);
    }
}