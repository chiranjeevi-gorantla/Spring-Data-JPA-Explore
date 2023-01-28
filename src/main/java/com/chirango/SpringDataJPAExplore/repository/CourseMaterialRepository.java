package com.chirango.SpringDataJPAExplore.repository;

import com.chirango.SpringDataJPAExplore.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
