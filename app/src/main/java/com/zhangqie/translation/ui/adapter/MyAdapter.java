package com.zhangqie.translation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangqie.translation.R;


/**
 * Created by zhangqie on 2018/2/28.
 */

public class MyAdapter extends BaseAdapter{

    private String[] mList;

    private Context mContext;

    public MyAdapter(Context pContext,String[] pList) {
        this.mContext = pContext;
        this.mList = pList;
    }


    @Override
    public int getCount() {
        return mList.length;
    }



    @Override
    public Object getItem(int position) {
        return mList[position];
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(R.layout.item, null);

        if(convertView != null) {
            TextView textView=(TextView)convertView.findViewById(R.id.ttt);
            textView.setText(mList[position]);
        }
        return convertView;

    }

}
