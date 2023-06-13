package com.diploma.project.ComuniRaport.payload.request;

import com.diploma.project.ComuniRaport.enums.EIssueCategory;
import com.diploma.project.ComuniRaport.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("description")
    private String description;
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lng")
    private String longitude;
}
