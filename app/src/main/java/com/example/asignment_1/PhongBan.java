package com.example.asignment_1;

public class PhongBan {
    private int logo_phongban;

    private String  name_phongban;

    public PhongBan() {
    }

    public PhongBan(int logo_phongban, String name_phongban) {
        this.logo_phongban = logo_phongban;
        this.name_phongban = name_phongban;
    }

    public int getLogo_phongban() {
        return logo_phongban;
    }

    public void setLogo_phongban(int logo_phongban) {
        this.logo_phongban = logo_phongban;
    }

    public String getName_phongban() {
        return name_phongban;
    }

    public void setName_phongban(String name_phongban) {
        this.name_phongban = name_phongban;
    }
}
