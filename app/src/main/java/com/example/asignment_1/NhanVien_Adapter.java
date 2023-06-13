package com.example.asignment_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NhanVien_Adapter extends BaseAdapter {

    private final Context context;

    private final ArrayList<NhanVien> listNhanVien;


    public NhanVien_Adapter(Context context, ArrayList<NhanVien> listNhanVien) {
        this.context = context;
        this.listNhanVien = listNhanVien;
    }

    @Override
    public int getCount() {
        return listNhanVien.size();
    }

    @Override
    public Object getItem(int position) {
        return listNhanVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_nhanvien, parent, false);
        TextView maNV_nhanvien = convertView.findViewById(R.id.maNv);
        TextView hoTen_nhanvien = convertView.findViewById(R.id.hoTen);
        TextView phongBan_nhanvien = convertView.findViewById(R.id.phongban);
        ImageView xoa = convertView.findViewById(R.id.delete);
        ImageView sua = convertView.findViewById(R.id.sua_nhanvien);
        maNV_nhanvien.setText("Ma NV: " + listNhanVien.get(position).getMaNV());
        hoTen_nhanvien.setText("Ho ten: " + listNhanVien.get(position).getHoTen());
        phongBan_nhanvien.setText("Phong ban: " + listNhanVien.get(position).getPhongBan());

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((activity_nhanvien) context).delete(position);
                Toast.makeText(context, "xoa thanh xong", Toast.LENGTH_SHORT).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((activity_nhanvien) context).update(position);
            }
        });

        return convertView;
    }


}
