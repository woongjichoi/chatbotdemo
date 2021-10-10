package org.techtown.chatbotdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ImageGridActivity extends Activity {

    //------------------------------------------------------------

    private int[] imageIDs = {
            R.drawable.shushu,
            R.drawable.bgg,
            R.drawable.bigmac,
            //R.drawable.burger,
            R.drawable.cheese,
            R.drawable.double_bgg,
            R.drawable.double_cheese,
            R.drawable.egg_bgg,
            R.drawable.mac_chicken,
            R.drawable.shub,
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger_menu_page);

        //-----------------------------------------------------------------------

        GridView gridViewImages = (GridView)findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this, imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}