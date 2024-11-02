package com.example.AAD_Final_Course_Work.service;

import com.example.AAD_Final_Course_Work.dto.CropStatus;
import com.example.AAD_Final_Course_Work.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropStatus getCrop(String code);
    void deleteCrop(String code);
}
