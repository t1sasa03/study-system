package com.example.studysystem.data;

import java.util.concurrent.atomic.AtomicLong;

public class Student {

    private String name;

    private long studentId;
    private static AtomicLong idCounter = new AtomicLong(0);

    public Student() {
        this("");
    }

    public Student(String name) {
        this.name = name;
        this.studentId = idCounter.getAndIncrement();
    }

    public long getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", studentId='" + getStudentId() + "'" +
                "}";
    }

}
