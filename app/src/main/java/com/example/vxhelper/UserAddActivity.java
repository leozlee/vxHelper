package com.example.vxhelper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private Button btn_pass;
    private Button btn_delete;
    private Switch sw_vv;
    private EditText et_username;
    private ImageButton imgBtn;
    private Switch sw_photo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.tb_useradd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true);           //设置返回键可用
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
        btn_pass = findViewById(R.id.btn_passed);
        btn_pass.setOnClickListener(this);
        imgBtn = findViewById(R.id.btn_image);
        imgBtn.setOnClickListener(this);
        sw_vv = findViewById(R.id.sw_voice_video);
        sw_photo = findViewById(R.id.sw_photo);
        et_username = findViewById(R.id.tv_username);

    }


    private void complete() {
        if (!validate()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("action", "add");
        intent.putExtra("name", et_username.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    private boolean validate() {
        if (et_username.getText().equals("")) {
            Toast.makeText(AppContext.getAppContext(), "请输入正确的微信用户名称", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    private void deleteUser() {
        Intent intent = new Intent();
        intent.putExtra("action", "delete");
        intent.putExtra("name", et_username.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                break;
            case R.id.btn_passed:
                complete();
                break;
            case R.id.btn_image:
                break;
            case R.id.btn_delete:
                deleteUser();
                break;
            default:
                break;
        }

    }

}
