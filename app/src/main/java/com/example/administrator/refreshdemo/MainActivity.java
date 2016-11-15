package com.example.administrator.refreshdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout sw;
    private TextView tv;
    private int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = (SwipeRefreshLayout) findViewById(R.id.sw);
        sw.setOnRefreshListener(this);

        tv = (TextView) findViewById(R.id.tv);
        b = 0;

        // 这个方法是初始化的时候去加载网络数据
        sw.post(new Runnable() {
            @Override
            public void run() {
                tv.setText(b + "");
            }
        });
    }

    @Override
    public void onRefresh() {
        sw.setRefreshing(true); // 这个是请求数据之前调用
        sw.post(new Runnable() {
            @Override
            public void run() {
                int a =  b + 1;
                b = a;
                tv.setText(a + "");
            }
        });
        sw.setRefreshing(false); // 这个是在请求数据之后调用
    }
}
