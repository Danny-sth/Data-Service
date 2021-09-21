package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectsRepo subjectsRepo;

    @Autowired
    TeacherRepo teacherRepo;

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectsRepo
                .findAll();
    }

    public Subject getSubjectById(int id) {
        Subject subject = null;
        Optional<Subject> optional = subjectsRepo.findById(id);
        if (optional.isPresent()) {
            subject = optional.get();
        }
        return subject;
    }

    public Subject addSubject(Subject subject) {
        return subjectsRepo
                .save(subject);
    }

    public Subject update(int id, Subject subject) {
        Subject subjectInDB = getSubjectById(id);
        subjectInDB.setName(subject.getName());
        subjectInDB.getTeacher().setName(subject.getTeacher().getName());
        subjectInDB.getTeacher().setSurname(subject.getTeacher().getSurname());
        subjectInDB.getTeacher().setSalary(subject.getTeacher().getSalary());
        subjectsRepo.save(subjectInDB);
        return subjectInDB;
    }


    public void delete(int id) {
        subjectsRepo.deleteById(id);
    }
}
