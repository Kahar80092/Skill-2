package com.example.main;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        Student s1 = new Student("Rahul","AI",50000);
        Student s2 = new Student("Aman","Data Science",45000);

        dao.insertStudent(s1);
        dao.insertStudent(s2);

        Student s = dao.getStudent(1);
        System.out.println("Student Name: "+s.getName());

        dao.updateStudent(1,55000);

        dao.deleteStudent(2);
    }
}