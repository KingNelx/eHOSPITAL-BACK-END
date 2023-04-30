package com.eHospital.EHospital.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import com.eHospital.EHospital.Model.Patients;
import com.eHospital.EHospital.Repository.PatientsRepo;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsImpl implements PatientsService {

    @Autowired
    private PatientsRepo patientsRepo;

    @Override
    public List<Patients> getAllPatients() {
        if (patientsRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return patientsRepo.findAll();
    }

    @Override
    public Optional<Patients> getPatientByID(@PathVariable String id) {
        if (!patientsRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return patientsRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> deletePatientInfoByID(@PathVariable String id) {
        if (!patientsRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        patientsRepo.deleteById(id);
        return ResponseEntity.ok(" PATIENT INFO DELETED ");
    }

    @Override
    public ResponseEntity<String> updatePatientsInfoByID(@PathVariable String id,
            @RequestBody Patients updatePatients) {
        Patients existingPatientInfo = patientsRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingPatientInfo.setFirstName(updatePatients.getFirstName());
        existingPatientInfo.setLastName(updatePatients.getLastName());
        existingPatientInfo.setGender(updatePatients.getGender());
        existingPatientInfo.setAddress(updatePatients.getAddress());
        existingPatientInfo.setContactNumber(updatePatients.getContactNumber());
        return ResponseEntity.ok(" PATIENT INFO UPDATED");
    }
}
