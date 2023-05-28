package eHOSPITALBACKEND.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import eHOSPITALBACKEND.Model.Patient;
import eHOSPITALBACKEND.Model.Records;
import eHOSPITALBACKEND.Repository.PatientRepo;
import eHOSPITALBACKEND.Repository.RecordsRepo;

@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private RecordsRepo recordsRepo;

    @Override
    public ResponseEntity<String> addPatient(@RequestBody Patient addPatient) {
        Records existingRecords = addPatient.getRecords();

        if (existingRecords == null || existingRecords.getId() == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        patientRepo.save(addPatient);
        recordsRepo.save(existingRecords);

        return ResponseEntity.ok(" NEW PATIENT ADDED ");

    }
}
