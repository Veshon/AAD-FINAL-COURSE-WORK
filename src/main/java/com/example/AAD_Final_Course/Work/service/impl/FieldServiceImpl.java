package com.example.AAD_Final_Course.Work.service.impl;

import com.example.AAD_Final_Course.Work.dao.FieldDAO;
import com.example.AAD_Final_Course.Work.entity.impl.FieldEntity;
import com.example.AAD_Final_Course.Work.service.FieldService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class FieldServiceImpl implements FieldService {
    private final FieldDAO fieldDAO;

    public FieldServiceImpl(FieldDAO fieldRepository) {
        this.fieldDAO = fieldRepository;
    }

    public List<FieldEntity> getAllFields() {
        return fieldDAO.findAll();
    }

    public FieldEntity saveField(FieldEntity field) {
        return fieldDAO.save(field);
    }

    public FieldEntity getFieldByCode(String fieldCode) {
        return fieldDAO.findById(fieldCode).orElse(null);
    }

    public void deleteField(String fieldCode) {
        fieldDAO.deleteById(fieldCode);
    }
}
