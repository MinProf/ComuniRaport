package com.diploma.project.ComuniRaport.controllers;

import com.diploma.project.ComuniRaport.models.Report;
import com.diploma.project.ComuniRaport.payload.request.ReportRequest;
import com.diploma.project.ComuniRaport.payload.response.GetReportsResponse;
import com.diploma.project.ComuniRaport.payload.response.ReportResponse;
import com.diploma.project.ComuniRaport.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/getReports")
    public ResponseEntity<GetReportsResponse> reports()
    {
        return ResponseEntity.ok(reportService.getReports());
    }

    @GetMapping("status/{status}")
    public List<GetReportsResponse> getReportsByStatus(@PathVariable("status") String status)
    {
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<ReportResponse> addReport(@RequestBody ReportRequest reportRequest, Authentication authentication)
    {
        String userEmail = authentication.getName();
        Report addedReport = reportService.addReport(reportRequest, userEmail);
        ReportResponse response = convertReportToResponse(addedReport);
        return ResponseEntity.ok(response);
    }

    private ReportResponse convertReportToResponse(Report addedReport)
    {
        return null;
    }

    // Helper method to convert Report entity to ReportResponse DTO
    private List<GetReportsResponse> convertReportsToResponses(List<Report> reports) {
        List<GetReportsResponse> responses = new ArrayList<>();
        for (Report report : reports) {
            GetReportsResponse response = GetReportsResponse.builder()
                    .id(report.getId())
                    .issueCategory(report.getEIssueCategory())
                    .status(report.getEStatus())
                    .date(report.getDate())
                    .description(report.getDescription())
                    .location(report.getLocation())
                    .userId(report.getUser().getId())
                    .build();
            responses.add(response);
        }
        return responses;
    }


}
