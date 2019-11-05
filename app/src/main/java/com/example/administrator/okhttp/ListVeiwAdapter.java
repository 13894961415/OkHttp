package com.example.administrator.okhttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/11/5.
 */

public class ListVeiwAdapter extends BaseAdapter {
    private ArrayList<ArrayList<HashMap<String,Object>>> mList;
    private Context mContext;
    private GridViewAdapter gridViewAdapter;
    private  MyClickListener mListener;

    //自定义接口，用于回调按钮点击事件到Activity
    public  interface MyClickListener{
        public void clickListener(View v, int parentPosition, int position);
    }
    public ListVeiwAdapter(ArrayList<ArrayList<HashMap<String, Object>>> mList, Context mContext, MyClickListener mListener) {
        super();
        this.mList = mList;
        this.mContext = mContext;
        this.mListener=mListener;
    }

    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return this.mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
    if (mList == null){
        return  null;
    }else {
        return  this.mList.get(position);
    }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.listview_item, null, false);

            holder.gridView = (fixedGridView) convertView.findViewById(R.id.fixed_gridView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        if (this.mList != null) {

            if (holder.gridView != null) {
                ArrayList<HashMap<String, Object>> arrayListForEveryGridView = this.mList.get(position);
                gridViewAdapter=new GridViewAdapter(mContext, arrayListForEveryGridView);
                holder.gridView.setAdapter(gridViewAdapter);
                setGridViewOnclik(holder.gridView,position);
                //setGridViewHeight( holder.gridView,convertView);
            }

        }

        return convertView;

    }
    public void setGridViewOnclik(GridView gridView, final int parentPosition) {
        if (gridViewAdapter !=null){
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "位置" + mList.get(parentPosition).get(position).get("son").toString(), Toast.LENGTH_SHORT).show();
                    mListener.clickListener(view,parentPosition,position);
                }
            });


        }
    }


    private class ViewHolder {

        fixedGridView gridView;
    }

}
