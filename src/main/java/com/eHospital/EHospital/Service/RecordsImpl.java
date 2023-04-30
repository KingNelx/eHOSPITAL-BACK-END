package com.eHospital.EHospital.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import java.util.Optional;

import com.eHospital.EHospital.Model.Doctors;
import com.eHospital.EHospital.Model.Patients;
import com.eHospital.EHospital.Model.Records;
import com.eHospital.EHospital.Repository.DoctorsRepo;
import com.eHospital.EHospital.Repository.PatientsRepo;
import com.eHospital.EHospital.Repository.RecordsRepo;

@Service
public class RecordsImpl implements RecordsService {

    @Autowired
    private RecordsRepo recordsRepo;

    @Autowired
    private PatientsRepo patientsRepo;

    @Autowired
    private DoctorsRepo doctorsRepo;

    @Override
    public ResponseEntity<String> addNewRecords(@RequestBody Records newRecords) {
        Patients updatePatientInfo = newRecords.getPatients();
        Doctors updateDoctorInfo = newRecords.getDoctors();

        if (updatePatientInfo == null || updateDoctorInfo == null || updatePatientInfo.getId() == null
                || updateDoctorInfo.getId() == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        recordsRepo.save(newRecords);
        patientsRepo.save(updatePatientInfo);
        doctorsRepo.save(updateDoctorInfo);

        return ResponseEntity.ok("Added NEW RECORDS.");
    }

    @Override
    public List<Records> getAllRecords() {
        if (recordsRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return recordsRepo.findAll();
    }

    @Override
    public ResponseEntity<String> updateRecordsByID(@PathVariable String id, @RequestBody Records updateRecords) {
        Records updateExistingRecords = recordsRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        updateExistingRecords.setFindings(updateRecords.getFindings());
        updateExistingRecords.setDiagnostics(updateRecords.getDiagnostics());
        updateExistingRecords.setMedications(updateRecords.getMedications());
        return ResponseEntity.ok(" RECORDS UPDATED ");
    }

    @Override
    public Optional<Records> getRecordsByID(@PathVariable String id) {
        if (!recordsRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return recordsRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteRecordByID(@PathVariable String id) {
        if (!recordsRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        recordsRepo.deleteById(id);
        return ResponseEntity.ok(" RECORDS DELETED ");
    }

    @Override
    public ResponseEntity<String> updateFindings(@PathVariable String id, @RequestBody List<String> findings) {
        Optional<Records> existingFindings = recordsRepo.findById(id);

        if (!existingFindings.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        Records newFindings = existingFindings.get();
        newFindings.setFindings(findings);
        recordsRepo.save(newFindings);
        return ResponseEntity.ok(" FINDINGS GOT UPDATED ");
    }

    @Override
    public ResponseEntity<String> updateDiagnostics(@PathVariable String id, @RequestBody List<String> diagnostics) {
        Optional<Records> existingDiagnostics = recordsRepo.findById(id);

        if (!existingDiagnostics.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        Records newDiagnostics = existingDiagnostics.get();
        newDiagnostics.setDiagnostics(diagnostics);
        recordsRepo.save(newDiagnostics);

        return ResponseEntity.ok(" DIANOSTICS GOT UPDATED ");
    }

    @Override
    public ResponseEntity<String> updateMedications(@PathVariable String id, @RequestBody List<String> medications) {
        Optional <Records> existingMedications = recordsRepo.findById(id);

        if(!existingMedications.isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        Records newMedications = existingMedications.get();
        newMedications.setMedications(medications);
        recordsRepo.save(newMedications);
        return ResponseEntity.ok(" MEDICATIONS GOT UPDATED ");
    }

}
