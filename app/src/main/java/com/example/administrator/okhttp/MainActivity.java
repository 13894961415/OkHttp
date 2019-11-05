package com.example.administrator.okhttp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity implements ListVeiwAdapter.MyClickListener{
    private ListView mListView;
    private ListVeiwAdapter mLAdapter;
    private ArrayList<ArrayList<HashMap<String, Object>>> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.lv);
        mLAdapter = new ListVeiwAdapter(mData, MainActivity.this,this);
        mListView.setAdapter(mLAdapter);
    }
    private void initData() {
        mData = new ArrayList<ArrayList<HashMap<String, Object>>>();
        HashMap<String, Object> hashMap = null;
        ArrayList<HashMap<String, Object>> sonData;

        for (int i = 0; i < 15; i++) {
            sonData = new ArrayList<HashMap<String, Object>>();
            for (int k = 0; k < 10; k++) {
                hashMap = new HashMap<String, Object>();
                hashMap.put("son", "i=" + i + " ,k=" + k);
                sonData.add(hashMap);
            }
            mData.add(sonData);
        }

    }
    @Override
    public void clickListener(View v, int parentPosition, int position) {
        Log.e("liu","接收到点击属性 行："+parentPosition+" 行内："+position);
    }
}
