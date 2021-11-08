package org.techtown.chatbotdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class cart_Adapter extends BaseAdapter {

    private Context mContext;

    private List<cart_item> mItems = new ArrayList<cart_item>();

    public cart_Adapter(Context context) {
        mContext = context;
    }

    public void addItem(cart_item it) {
        mItems.add(it);
    }

    public void setListItems(List<cart_item> lit) {
        mItems = lit;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        try {
            return mItems.get(position).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        cart_view itemView;
        if (convertView == null) {
            itemView = new cart_view(mContext, mItems.get(position));
        } else {
            itemView = (cart_view) convertView;

            itemView.setIcon(mItems.get(position).getIcon());
            itemView.setText(0, mItems.get(position).getData(0));
            itemView.setText(1, mItems.get(position).getData(1));
            itemView.setText(2, mItems.get(position).getData(2));
        }

        return itemView;
    }

}
