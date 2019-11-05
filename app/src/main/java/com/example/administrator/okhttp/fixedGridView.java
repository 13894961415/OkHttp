package com.example.administrator.okhttp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by B05 on 2018/8/21.
 */

public class fixedGridView extends GridView {




    Context context;

    public fixedGridView(Context context) {
        super(context);
        this.context =context;
    }

    public fixedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context =context;
    }

    /**
     * 设置不滚动
     * makeMeasureSpec函数中第一个函数决定布局空间的大小，第二个参数是布局模式
     MeasureSpec.AT_MOST的意思就是子控件需要多大的控件就扩展到多大的空间
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> Integer.parseInt(context.getString(R.string.numColumns)),MeasureSpec.AT_MOST);//把测量的值传入onMeasure 重绘布局的高度
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
