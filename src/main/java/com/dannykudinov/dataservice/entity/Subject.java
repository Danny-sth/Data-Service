package com.dannykudinov.dataservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String subjName;

    public Subject() {
    }

    public Subject(String subjName) {
        this.subjName = subjName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjName() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjName='" + subjName + '\'' +
                '}';
    }
}
