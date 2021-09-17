package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Override
    public List<Teacher> findAll();
}
