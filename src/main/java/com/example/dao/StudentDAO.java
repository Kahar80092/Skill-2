package com.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentDAO {

    public void insertStudent(Student s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully");
    }

    public Student getStudent(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student s = session.get(Student.class,id);

        session.close();

        return s;
    }

    public void updateStudent(int id,double newFee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class,id);

        if(s!=null){
            s.setFee(newFee);
            session.update(s);
        }

        tx.commit();
        session.close();

        System.out.println("Student updated");
    }

    public void deleteStudent(int id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class,id);

        if(s!=null){
            session.delete(s);
        }

        tx.commit();
        session.close();

        System.out.println("Student deleted");
    }
}