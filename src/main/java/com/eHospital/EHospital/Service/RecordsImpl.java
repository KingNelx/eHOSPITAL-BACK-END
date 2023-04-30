package com.eHospital.EHospital.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

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

        return ResponseEntity.ok("Added new RECORDS.");
    }

}
