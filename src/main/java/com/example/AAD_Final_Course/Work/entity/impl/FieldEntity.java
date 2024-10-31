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
@Table(name = "Field")

public class FieldEntity implements SuperEntity {

    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private double extentSizeOfField;

    @OneToMany(mappedBy = "field")
    private List<CropsEntity> crops;

    @ManyToMany
    private List<StaffEntity> staff;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImg1;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImg2;

}
