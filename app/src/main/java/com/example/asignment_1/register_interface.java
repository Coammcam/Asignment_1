package com.example.asignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_interface extends AppCompatActivity {

    public static String KEY_USERNAME = "user_name";
    public static String KEY_PASSWORD = "password";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnLogin = findViewById(R.id.btn_login);
        Button btnBack = findViewById(R.id.btn_back);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        EditText edtConfirmPassword = findViewById(R.id.edt_confirmPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aUserName = edtUsername.getText().toString();
                String aPassWord = edtPassword.getText().toString();
                String aConfirmPassword = edtConfirmPassword.getText().toString();

                if (aUserName == null || aUserName.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Username trong", Toast.LENGTH_SHORT).show();
                } else if (aPassWord == null || aPassWord.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Password trong", Toast.LENGTH_SHORT).show();
                } else if (aConfirmPassword == null || aPassWord.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Confirm password trong", Toast.LENGTH_SHORT).show();
                } else if (!aConfirmPassword.equals(aPassWord)) {
                    Toast.makeText(getApplicationContext(), "confirm password khong dung", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), login_interface.class);

                    intent.putExtra(KEY_USERNAME, aUserName);
                    intent.putExtra(KEY_PASSWORD, aPassWord);

                    intent.putExtra("number", 18);

                    startActivity(intent);
                }

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login_interface.class);
                startActivity(intent);
            }
        });
    }


}