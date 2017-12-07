package com.example.administrator.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb = (CheckBox) findViewById(R.id.cb);
        // 回显
        HashMap<String, String> hashMap = FileUtil.read(this);
        if (hashMap.size() > 0) {
            et_username.setText(hashMap.get("username"));
            et_password.setText(hashMap.get("password"));
            cb.setChecked(true);
        }

    }

    // 点击按钮,登录
    public void login(View view) {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isChecked = cb.isChecked();
        if (isChecked) {
            boolean save = FileUtil.save(this, username, password);
            if (save) {
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ResultActivity.class));
            } else {
                Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "无需保存", Toast.LENGTH_SHORT).show();
        }
    }

}
