package com.example;

import java.io.Serializable;

public class Diem implements Comparable<Diem>, Serializable {
    private MonHoc mon;
    private int diem;


    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public int compareTo(Diem that) {
        return Integer.compare(this.diem, that.diem);
    }


    @Override
    public Diem clone() {
        Diem diem = new Diem(this.mon, this.diem);
        return diem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diem diem1 = (Diem) o;

        if (diem != diem1.diem) return false;
        return mon.equals(diem1.mon);
    }

    @Override
    public int hashCode() {
        int result = mon.hashCode();
        result = 31 * result + diem;
        return result;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }
}
