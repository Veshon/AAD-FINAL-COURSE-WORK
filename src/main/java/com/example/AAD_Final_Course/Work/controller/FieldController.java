package com.example.AAD_Final_Course.Work.controller;

import com.example.AAD_Final_Course.Work.dto.impl.FieldDTO;
import com.example.AAD_Final_Course.Work.entity.impl.FieldEntity;
import com.example.AAD_Final_Course.Work.service.FieldService;
import com.example.AAD_Final_Course.Work.service.impl.FieldServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fields")

public class FieldController {
    private final FieldServiceImpl fieldService;
    private final ModelMapper modelMapper;

    public FieldController(FieldServiceImpl fieldService, ModelMapper modelMapper) {
        this.fieldService = fieldService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<FieldEntity> getAllFields() {
        return fieldService.getAllFields();
    }


    @PostMapping
    public ResponseEntity<FieldEntity> createField(@RequestBody FieldDTO fieldDTO) {
        // Convert DTO to entity
        FieldEntity field = modelMapper.map(fieldDTO, FieldEntity.class);

        // Save entity
        FieldEntity savedField = fieldService.saveField(field);

        // Return response
        return new ResponseEntity<>(savedField, HttpStatus.CREATED);
    }

    @GetMapping("/{fieldCode}")
    public FieldEntity getField(@PathVariable String fieldCode) {
        return fieldService.getFieldByCode(fieldCode);
    }

    @DeleteMapping("/{fieldCode}")
    public void deleteField(@PathVariable String fieldCode) {
        fieldService.deleteField(fieldCode);
    }
}