package com.diploma.project.ComuniRaport.models;

import com.diploma.project.ComuniRaport.enums.EIssueCategory;
import com.diploma.project.ComuniRaport.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private EIssueCategory eIssueCategory;
    @Enumerated(EnumType.STRING)
    private EStatus eStatus;

    private LocalDate date;

    private String description;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
