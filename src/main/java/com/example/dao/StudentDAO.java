package com.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentDAO {

    // Insert Student
    public void insertStudent(Student s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully");
    }

    // Retrieve Student by ID
    public Student getStudent(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student s = session.get(Student.class, id);

        session.close();

        return s;
    }

    // Update Student Fee
    public void updateStudent(int id, double newFee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);

        if (s != null) {
            s.setFee(newFee);
            session.update(s);
        }

        tx.commit();
        session.close();

        System.out.println("Student updated");
    }

    // Delete Student
    public void deleteStudent(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);

        if (s != null) {
            session.delete(s);
        }

        tx.commit();
        session.close();

        System.out.println("Student deleted");
    }

    // ---------------- SKILL 3 (HQL) ----------------

    // Sort by fee ascending
    public void sortByFeeAsc() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student ORDER BY fee ASC", Student.class);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName() + " " + s.getFee());
        }

        session.close();
    }

    // Sort by fee descending
    public void sortByFeeDesc() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student ORDER BY fee DESC", Student.class);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName() + " " + s.getFee());
        }

        session.close();
    }

    // Pagination - first 3 students
    public void firstThreeStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student", Student.class);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName());
        }

        session.close();
    }

    // Pagination - next 3 students
    public void nextThreeStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student", Student.class);

        query.setFirstResult(3);
        query.setMaxResults(3);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName());
        }

        session.close();
    }

    // Count total students
    public void countStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Student", Long.class);

        Long count = query.uniqueResult();

        System.out.println("Total Students: " + count);

        session.close();
    }

    // Minimum and Maximum fee
    public void minMaxFee() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Double> q1 = session.createQuery("SELECT MIN(fee) FROM Student", Double.class);
        Query<Double> q2 = session.createQuery("SELECT MAX(fee) FROM Student", Double.class);

        System.out.println("Minimum Fee: " + q1.uniqueResult());
        System.out.println("Maximum Fee: " + q2.uniqueResult());

        session.close();
    }

    // WHERE clause example
    public void studentsInFeeRange() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery(
                "FROM Student WHERE fee BETWEEN 45000 AND 60000", Student.class);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName() + " " + s.getFee());
        }

        session.close();
    }

    // LIKE query
    public void nameStartsWithR() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery(
                "FROM Student WHERE name LIKE 'R%'", Student.class);

        List<Student> list = query.list();

        for (Student s : list) {
            System.out.println(s.getName());
        }

        session.close();
    }
}