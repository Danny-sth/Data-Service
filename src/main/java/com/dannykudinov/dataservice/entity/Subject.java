package com.dannykudinov.dataservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "teach_in_sub",
            joinColumns = @JoinColumn(
                    name = "subject_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "teacher_id"))
    @JsonIgnoreProperties("subject")
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
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

    public void setName(String subjName) {
        this.name = subjName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjName='" + name + '\'' +
                '}';
    }
}
