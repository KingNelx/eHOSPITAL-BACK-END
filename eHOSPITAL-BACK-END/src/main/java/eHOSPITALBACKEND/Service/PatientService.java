package eHOSPITALBACKEND.Service;

import java.util.Optional;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eHOSPITALBACKEND.Model.Patient;

@Service
public interface PatientService {

    // add patient
    ResponseEntity<String> addPatient(Patient registerNewPatient);

    // get all patient
    List<Patient> getAllPatients();

    // get patient by id
    Optional<Patient> getPatientByID(String id);

    // update patient by id
    ResponseEntity <String> updatePatientInfo(String id, Patient newPatient);

    // delete patient by id
    ResponseEntity <String> removePatientsData(String id);
}
