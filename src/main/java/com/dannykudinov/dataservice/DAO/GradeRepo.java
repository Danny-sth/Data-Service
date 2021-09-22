package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {
}
