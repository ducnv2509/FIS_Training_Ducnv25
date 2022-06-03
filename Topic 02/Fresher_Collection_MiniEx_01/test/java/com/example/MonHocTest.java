package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void getTen() {
        MonHoc mh = new MonHoc("ABN",6,6);
        assertEquals("ABN", mh.getTen());
        assertNotEquals("Cau truc du lieu", mh.getTen());
        MonHoc mh2 = new MonHoc("ANAN", 7, 8);
        assertNotEquals(mh, mh2);
    }

    @Test
    void getTcLT() {
    }

    @Test
    void getTcTH() {
    }

    @Test
    void testCollection(){
        List<MonHoc>  dsMonHoc = new ArrayList<>(100);
        MonHoc mh = new MonHoc("ABC",1,1);
        MonHoc mh2 = new MonHoc("CBA", 0, 0);
        dsMonHoc.add(mh);
        dsMonHoc.add(mh2);
//
//        MonHoc mh3 = new MonHoc(".NET",6,6);
//        assertEquals(0, dsMonHoc.indexOf(mh3));
        Collections.sort(dsMonHoc);
//        System.out.println(dsMonHoc);
        Collections.sort(dsMonHoc, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                if(o1.getTcTH() > o2.getTcTH())
                    return -1;
                else if(o2.getTcLT() < o2.getTcLT())
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println(dsMonHoc);
    }

    @Test
    void testWithSet(){
        Set<MonHoc> monHocSet = new HashSet<>();
        MonHoc mh = new MonHoc(".NET",6,6);
        MonHoc mh2 = new MonHoc("OOP", 7, 8);
        monHocSet.add(mh);
        monHocSet.add(mh2);
        MonHoc mh3 = new MonHoc(".NET",6,6);
        monHocSet.add(mh3);

        assertEquals(2,monHocSet.size());


    }
}