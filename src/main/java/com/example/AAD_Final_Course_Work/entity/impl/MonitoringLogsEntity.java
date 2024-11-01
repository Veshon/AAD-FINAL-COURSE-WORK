package com.example.AAD_Final_Course_Work.entity.impl;

import com.example.AAD_Final_Course_Work.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "MonitoringLogs")

public class MonitoringLogsEntity implements SuperEntity {

    @Id
    private String logCode;
    private Date logDate;
    private String logDetails;

    @Lob
    private String observedImage;

    @ManyToMany
    private List<FieldEntity> fields;

    @ManyToMany
    private List<CropEntity> crops;

    @ManyToMany
    private List<StaffEntity> staff;
}
