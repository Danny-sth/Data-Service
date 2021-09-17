package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Integer> {

    @Override
    public List<Teacher> findAll();

    @Override
    public Optional<Teacher> findById(Integer integer);

    @Override
    Teacher save(Teacher teacher);
}
