package com.diploma.project.ComuniRaport.controllers;

import com.diploma.project.ComuniRaport.enums.EStatus;
import com.diploma.project.ComuniRaport.models.Report;
import com.diploma.project.ComuniRaport.payload.request.ReportRequest;
import com.diploma.project.ComuniRaport.payload.response.ReportResponse;
import com.diploma.project.ComuniRaport.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/getReports")
    public ResponseEntity<List<ReportResponse>> getReports()
    {
        return ResponseEntity.ok(reportService.getReports());
    }

    @PostMapping("/status")
    public ResponseEntity<ReportResponse> editReport(@RequestBody EStatus status, @RequestBody Integer id)
    {
        return ResponseEntity.ok(reportService.editReport(status, id));
    }

    @PostMapping("/add")
    public ResponseEntity<ReportResponse> addReport(@RequestBody ReportRequest reportRequest, Authentication authentication)
    {
        String userEmail = authentication.getName();
        ReportResponse addedReport = reportService.addReport(reportRequest, userEmail);

        return ResponseEntity.ok(addedReport);
    }

    @DeleteMapping("/delete/{id}")
   // @PreAuthorize("hasAuthority('management:delete')")
    public ResponseEntity<String> deleteReport(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(reportService.deleteReport(id));
    }

}
