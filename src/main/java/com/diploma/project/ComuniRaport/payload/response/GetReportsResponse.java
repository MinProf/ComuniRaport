package com.diploma.project.ComuniRaport.payload.response;

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
public class GetReportsResponse {
    private Integer id;

    @JsonProperty("issue_category")
    private EIssueCategory issueCategory;

    @JsonProperty("status")
    private EStatus status;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("description")
    private String description;

    @JsonProperty("location")
    private String location;

    @JsonProperty("user_id")
    private Integer userId;
}
