package org.techtown.chatbotdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HamburgerMenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger_menu_page);

        GridView gridViewImages=(GridView)findViewById(R.id.gridViewImages);
        gridViewImages.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        private Integer[] images={R.drawable.shushu,
                R.drawable.bgg,
                R.drawable.bigmac,
                //R.drawable.burger,
                R.drawable.cheese,
                R.drawable.double_bgg,
                R.drawable.double_cheese,
                R.drawable.egg_bgg,
                R.drawable.mac_chicken,
                R.drawable.shub};

        public ImageAdapter(Context con){
            this.context=con;
        }

        public int getCount(){
            return images.length;
        }

        public Object getItem(int pos){
            return null;
        }

        public long getItemId(int pos){
            return 0;
        }

        public View getView(int pos, View convertView, ViewGroup parent){
            ImageView imageView;

            if (convertView==null){
                imageView=new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(300,300));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(10,10,10,10);
            } else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(images[pos]);

            return imageView;
        }
    }
}