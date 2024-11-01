package com.example.AAD_Final_Course_Work.entity.impl;

import com.example.AAD_Final_Course_Work.entity.SuperEntity;
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
    private Double extentSize;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;
    @Column(columnDefinition = "LONGTEXT")

    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<CropEntity> crops;

    @ManyToMany
    private List<StaffEntity> staff;

}
