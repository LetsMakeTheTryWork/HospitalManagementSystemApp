package com.abby.hms.service;

import com.abby.hms.model.MedicalReport;

import java.util.List;

public interface MedicalReportService {
    MedicalReport saveMedicalReport(MedicalReport medicalReport);
    MedicalReport getMedicalReportById(Long id);
    List<MedicalReport> getAllMedicalReports();
    void deleteMedicalReport(Long id);
    MedicalReport updateMedicalReport(Long id, MedicalReport medicalReportDetails);
}
