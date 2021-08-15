package com.example.vxhelper;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class uesrAddActivity extends AppCompatActivity {

    private Button btn_test;
    private Button btn_pass;
    private Switch sw_vv;
    private EditText tv_username;
    private ImageButton imgBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);

        btn_test = findViewById(R.id.btn_test);
        btn_pass = findViewById(R.id.btn_passed);
        imgBtn = findViewById(R.id.btn_image);
        sw_vv = findViewById(R.id.sw_voice_video);
        tv_username = findViewById(R.id.tv_username);

    }


}
