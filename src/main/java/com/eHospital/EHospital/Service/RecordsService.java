package com.eHospital.EHospital.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.eHospital.EHospital.Model.Records;

@Service
public interface RecordsService {

    // add new records
    ResponseEntity<String> addNewRecords(Records newRecords);

    // get all records
    List<Records> getAllRecords();

    // update records by id
    ResponseEntity<String> updateRecordsByID(String id, Records updateRecords);

    // get records by id
    Optional<Records> getRecordsByID(String id);

    // delete records by id
    ResponseEntity<String> deleteRecordByID(String id);

    // update findings
    ResponseEntity <String> updateFindings(String id, List <String> findings);

    // update diagnostics
    ResponseEntity <String> updateDiagnostics(String id, List <String> diagnostics);

    // update medications
    ResponseEntity <String> updateMedications(String id, List <String> medications);
}
