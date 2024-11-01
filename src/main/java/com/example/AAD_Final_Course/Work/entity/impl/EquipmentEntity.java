package com.example.AAD_Final_Course.Work.entity.impl;

import com.example.AAD_Final_Course.Work.entity.EquipmentStatus;
import com.example.AAD_Final_Course.Work.entity.EquipmentType;
import com.example.AAD_Final_Course.Work.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Equipments")

public class EquipmentEntity implements SuperEntity {

    @Id
    private String equipmentId;
    private String name;

    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    @ManyToOne
    @JoinColumn(name = "assigned_staff_id")
    private StaffEntity assignedStaff;

    @ManyToOne
    @JoinColumn(name = "assigned_field_code")
    private FieldEntity assignedField;
}