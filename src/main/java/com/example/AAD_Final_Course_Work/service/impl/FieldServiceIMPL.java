package com.example.AAD_Final_Course_Work.service.impl;

import com.example.AAD_Final_Course_Work.customStatusCode.SelectedErrorStatus;
import com.example.AAD_Final_Course_Work.dao.FieldDAO;
import com.example.AAD_Final_Course_Work.dto.FieldStatus;
import com.example.AAD_Final_Course_Work.dto.impl.FieldDTO;
import com.example.AAD_Final_Course_Work.entity.impl.FieldEntity;
import com.example.AAD_Final_Course_Work.exception.DataPersistException;
import com.example.AAD_Final_Course_Work.exception.FieldNotFoundException;
import com.example.AAD_Final_Course_Work.service.FieldService;
import com.example.AAD_Final_Course_Work.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<FieldDTO> getAllFields() {
        List<FieldEntity> allFields = fieldDAO.findAll();
        return mapping.asFieldDTOList(allFields);
    }

    @Override
    public FieldStatus getField(String fieldCode) {
        if (fieldDAO.existsById(fieldCode)){
            FieldEntity selectedField = fieldDAO.getReferenceById(fieldCode);
            return mapping.toFieldDTO(selectedField);
        }
        return new SelectedErrorStatus(2, "Field with code " + fieldCode + " not found");
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<FieldEntity> existedField = fieldDAO.findById(fieldCode);

        if (!existedField.isPresent()){
            throw new FieldNotFoundException("Field code" + fieldCode + "Not found");
        }else {
            fieldDAO.deleteById(fieldCode);
        }
    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {
        Optional<FieldEntity> tmpField = fieldDAO.findById(fieldCode); // optional cuz to reduce null point exception
        if (tmpField.isPresent()){
            tmpField.get().setFieldName(fieldDTO.getFieldName());
            tmpField.get().setFieldLocation(fieldDTO.getFieldLocation());
            tmpField.get().setExtentSize(fieldDTO.getExtentSize());
            tmpField.get().setFieldImage1(fieldDTO.getFieldImage1());
            tmpField.get().setFieldImage2(fieldDTO.getFieldImage2());
        }
    }
}
