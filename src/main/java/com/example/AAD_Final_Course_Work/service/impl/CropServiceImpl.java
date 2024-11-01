package com.example.AAD_Final_Course_Work.service.impl;

import com.example.AAD_Final_Course_Work.dao.CropDAO;
import com.example.AAD_Final_Course_Work.entity.impl.CropEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class CropServiceImpl {

    private final CropDAO cropDAO;

    public CropServiceImpl(CropDAO cropRepository) {
        this.cropDAO = cropRepository;
    }

    public CropEntity saveCrop(CropEntity crop) {
        return cropDAO.save(crop);
    }
}
