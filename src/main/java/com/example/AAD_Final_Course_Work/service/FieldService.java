package com.example.AAD_Final_Course_Work.service;

import com.example.AAD_Final_Course_Work.dto.FieldStatus;
import com.example.AAD_Final_Course_Work.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO buildFieldDTO);
    List<FieldDTO> getAllFields();
    FieldStatus getField(String fieldCode);
    void deleteField(String fieldCode);

}
