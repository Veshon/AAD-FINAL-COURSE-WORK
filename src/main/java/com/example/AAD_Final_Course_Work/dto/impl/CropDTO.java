package com.example.AAD_Final_Course_Work.dto.impl;

import com.example.AAD_Final_Course_Work.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CropDTO implements CropStatus {

    private String code;
    private String commonName;
    private String scientificName;
    private String cropImg;
    private String category;
    private String season;
    private String fieldCode;

}