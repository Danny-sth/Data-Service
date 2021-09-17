package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectsRepo subjectsRepo;

    public List<Subject> getAllSubjects() {
        return subjectsRepo
                .findAll();
    }

    public Subject getSubjectById(int id) {
        return subjectsRepo
                .findById(id);
    }

    public Subject addSubject(Subject subject) {
        return subjectsRepo
                .save(subject);
    }
}
