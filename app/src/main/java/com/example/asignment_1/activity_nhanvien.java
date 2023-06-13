package com.example.asignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class activity_nhanvien extends AppCompatActivity {


    ListView listViewNhanVien;
    ArrayList<NhanVien> listNhanVien;

    public static String KEY_FILE_STAFF = "nhanvien.txt";

    public static String KEY_UPDATE = "update_nhanvien";

    public static String KEY_NHAN_VIEN = "KEY_NHAN_VIEN";

    int update_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);

        TextView them = findViewById(R.id.them_nhanvien);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nhan vien");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewNhanVien = findViewById(R.id.listView_nhanvien);
        listNhanVien = new ArrayList<>();


        listNhanVien.add(new NhanVien(" NV002", " Nguyen Van C", "Hanh chinh"));
        listNhanVien.add(new NhanVien(" NV003", " Nguyen Van D", " Nhan su"));
        listNhanVien.add(new NhanVien(" NV004", " Nguyen Van E", " Dao tao"));
        listNhanVien.add(new NhanVien(" NV005", " Nguyen Van F", " Nhan su"));

        NhanVien_Adapter nvAdapter = new NhanVien_Adapter(activity_nhanvien.this, listNhanVien);
        listViewNhanVien.setAdapter(nvAdapter);

        hienThiDuLieuMoiLenForm(listNhanVien);

        ActivityResultLauncher<Intent> nhan = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent nhandata = result.getData();
                            if (nhandata != null){
                                NhanVien nhanvien1 = (NhanVien)nhandata.getSerializableExtra(activity_them_sua.KEY_ADDNV);
                                listNhanVien.add(nhanvien1);
                                hienThiDuLieuMoiLenForm(listNhanVien);
                            }

                        }
                    }
                }
        );

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(activity_nhanvien.this, activity_them_sua.class);
                nhan.launch(add);
            }
        });

    }

    ActivityResultLauncher<Intent> update = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent update_data = result.getData();
                        if (update_data != null) {
                            NhanVien nhanvien1 = (NhanVien)update_data.getSerializableExtra(activity_them_sua.KEY_ADDNV);
                            listNhanVien.set(update_position, nhanvien1);
                            hienThiDuLieuMoiLenForm(listNhanVien);

                        }
                    }
                }
            });

    public void update(int position) {
        Intent update_data = new Intent(getApplicationContext(), activity_them_sua.class);
        update_data.putExtra(KEY_NHAN_VIEN, listNhanVien.get(position));
        update_position = position;
        update.launch(update_data);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
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

    public void hienThiDuLieuMoiLenForm(ArrayList<NhanVien> newListNhanVien) {
        NhanVien_Adapter nhanVienAdapter = new NhanVien_Adapter(this, newListNhanVien);
        listViewNhanVien.setAdapter(nhanVienAdapter);
    }

    public void delete(int i) {
        listNhanVien.remove(i);
        hienThiDuLieuMoiLenForm(listNhanVien);
    }


}



