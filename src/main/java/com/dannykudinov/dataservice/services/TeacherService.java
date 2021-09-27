package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    Logger log = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    TeacherRepo repository;

    public List<Teacher> getAll() {
        return (List<Teacher>) repository.findAll();
    }

    public Teacher getById(final int id) {
        log.debug("Method getById start");
        Teacher teacher = null;
        try {
            Optional<Teacher> teacherFromDB = repository.findById(id);
            if (teacherFromDB.isPresent()) {
                teacher = teacherFromDB.get();
                log.debug("Fetching teacher by id {}", teacherFromDB);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.debug("No such teacher in database");
        }
        log.debug("Method getById finished");
        return teacher;
    }

    public Teacher saveTeacher(Teacher teacher) {
        log.info("Save teacher {} to database", teacher);
        return repository
                .save(teacher);
    }

    public Teacher update(final int id, Teacher teacher) {
        log.debug("Method update start");
        Teacher teacherInDB = getById(id);
        log.debug("Fetching teacher {} from DB", teacherInDB);
        teacherInDB.setName(teacher.getName());
        teacherInDB.setSurname(teacher.getSurname());
        teacherInDB.setSalary(teacher.getSalary());
        teacherInDB.getSubject().setName(teacher.getSubject().getName());
        repository.save(teacherInDB);
        log.debug("Save updated teacher {} in DB", teacherInDB);
        return teacherInDB;
    }

    public String deleteTeacher(final int id) {
        log.debug("Method deleteTeacher start");
        String message = null;
        try {
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);
                message = "Teacher is deleted";
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            message = "No such teacher in database";
            log.debug(message);
        }
        log.debug("Method deleteTeacher finished");
        return message;
    }
}