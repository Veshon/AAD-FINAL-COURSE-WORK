package com.example.AAD_Final_Course.Work.entity.impl;

import com.example.AAD_Final_Course.Work.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Crops")

public class CropsEntity implements SuperEntity {

    @Id
    private String code;
    private String commonName;
    private String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImg;
    private String category;
    private String season;
    private String field;

}
