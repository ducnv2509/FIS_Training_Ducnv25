package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void getMon() {
        MonHoc mh = new MonHoc("SQLBasic", 4, 3);
        Diem diem = new Diem(mh, 10);
        assertEquals(mh, diem.getMon());
    }

    @Test
    void getDiem() {

    }

    @Test
    void testCollection(){
        List<Diem> diems = new ArrayList<>();
        MonHoc mh = new MonHoc("SQLBasic", 4, 3);
        Diem diem = new Diem(mh, 10);
        Diem diem1  = new Diem(mh, 9);
        diems.add(diem1);
        diems.add(diem);
        Collections.sort(diems);
        System.out.println(diems);
    }
}