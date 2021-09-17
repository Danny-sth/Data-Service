package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Override
    public List<Teacher> findAll();

    @Override
    default Optional<Teacher> findById(Integer integer) {
        return Optional.empty();
    }
}
