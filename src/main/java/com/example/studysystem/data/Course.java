package com.example.studysystem.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Course implements Serializable {

    private String courseName;
    private String status;
    private long courseId;
    private static AtomicLong idCounter = new AtomicLong(0);

    private List<Student> students = new ArrayList<>();

    public Course() {
        this("", "");

    }

    public Course(String courseName, String status) {
        this.courseName = courseName;
        this.status = status;
        this.courseId = idCounter.getAndIncrement();
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCourseId() {
        return this.courseId;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

}
