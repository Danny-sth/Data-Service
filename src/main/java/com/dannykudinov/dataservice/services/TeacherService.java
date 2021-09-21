package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepo repository;

    public List<Teacher> getAll() {
        return (List<Teacher>) repository.findAll();
    }

    public Teacher getById(int id) {
        Teacher teacher = null;
        Optional<Teacher> optional = repository.findById(id);
        if (optional.isPresent()) {
            teacher = optional.get();
        }
        return teacher;
    }

    public Teacher save(Teacher teacher) {
        return repository
                .save(teacher);
    }

    public Teacher update(int id, Teacher teacher) {
        Teacher teacherInDB = getById(id);
        teacherInDB.setName(teacher.getName());
        teacherInDB.setSurname(teacher.getSurname());
        teacherInDB.setSalary(teacher.getSalary());
        teacherInDB.getSubject().setName(teacher.getSubject().getName());
        repository.save(teacherInDB);
        return teacherInDB;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}