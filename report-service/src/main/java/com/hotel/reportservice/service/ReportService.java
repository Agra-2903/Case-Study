package com.hotel.reportservice.service;

import com.hotel.reportservice.model.Report;
import com.hotel.reportservice.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report generateReport(String reportType, double amount) {
        Report report = new Report(null, reportType, amount, LocalDate.now());
        return reportRepository.save(report);
    }

    public List<Report> getReportsByType(String reportType) {
        return reportRepository.findByReportType(reportType);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}
