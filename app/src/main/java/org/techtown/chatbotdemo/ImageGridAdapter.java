package org.techtown.chatbotdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageGridAdapter extends BaseAdapter {

    private Context context;

    public int[] imageIDs = new int[] {
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

    public ImageGridAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return (null != imageIDs) ? imageIDs.length : 0;
    }

    public Object getItem(int position) {
        return (null != imageIDs) ? imageIDs[position] : 0;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;

        if (null != convertView)
            imageView = (ImageView)convertView;
        else {
            //---------------------------------------------------------------
            // GridView 뷰를 구성할 ImageView 뷰의 비트맵을 정의

            Bitmap bmp
                    = BitmapFactory.decodeResource(context.getResources(), imageIDs[position]);
            bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);

            //---------------------------------------------------------------
            // 뷰에 지정할 이미지는 비트맵 객체

            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);

            imageView.setImageBitmap(bmp);

            //---------------------------------------------------------------
            // 사진의 클릭을 처리하는 ImageClickListener 객체를 정의
            // 그것을 ImageView의 리스너로 설정

            ImageClickListener imageViewClickListener
                    = new ImageClickListener(context, imageIDs[position]);
            imageView.setOnClickListener(imageViewClickListener);
        }

        return imageView;
    }

}