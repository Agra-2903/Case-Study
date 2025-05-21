package com.hotel.reportservice.repository;

import com.hotel.reportservice.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByReportType(String reportType);
}
