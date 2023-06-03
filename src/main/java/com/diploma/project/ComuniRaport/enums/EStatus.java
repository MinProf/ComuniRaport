package com.diploma.project.ComuniRaport.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EStatus {
    PENDING("pending"),
    IN_PROGRESS("inProgress"),
    RESOLVED("resolved");

    @Getter
    private final String value;
}
