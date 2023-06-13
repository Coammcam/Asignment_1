package com.example.asignment_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class activity_phongban extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phongban);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phong ban");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ListView listViewPhongBan = findViewById(R.id.listview_phongban);
        ArrayList<PhongBan> listPhongBan = new ArrayList<>();

        listPhongBan.add(new PhongBan(R.drawable.ic_phongban_foreground, "Nhan su"));
        listPhongBan.add(new PhongBan(R.drawable.ic_phongban_foreground, "Hanh chinh"));
        listPhongBan.add(new PhongBan(R.drawable.ic_phongban_foreground, "Dao tao"));

        PhongBan_Adapter pbAdapter = new PhongBan_Adapter(activity_phongban.this, listPhongBan);
        listViewPhongBan.setAdapter(pbAdapter);
//        hienThiDuLieuMoiLenListView(listPhongBan);




    }

//    public void hienThiDuLieuMoiLenListView(ArrayList<PhongBan> newListView) {
//        PhongBan_Adapter phongBanAdapter = new PhongBan_Adapter(this, newListView);
//        listViewPhongBan.setAdapter(phongBanAdapter);
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,  menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search){
        } else {
            onBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}