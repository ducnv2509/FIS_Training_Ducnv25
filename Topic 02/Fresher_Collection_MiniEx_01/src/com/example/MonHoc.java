package com.example;

public class MonHoc implements Comparable<MonHoc> {
    private String ten;
    private int tcLT;
    private int tcTH;

    public MonHoc(String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }

    public MonHoc() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public void setTcLT(int tcLT) {
        this.tcLT = tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    public void setTcTH(int tcTH) {
        this.tcTH = tcTH;
    }

    public boolean equals(Object that) {
        //Hai mon duoc goi la bang nhau neu cung ten mon
        if (that instanceof MonHoc) {
            return ((MonHoc) that).ten.equals(this.ten);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = ten.hashCode();
        result = 31 * result + tcLT;
        result = 31 * result + tcTH;
        return result;
    }

    @Override
    public int compareTo(MonHoc that) {
        if (this.ten.compareTo(that.ten) > 0) {
            return 1;
        } else if (this.ten.compareTo(that.ten) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                '}';
    }
}
