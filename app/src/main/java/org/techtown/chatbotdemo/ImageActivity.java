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

        Intent i=getIntent();

        int position=i.getExtras().getInt("id");
        ImageGridAdapter imageAdapter=new ImageGridAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.imageIDs[position]);
    }
}