package com.diploma.project.ComuniRaport.services;

import com.diploma.project.ComuniRaport.models.Report;
import com.diploma.project.ComuniRaport.models.User;
import com.diploma.project.ComuniRaport.payload.request.ReportRequest;
import com.diploma.project.ComuniRaport.payload.response.GetReportsResponse;
import com.diploma.project.ComuniRaport.repositories.ReportRepository;
import com.diploma.project.ComuniRaport.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public GetReportsResponse getReports()
    {
        return GetReportsResponse.builder()
                .id(1)
                .issueCategory("Category")
                .status("Open")
                .date(LocalDate.now())
                .description("Sample report description")
                .location("Sample location")
                .userId(123)
                .build();
    }

    public Report addReport(ReportRequest reportRequest, String userEmail)
    {
        Optional<User> userOptional  = userRepository.findByEmail(userEmail);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found for email: " + userEmail));

        Report report = Report.builder()
                .eIssueCategory(reportRequest.getIssueCategory())
                .eStatus(reportRequest.getStatus())
                .date(reportRequest.getDate())
                .description(reportRequest.getDescription())
                .location(reportRequest.getLocation())
                .user(user)
                .build();

        return reportRepository.save(report);
    }
}
