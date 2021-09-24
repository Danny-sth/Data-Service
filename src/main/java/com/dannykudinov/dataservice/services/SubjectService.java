package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    Logger log = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    SubjectsRepo subjectsRepo;

    @Autowired
    TeacherRepo teacherRepo;

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectsRepo
                .findAll();
    }

    public Subject getSubjectById(final int id) {
        Subject subject = null;
        Optional<Subject> optional = subjectsRepo.findById(id);
        try {
            if (optional.isPresent()) {
                subject = optional.get();
                log.debug("Fetching subject by id {}", subject);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.debug("No such object exists", e);
        }
        return subject;
    }


    public Subject addSubject(Subject subject) {
        return subjectsRepo
                .save(subject);
    }

    public Subject update(final int id, Subject subject) {
        Subject subjectInDB = getSubjectById(id);
        subjectInDB.setName(subject.getName());
        subjectInDB.getTeacher().setName(subject.getTeacher().getName());
        subjectInDB.getTeacher().setSurname(subject.getTeacher().getSurname());
        subjectInDB.getTeacher().setSalary(subject.getTeacher().getSalary());
        subjectsRepo.save(subjectInDB);
        return subjectInDB;
    }


    public void delete(final int id) {
        subjectsRepo.deleteById(id);
    }
}
