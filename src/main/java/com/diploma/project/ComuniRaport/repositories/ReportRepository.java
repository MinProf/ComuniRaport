package com.diploma.project.ComuniRaport.repositories;

import com.diploma.project.ComuniRaport.enums.EStatus;
import com.diploma.project.ComuniRaport.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findAllByUserId(Integer user_id);

    @Modifying
    @Query("update Report r set r.eStatus = ?1 where r.id = ?2")
    void setReportStatusById(EStatus status, Integer id);
}
