package fis.java.core.topic01;

import fis.java.core.topic01.sort.ISortStrategy;

public class StudentList implements ISortStrategy {
    private Student[] students = new Student[100];
    private int count;

    private ISortStrategy sortStrategy;

    public void addStudent(Student student) {

    }

    public Student removeStudent(int code) {
        return null;
    }

    @Override
    public void sort(Comparable[] data, int count) {

    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
