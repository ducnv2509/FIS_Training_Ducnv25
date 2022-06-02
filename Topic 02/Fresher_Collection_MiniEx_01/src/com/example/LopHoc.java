package com.example;

import java.util.*;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public LopHoc() {
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        StringBuilder sb = new StringBuilder();
        sb.append("MSSV: " + this.ten);
        sb.append("Ten  : " + this.giaoVien);
        sb.append("Danh Sach Diem\n");
        sb.append(String.format("%-15s %-20s %-20s %-20s %-20s\n", "STT", "MSSV", "Ten", "Diem TB", "XepLoai"));
        for (int i = 0; i < dsLop.size(); i++) {
            sb.append(String.format("%-15s %-20s %-20s %-20s %-20s\n", i+1, dsLop.get(i).getMssv(), dsLop.get(i).getTen(), dsLop.get(i).tinhDiemTrungBinh(), dsLop.get(i).xepLoai()));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LopHoc().inDiem());
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
        List<SinhVien> list  = new ArrayList<>();
        List<SinhVien> list1 = list.subList(list.size() - 10, list.size());
        return list1;
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        //...
        List<SinhVien> str = new ArrayList<>();
        for (SinhVien nv : dsLop) {
            if (nv.xepLoai().equals("YEU")) {
                str.add(nv);
            }
        }
        return str;
    }
}
