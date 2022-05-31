package fis.java.core.topic01.dao.mem;

import fis.java.core.topic01.ISortStrategy;
import fis.java.core.topic01.IStudentDAO;
import fis.java.core.topic01.core.Student;

public class StudentDAOMem implements IStudentDAO {
    public final  int MAX = 100;
    private int count;
    private Student[] students;
    private ISortStrategy iSortStrategy;
    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student remove(int code) {
        return null;
    }

    @Override
    public void display() {

    }

    @Override
    public void sort() {

    }

    @Override
    public void setSortStrategy(ISortStrategy iSortStrategy) {

    }
}
