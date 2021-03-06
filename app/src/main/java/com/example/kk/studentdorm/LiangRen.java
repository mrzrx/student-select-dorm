package com.example.kk.studentdorm;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by kk on 2017/12/25.
 */

public class LiangRen extends Activity implements View.OnClickListener{
    private ImageView back;
    private Button jixuBtn;
    private EditText xueHao,jiaoYan;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liangren);

        back=(ImageView)findViewById(R.id.back);         //返回按钮
        back.setOnClickListener(this);

        jixuBtn=(Button)findViewById(R.id.jixu);         //继续按钮
        jixuBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back){             //返回到人数界面
            Intent intent = new Intent(LiangRen.this, StudentMessege.class);
            startActivity(intent);
            finish();
        }

        if(v.getId()==R.id.jixu){               //跳转到选择界面
            xueHao=(EditText)findViewById(R.id.xiexuehao);
            jiaoYan=(EditText)findViewById(R.id.xiejiaoyanma);

            // 存储同住人信息
            SharedPreferences.Editor editor = getSharedPreferences("config",MODE_PRIVATE).edit();
            editor.putString("xueHao",xueHao.getText().toString());
            editor.putString("jiaoYan",jiaoYan.getText().toString());
            editor.putInt("Num",2);
            editor.commit();


            Intent intent = new Intent(LiangRen.this, Select.class);
            startActivity(intent);
        }

    }
}