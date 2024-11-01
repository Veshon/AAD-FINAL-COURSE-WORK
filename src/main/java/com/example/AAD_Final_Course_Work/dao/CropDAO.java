package com.example.AAD_Final_Course_Work.dao;

import com.example.AAD_Final_Course_Work.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDAO extends JpaRepository<CropEntity, String> {
}
