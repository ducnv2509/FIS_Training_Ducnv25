package com.example;

import java.util.*;

public class SinhVien {
    private String mssv;
    private String ten;

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public SinhVien() {
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong
        double total = 0, markMedium;
        int temp = 0;
        for (Diem mark :
                monDaHoc) {
            total += mark.getDiem();
            temp++;
        }
        markMedium = total / temp;
        //...
        return markMedium;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("MSSV: " + this.mssv + "\n");
        sb.append("Ten  : " + this.ten + "\n");
        sb.append("Danh Sach Diem\n");
        sb.append(String.format("%-15s %-20s %-20s %-20s\n", "STT", "Ten Mon", "Diem", "So Tin Chi "));

        for (Diem mh : monDaHoc
        ) {
            sb.append(String.format("%-15s %-20s %-20s %-20s\n", "1", mh.getMon().getTen(), mh.getDiem(), mh.getMon().getTcLT() + mh.getMon().getTcTH()));
        }
        sb.append("Diem Trung Binh" + tinhDiemTrungBinh());
        return sb.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        String lever = "";
        if (tinhDiemTrungBinh() < 5) {
            return lever = "Yeu";
        } else if (tinhDiemTrungBinh() < 6) {
            return lever = "TB";
        } else if (tinhDiemTrungBinh() < 5) {
            return lever = "TB-KHA";
        } else if (tinhDiemTrungBinh() < 8) {
            return "KHA";
        } else if (tinhDiemTrungBinh() <= 10) {
            return "GIOI";
        } else {
            throw new RuntimeException("BUG");
        }
        //...
    }
}
