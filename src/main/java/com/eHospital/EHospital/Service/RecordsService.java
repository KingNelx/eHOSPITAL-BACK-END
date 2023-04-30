package com.eHospital.EHospital.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.eHospital.EHospital.Model.Records;

@Service
public interface RecordsService {

    // add new records
    ResponseEntity<Records> addNewRecord(Records newRecords);

    // get all records
    List<Records> getAllRecords();

    // update records by id
    ResponseEntity<String> updateRecordsByID(Records updateRecords, String id);

    // get records by id
    Optional<Records> getRecordsByID(String id);

    // delete records by id
    ResponseEntity<String> deleteRecordsById(String id);
}
