package com.example.zhaoqingji1505b20170807;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 赵庆吉 on 2017/8/7.
 */

public class MyView extends LinearLayout{
    private onMyListener listener;

    public MyView(Context context) {
        super(context);
    }
public  void getListener(onMyListener listener){
    this.listener=listener;
}
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.myview,this);
        final TextView go= (TextView) findViewById(R.id.go);
        final TextView content=(TextView)findViewById(R.id.content);
        final TextView back=(TextView)findViewById(R.id.back);
        go.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        listener.goListener();
                        go.setBackgroundColor(Color.RED);
                        break;
                    case MotionEvent.ACTION_UP:
                        go.setBackgroundColor(Color.BLUE);
                        break;
                }
                return true;
            }
        });

       back.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        listener.backListtener();
                        back.setBackgroundColor(Color.RED);
                        break;
                    case MotionEvent.ACTION_UP:
                        back.setBackgroundColor(Color.BLUE);
                        break;
                }
                return true;
            }
        });
        //定义属性
        if(attrs!=null){
            TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.MyView);
            float aFloat=array.getFloat(R.styleable.MyView_Back_Size,12);
            int color=array.getColor(R.styleable.MyView_Back_Color,Color.BLACK);
            int backg=array.getColor(R.styleable.MyView_Back_Back,Color.BLUE);
            back.setBackgroundColor(backg);
            back.setTextColor(color);
            back.setTextSize(aFloat);

            float gFloat=array.getFloat(R.styleable.MyView_Go_Size,12);
            int gcolor=array.getColor(R.styleable.MyView_Go_Color,Color.BLACK);
            int gbackg=array.getColor(R.styleable.MyView_Go_Back,Color.BLUE);
            go.setBackgroundColor(gbackg);
            go.setTextColor(gcolor);
            go.setTextSize(gFloat);

            float cFloat=array.getFloat(R.styleable.MyView_Co_Size,12);
            int ccolor=array.getColor(R.styleable.MyView_Co_Color,Color.BLACK);
            int cbackg=array.getColor(R.styleable.MyView_Co_Back,Color.YELLOW);
            content.setBackgroundColor(cbackg);
            content.setTextColor(ccolor);
            content.setTextSize(cFloat);
        }
    }
    //监听事件接口
    public interface onMyListener{
        void goListener();
        void contentListener();
        void backListtener();
    }
}
