package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_msg = findViewById(R.id.txt_user_msg);

        Intent intent = getIntent();

        String u_id = intent.getExtras().getString("user_id");
        String u_pw = intent.getExtras().getString("user_pw");
        String u_name = intent.getExtras().getString("user_name");
        String u_tel = intent.getExtras().getString("user_tel");
        String u_addr = intent.getExtras().getString("user_addr");

        String msg = String.format(" User ID : %s\n User PW : %s \n " +
                                "User Name : %s \n User Tel : %s \n User Addr : %s",
                                    u_id, u_pw, u_name, u_tel, u_addr);

                txt_msg.setText(msg);

    }
}