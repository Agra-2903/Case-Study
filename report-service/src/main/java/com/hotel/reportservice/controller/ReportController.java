package com.hotel.reportservice.controller;

import com.hotel.reportservice.model.Report;
import com.hotel.reportservice.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public Report generateReport(@RequestParam String reportType, @RequestParam double amount) {
        return reportService.generateReport(reportType, amount);
    }

    @GetMapping("/type/{reportType}")
    public List<Report> getReportsByType(@PathVariable String reportType) {
        return reportService.getReportsByType(reportType);
    }

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }
}
