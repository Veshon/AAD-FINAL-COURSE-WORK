package com.example.AAD_Final_Course_Work.dao;

import com.example.AAD_Final_Course_Work.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<FieldEntity, String> {
}

