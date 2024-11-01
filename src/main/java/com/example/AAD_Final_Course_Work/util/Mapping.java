package com.example.AAD_Final_Course_Work.util;

import com.example.AAD_Final_Course_Work.dto.impl.FieldDTO;
import com.example.AAD_Final_Course_Work.entity.impl.FieldEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    //Converting DTO to Entity
    public FieldEntity toFieldEntity(FieldDTO fieldDTO){
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }

    //Converting Entity to DTO
    public FieldDTO toFieldDTO(FieldEntity fieldEntity){
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }

    public List<FieldDTO> asFieldDTOList(List<FieldEntity> fieldEntities) {
        return modelMapper.map(fieldEntities, new TypeToken<List<FieldDTO>>() {}.getType());
    }

//    public NoteDTO toNoteDTO(NoteEntity noteEntity) {
//        return modelMapper.map(noteEntity, NoteDTO.class);
//    }
//
//    public NoteEntity toNoteEntity(NoteDTO noteDTO) {
//        return modelMapper.map(noteDTO, NoteEntity.class);
//    }
//
//    public List<NoteDTO> asNoteDTOList(List<NoteEntity> noteEntities) {
//        return modelMapper.map(noteEntities, new TypeToken<List<NoteDTO>>() {}.getType());
//    }
}
