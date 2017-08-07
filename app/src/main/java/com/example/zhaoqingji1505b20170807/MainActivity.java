package com.example.zhaoqingji1505b20170807;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyView.onMyListener{
        private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView= (MyView) findViewById(R.id.myview);
        myView.getListener(this);
    }

    @Override
    public void goListener() {
        Toast.makeText(MainActivity.this,"点击更多",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void contentListener() {

    }

    @Override
    public void backListtener() {
        Toast.makeText(MainActivity.this,"点击返回",Toast.LENGTH_SHORT).show();
    }
}
