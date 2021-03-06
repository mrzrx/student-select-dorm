package com.example.kk.studentdorm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kk.util.NetUtil;


/**
 * Created by kk on 2017/10/31.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    private Button button_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dorm_info);

        button_log=(Button)findViewById(R.id.login);     //登录按钮
        button_log.setOnClickListener(this);

        if (NetUtil.getNetworkState(this) != NetUtil.NETWORN_NONE) {       //检查网络
            Toast.makeText(MainActivity.this,"网络OK！", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(MainActivity.this,"网络挂了！", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view){                  //跳转到登录界面
            Intent i=new Intent(this,LogIn.class);
            startActivity(i);
    }



}