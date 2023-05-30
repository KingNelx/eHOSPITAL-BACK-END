package eHOSPITALBACKEND.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Patient> getAllPatients() {
        if (patientRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return patientRepo.findAll();
    }

    @Override
    public Optional<Patient> getPatientByID(@PathVariable String id) {
        if (!patientRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return patientRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> updatePatientInfo(@PathVariable String id, @RequestBody Patient newPatient) {
        Patient existingPatient = patientRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Records existingRecords = existingPatient.getRecords();

        if (existingPatient != null && existingRecords != null) {
            existingPatient.setFirstName(newPatient.getFirstName());
            existingPatient.setLastName(newPatient.getLastName());
            existingPatient.setMiddleName(newPatient.getMiddleName());
            existingPatient.setAddress(newPatient.getAddress());
            existingPatient.setContactNumber(newPatient.getContactNumber());
            existingPatient.setAge(newPatient.getAge());
            existingPatient.setDateOfBirth(newPatient.getDateOfBirth());

            existingRecords.setEmergencyContact(newPatient.getRecords().getEmergencyContact());
            existingRecords.setVitalSigns(newPatient.getRecords().getVitalSigns());
            existingRecords.setLaboratory(newPatient.getRecords().getLaboratory());
            existingRecords.setMedications(newPatient.getRecords().getMedications());

            patientRepo.save(existingPatient);
            recordsRepo.save(existingRecords);

            return ResponseEntity.ok(" PATIENT ID: " + id + " UPDATED SUCCESSFULLY ");
        }
        return null;

    }

    @Override
    public ResponseEntity<String> removePatientsData(@PathVariable String id) {
        
        Optional <Patient> patientHandler = patientRepo.findById(id);

        if (!patientHandler.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }

        Patient deletePatientData = patientHandler.get();
        recordsRepo.deleteById(deletePatientData.getRecords().getId());
        patientRepo.deleteById(id);
        return ResponseEntity.ok("Patient Data with ID: " + id + " has been deleted ");
    }
}
