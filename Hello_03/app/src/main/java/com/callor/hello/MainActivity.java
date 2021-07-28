package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText input_id = null;
    private TextInputEditText input_pw = null;
    private TextInputEditText input_name = null;
    private TextInputEditText input_tel = null;
    private TextInputEditText input_addr = null;

    private Button btn_save = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_id = findViewById(R.id.txt_id);
        input_pw = findViewById(R.id.txt_pw);
        input_name = findViewById(R.id.txt_name);
        input_tel = findViewById(R.id.txt_tel);
        input_addr = findViewById(R.id.txt_addr);

        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener((view)->{

            String id = input_id.getText().toString();
            String pw = input_pw.getText().toString();
            String name = input_name.getText().toString();
            String tel = input_tel.getText().toString();
            String addr = input_addr.getText().toString();

            if(id.isEmpty()) {
                input_id.setError("ID 입력칸이 빈칸입니다");
                return;

            } else if(pw.isEmpty()) {
                input_pw.setError("PW 입력칸이 빈칸입니다");
                return;

            } else if(name.isEmpty()) {
                input_name.setError("이름 입력칸이 빈칸입니다");
                return;

            } else if(tel.isEmpty()) {
                input_tel.setError("전화번호 입력칸이 빈칸입니다");
                return;

            } else if(addr.isEmpty()) {
                input_addr.setError("주소 입력칸이 빈칸입니다");
                return;
            }

            Intent save_intent = new Intent(MainActivity.this,LoginActivity.class);

                save_intent.putExtra("user_id", id);
                save_intent.putExtra("user_pw", pw);
                save_intent.putExtra("user_name", name);
                save_intent.putExtra("user_tel", tel);
                save_intent.putExtra("user_addr", addr);
                startActivity(save_intent);
        });
    }
}