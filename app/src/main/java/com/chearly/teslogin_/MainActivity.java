package com.chearly.teslogin_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvUsername;
    private Button btnLogout;
    private Utilities utilities = new Utilities();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tv_username);
        btnLogout = findViewById(R.id.btn_logout);

        if (utilities.isLogin(this,"xUsername")){
            //kehalaman login
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            String username = utilities.getPref(this,"xUsername");
            tvUsername.setText(username);

        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utilities.setPref(MainActivity.this,"xUsername",null);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}