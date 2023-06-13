package com.example.asignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class manage_department extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_department);

        ImageView phongban = findViewById(R.id.phongban);
        ImageView nhanvien = findViewById(R.id.nhanvien);
        ImageView thoat = findViewById(R.id.thoat);

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thoat = new Intent(manage_department.this, login_interface.class);
                startActivity(thoat);
            }
        });

        phongban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phongban = new Intent(manage_department.this, activity_phongban.class);
                startActivity(phongban);
            }
        });
        
        nhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhanvien = new Intent(manage_department.this, activity_nhanvien.class);
                startActivity(nhanvien);
            }
        });
    }
}