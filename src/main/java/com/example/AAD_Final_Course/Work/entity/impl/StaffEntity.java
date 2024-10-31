package com.example.AAD_Final_Course.Work.entity.impl;

import com.example.AAD_Final_Course.Work.entity.Desig;
import com.example.AAD_Final_Course.Work.entity.Gender;
import com.example.AAD_Final_Course.Work.entity.Role;
import com.example.AAD_Final_Course.Work.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private Desig designation;
    private Gender gender;
    private String joinedDate;
    private String DOB;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
    private String field;
    @OneToOne(mappedBy = "staff")
    private List<VehicleEntity1> vehicle;

}
