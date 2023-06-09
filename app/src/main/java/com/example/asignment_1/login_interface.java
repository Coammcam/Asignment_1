package com.example.asignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login_interface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);

        String aUserName = getIntent().getStringExtra(register_interface.KEY_USERNAME);
        String aPassWord = getIntent().getStringExtra(register_interface.KEY_PASSWORD);

        edtUsername.setText(aUserName);
        edtPassword.setText(aPassWord);

        int number = getIntent().getIntExtra("number", 0);
        Toast.makeText(this, number + "", Toast.LENGTH_SHORT).show();

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register_interface.class);
                startActivity(intent);
            }
        });

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), manage_department.class);
                startActivity(intent);
            }
        });


        /*CheckBox rememberme = findViewById(R.id.rememberme);
        SharedPreferences sharedPreferences = getSharedPreferences("andrrac", MODE_PRIVATE);
        rememberme.setChecked(sharedPreferences.getBoolean("rememberme", false));

        rememberme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("andrrac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("rememberme", rememberme.isChecked());
                editor.apply();
            }
        });*/

        CheckBox remember = findViewById(R.id.rememberme);
        SharedPreferences sharedPreferences = getSharedPreferences("android", MODE_PRIVATE);
        remember.setChecked(sharedPreferences.getBoolean("rememberme", false));

        remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences1 = getSharedPreferences("android", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putBoolean("rememberme", remember.isChecked());
                editor.apply();
            }
        });


    }



}