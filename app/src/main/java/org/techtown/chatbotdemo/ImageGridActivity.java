package org.techtown.chatbotdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ImageGridActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger_menu_page);

        //-----------------------------------------------------------------------

        GridView gridViewImages = (GridView)findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}