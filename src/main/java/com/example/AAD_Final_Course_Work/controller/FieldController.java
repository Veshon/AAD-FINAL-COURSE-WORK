package com.example.AAD_Final_Course_Work.controller;

import com.example.AAD_Final_Course_Work.customStatusCode.SelectedFieldErrorStatus;
import com.example.AAD_Final_Course_Work.dto.FieldStatus;
import com.example.AAD_Final_Course_Work.dto.impl.FieldDTO;
import com.example.AAD_Final_Course_Work.exception.DataPersistException;
import com.example.AAD_Final_Course_Work.exception.FieldNotFoundException;
import com.example.AAD_Final_Course_Work.service.FieldService;
import com.example.AAD_Final_Course_Work.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/fields")

public class FieldController {

    @Autowired
    public FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldLocation") String fieldLocation,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2){

        // profilePic ----> Base64
        String base64ProPic = "";
        String base64ProPic2 = "";

        try {
            byte [] bytesFieldImg = fieldImage1.getBytes(); //Converting profile pic to byte array
            byte [] bytesFieldImg2 = fieldImage2.getBytes(); //Converting profile pic to byte array
            base64ProPic = AppUtil.profilePicToBase64(bytesFieldImg);
            base64ProPic2 = AppUtil.profilePicToBase64(bytesFieldImg2);
            String fieldCode = AppUtil.generateFieldCode(); //Generating UUID

            var buildFieldDTO = new FieldDTO(); //Creating obj
            buildFieldDTO.setFieldCode(fieldCode);
            buildFieldDTO.setFieldName(fieldName);
            buildFieldDTO.setFieldLocation(fieldLocation);
            buildFieldDTO.setExtentSize(Double.valueOf(extentSize));
            buildFieldDTO.setFieldImage1(base64ProPic);
            buildFieldDTO.setFieldImage2(base64ProPic2);

            fieldService.saveField(buildFieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields(){
        return fieldService.getAllFields();
    }

    @GetMapping(value = "/{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable ("fieldCode") String fieldCode){

        String regexForUserId = "^FIELD-[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserId);
        var regexMatcher = regexPattern.matcher(fieldCode);

        if (!regexMatcher.matches()){
            return new SelectedFieldErrorStatus(1,"Field code is not valid");
        }
        return fieldService.getField(fieldCode);
    }

    @DeleteMapping(value = "/{fieldCode}")
    public ResponseEntity<Void> deleteField(@PathVariable("fieldCode") String fieldCode){

        String regexForUserId = "^FIELD-[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserId);
        var regexMatcher = regexPattern.matcher(fieldCode);

        try {

            if (!regexMatcher.matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            fieldService.deleteField(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (FieldNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
