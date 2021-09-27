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
    TeacherRepo teacherRepo;

    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepo.findAll();
    }

    public Teacher getTeacherById(final int id) {
        log.debug("Method getTeacherById start");
        Teacher teacher = null;
        try {
            Optional<Teacher> teacherFromDB = teacherRepo.findById(id);
            if (teacherFromDB.isPresent()) {
                teacher = teacherFromDB.get();
                log.debug("Fetching teacher by id {}", teacherFromDB);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.debug("No such teacher in database");
        }
        log.debug("Method getTeacherById finished");
        return teacher;
    }

    public Teacher saveTeacher(Teacher teacher) {
        log.info("Save teacher {} to database", teacher);
        return teacherRepo
                .save(teacher);
    }

    public Teacher updateTeacher(final int id, Teacher teacher) {
        log.debug("Method updateTeacher start");
        Teacher teacherInDB = getTeacherById(id);
        log.debug("Fetching teacher {} from DB", teacherInDB);
        teacherInDB.setName(teacher.getName());
        teacherInDB.setSurname(teacher.getSurname());
        teacherInDB.setSalary(teacher.getSalary());
        teacherInDB.getSubject().setName(teacher.getSubject().getName());
        teacherRepo.save(teacherInDB);
        log.debug("Save updated teacher {} in DB", teacherInDB);
        log.debug("Method updateTeacher finished");
        return teacherInDB;
    }

    public String deleteTeacher(final int id) {
        log.debug("Method deleteTeacher start");
        String message = null;
        try {
            if (teacherRepo.findById(id).isPresent()) {
                teacherRepo.deleteById(id);
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