package com.example.AAD_Final_Course_Work.service.impl;

import com.example.AAD_Final_Course_Work.dao.FieldDAO;
import com.example.AAD_Final_Course_Work.dto.impl.FieldDTO;
import com.example.AAD_Final_Course_Work.entity.impl.FieldEntity;
import com.example.AAD_Final_Course_Work.exception.DataPersistException;
import com.example.AAD_Final_Course_Work.service.FieldService;
import com.example.AAD_Final_Course_Work.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional

public class FieldServiceIMPL implements FieldService {

    @Autowired
    public FieldDAO fieldDAO;

    @Autowired
    public Mapping mapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        FieldEntity savedField = fieldDAO.save(mapping.toFieldEntity(fieldDTO));
        if (savedField == null) {
            throw new DataPersistException("Field not saved");
        }
    }
}
