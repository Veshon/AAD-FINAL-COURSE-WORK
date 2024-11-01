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
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;

    @Lob
    private String cropImage;
    private String category;
    private String cropSeason;

    @ManyToOne
    @JoinColumn(name = "field_code")
    private FieldEntity field;

}
