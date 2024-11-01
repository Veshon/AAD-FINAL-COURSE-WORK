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
    private Double extentSize;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<CropsEntity> crops;

    @ManyToMany
    private List<StaffEntity> staff;

}
