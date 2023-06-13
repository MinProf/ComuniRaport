package com.diploma.project.ComuniRaport.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EStatus {
    @JsonProperty("raportată")
    PENDING("raportată"),
    @JsonProperty("în progres de rezolvare")
    IN_PROGRESS("în progres de rezolvare"),
    @JsonProperty("rezolvată")
    RESOLVED("rezolvată");

    @Getter
    private final String value;
}
