package com.diploma.project.ComuniRaport.repositories;

import com.diploma.project.ComuniRaport.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findAllByUserId(Integer user_id);
//    List<Report> findAllByUserIdAndEStatus(Integer user_id, String eStatus);
////
//    List<Report> findAllByEStatus(EStatus eStatus);
}
