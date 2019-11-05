package com.example.administrator.okhttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/11/5.
 */

public class GridViewAdapter  extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, Object>> mList;
    private LayoutInflater inflater;

    public GridViewAdapter(Context mContext, ArrayList<HashMap<String, Object>> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mList == null)
            return 0;
        return this.mList.size();
    }

    @Override
    public Object getItem(int position) {
        if (mList == null)
            return null;
        return this.mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.gridview_item, null);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.imageView_gridView);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.textView_gridView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            viewHolder.mTextView.setText(position + "");
            if((position&1) == 1){
                viewHolder.mImageView.setImageResource(R.mipmap.wx);
            }else{
                viewHolder.mImageView.setImageResource(R.mipmap.qq);
            }
        }
        return convertView;
    }

    class ViewHolder {

        ImageView mImageView;
        TextView mTextView;
    }

}
