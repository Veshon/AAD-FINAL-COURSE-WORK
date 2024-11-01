package com.example.AAD_Final_Course_Work.customStatusCode;

import com.example.AAD_Final_Course_Work.dto.CropStatus;
import com.example.AAD_Final_Course_Work.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SelectedErrorStatus implements FieldStatus, CropStatus {
    private int statusCode;
    private String statusMessage;
}
