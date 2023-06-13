package com.diploma.project.ComuniRaport.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @JsonProperty("lat")
    private float latitude;

    @JsonProperty("lng")
    private float longitude;
}
