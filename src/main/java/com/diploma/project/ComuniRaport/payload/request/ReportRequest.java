package com.diploma.project.ComuniRaport.payload.request;

import com.diploma.project.ComuniRaport.enums.EIssueCategory;
import com.diploma.project.ComuniRaport.enums.EStatus;
import com.diploma.project.ComuniRaport.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    private EIssueCategory issueCategory;
    private EStatus status;
    private LocalDate date;
    private String description;
    private Location location;
}
