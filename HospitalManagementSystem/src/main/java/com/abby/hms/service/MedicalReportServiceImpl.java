package com.abby.hms.service;

import com.abby.hms.model.MedicalReport;
import com.abby.hms.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalReportServiceImpl implements MedicalReportService {

    @Autowired
    private MedicalReportRepository medicalReportRepository;

    @Override
    public MedicalReport saveMedicalReport(MedicalReport medicalReport) {
        return medicalReportRepository.save(medicalReport);
    }

    @Override
    public MedicalReport getMedicalReportById(Long id) {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(id);
        return medicalReport.orElse(null);
    }

    @Override
    public List<MedicalReport> getAllMedicalReports() {
        return medicalReportRepository.findAll();
    }

    @Override
    public void deleteMedicalReport(Long id) {
        medicalReportRepository.deleteById(id);
    }

    @Override
    public MedicalReport updateMedicalReport(Long id, MedicalReport medicalReportDetails) {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(id);

        if (medicalReport.isPresent()) {
            MedicalReport existingReport = medicalReport.get();
            existingReport.setReportDate(medicalReportDetails.getReportDate());
            existingReport.setDiagnosis(medicalReportDetails.getDiagnosis());
            // Add more fields as necessary

            return medicalReportRepository.save(existingReport);
        } else {
            return null;
        }
    }
}
