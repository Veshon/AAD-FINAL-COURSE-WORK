package com.example.AAD_Final_Course.Work.entity.impl;

import com.example.AAD_Final_Course.Work.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Staff")

public class StaffEntity implements SuperEntity {
    @Id
    private String Id;
    private String firstName;
    private String lastName;
}
