package com.diploma.project.ComuniRaport.services;

import com.diploma.project.ComuniRaport.enums.EStatus;
import com.diploma.project.ComuniRaport.models.Location;
import com.diploma.project.ComuniRaport.models.Report;
import com.diploma.project.ComuniRaport.models.User;
import com.diploma.project.ComuniRaport.payload.request.ReportRequest;;
import com.diploma.project.ComuniRaport.payload.response.ReportResponse;
import com.diploma.project.ComuniRaport.repositories.ReportRepository;
import com.diploma.project.ComuniRaport.repositories.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public List<ReportResponse> getReports()
    {
        var reports = convertReportsToResponses(reportRepository.findAll());
        return reports;
    }

    public ReportResponse addReport(ReportRequest reportRequest, String userEmail)
    {
        Optional<User> userOptional  = userRepository.findByEmail(userEmail);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found for email: " + userEmail));

        Report report = Report.builder()
                .eIssueCategory(reportRequest.getIssueCategory())
                .eStatus(reportRequest.getStatus())
                .date(reportRequest.getDate())
                .description(reportRequest.getDescription())
                .latitude(Float.parseFloat(reportRequest.getLatitude()))
                .longitude(Float.parseFloat(reportRequest.getLongitude()))
                .user(user)
                .build();

        var response = convertOneReportToResponse(reportRepository.save(report));
        return response;
    }

    public ReportResponse editReport(EStatus status,Integer id)
    {

        reportRepository.setReportStatusById(status, id);

        return convertOneReportToResponse(reportRepository.findById(id).orElseThrow());

    }

    public String deleteReport(Integer id)
    {
       if(reportRepository.findById(id).isPresent())
       {
           reportRepository.deleteById(id);
           return "Report deleted";
       }
       return "Report not found";
    }

    private ReportResponse convertOneReportToResponse(Report addedReport)
    {
        ReportResponse response = ReportResponse.builder()
                .issueCategory(addedReport.getEIssueCategory())
                .status(addedReport.getEStatus())
                .date(addedReport.getDate())
                .description(addedReport.getDescription())
                .location(Location.builder()
                        .latitude(addedReport.getLatitude())
                        .longitude(addedReport.getLongitude())
                        .build())
//                .latitude(addedReport.getLatitude())
//                .longitude(addedReport.getLongitude())
                .userId(addedReport.getUser().getId())
                .build();
        return response;
    }

    private List<ReportResponse> convertReportsToResponses(List<Report> reports) {
        List<ReportResponse> responses = new ArrayList<>();
        for (Report report : reports) {
            ReportResponse response = ReportResponse.builder()
                    .id(report.getId())
                    .issueCategory(report.getEIssueCategory())
                    .status(report.getEStatus())
                    .date(report.getDate())
                    .description(report.getDescription())
                    .location(Location.builder()
                            .latitude(report.getLatitude())
                            .longitude(report.getLongitude())
                            .build())
//                    .latitude(report.getLatitude())
//                    .longitude(report.getLongitude())
                    .userId(report.getUser().getId())
                    .build();
            responses.add(response);
        }
        return responses;
    }
}
