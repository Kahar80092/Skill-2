package com.example.main;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // Insert additional students (5–8 records)
        dao.insertStudent(new Student("Rahul","AI",55000));
        dao.insertStudent(new Student("Aman","Data Science",45000));
        dao.insertStudent(new Student("Priya","AI",60000));
        dao.insertStudent(new Student("Karan","Cyber Security",52000));
        dao.insertStudent(new Student("Neha","AI",58000));
        dao.insertStudent(new Student("Rohit","Data Science",49000));

        System.out.println("\n---- Sort by Fee Ascending ----");
        dao.sortByFeeAsc();

        System.out.println("\n---- Sort by Fee Descending ----");
        dao.sortByFeeDesc();

        System.out.println("\n---- First 3 Students (Pagination) ----");
        dao.firstThreeStudents();

        System.out.println("\n---- Next 3 Students (Pagination) ----");
        dao.nextThreeStudents();

        System.out.println("\n---- Total Students ----");
        dao.countStudents();

        System.out.println("\n---- Min and Max Fee ----");
        dao.minMaxFee();

        System.out.println("\n---- Students in Fee Range ----");
        dao.studentsInFeeRange();

        System.out.println("\n---- Names Starting with R ----");
        dao.nameStartsWithR();
    }
}