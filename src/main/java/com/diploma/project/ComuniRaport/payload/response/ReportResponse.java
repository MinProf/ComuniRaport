package com.diploma.project.ComuniRaport.payload.response;

import com.diploma.project.ComuniRaport.enums.EIssueCategory;
import com.diploma.project.ComuniRaport.enums.EStatus;
import com.diploma.project.ComuniRaport.models.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private Integer id;

    @JsonProperty("issueCategory")
    private EIssueCategory issueCategory;

    @JsonProperty("status")
    private EStatus status;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("description")
    private String description;
    private Location location;

//    @JsonProperty("lat")
//    private float latitude;
//
//    @JsonProperty("lng")
//    private float longitude;

    @JsonProperty("user_id")
    private Integer userId;
}
