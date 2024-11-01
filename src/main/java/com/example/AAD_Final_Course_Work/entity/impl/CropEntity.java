package com.example.AAD_Final_Course_Work.entity.impl;

import com.example.AAD_Final_Course_Work.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Crop")

public class CropEntity implements SuperEntity {

    @Id
    private String code;
    private String commonName;
    private String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImg;
    private String category;
    private String season;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private FieldEntity field;

}