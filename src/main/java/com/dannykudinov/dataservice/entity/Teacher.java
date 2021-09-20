package com.dannykudinov.dataservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "teach_in_sub",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id"
            ), inverseJoinColumns = @JoinColumn(
            name = "subject_id",
            referencedColumnName = "id"))
    @JsonIgnoreProperties("teacher")
    private Subject subject;

    public Teacher() {
    }

    public Teacher(String name, String surname, int salary, Subject subjectId) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.subject = subjectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", subject=" + subject +
                '}';
    }
}
