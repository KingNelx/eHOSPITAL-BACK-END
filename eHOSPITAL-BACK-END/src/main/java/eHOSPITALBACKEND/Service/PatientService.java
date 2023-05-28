package eHOSPITALBACKEND.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eHOSPITALBACKEND.Model.Patient;

@Service
public interface PatientService  {
    
    // add patient
    ResponseEntity <String> addPatient(Patient registerNewPatient);
    
    // get all patient

    // get patient by id

    // update patient by id

    // delete patient by id
}
