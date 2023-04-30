package com.eHospital.EHospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import com.eHospital.EHospital.Model.Doctors;
import com.eHospital.EHospital.Repository.DoctorsRepo;

@Service
public class DoctorsImpl implements DoctorsService {

    @Autowired
    private DoctorsRepo doctorsRepo;

    @Override
    public List<Doctors> getAllDoctorsInfo() {
        if (doctorsRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return doctorsRepo.findAll();
    }

    @Override
    public Optional <Doctors> getDoctorsInfoByID(@PathVariable String id){
        if(!doctorsRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return doctorsRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> updateDoctorsInfoByID(@PathVariable String id, @RequestBody Doctors updateDoctors) {
        Doctors existingDoctorsInfo = doctorsRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingDoctorsInfo.setFirstName(updateDoctors.getFirstName());
        existingDoctorsInfo.setLastName(updateDoctors.getLastName());
        existingDoctorsInfo.setContactNumber(updateDoctors.getContactNumber());
        existingDoctorsInfo.setEmail(updateDoctors.getEmail());
        existingDoctorsInfo.setAddress(updateDoctors.getAddress());
        existingDoctorsInfo.setLicenseNumber(updateDoctors.getLicenseNumber());
        existingDoctorsInfo.setCertifications(updateDoctors.getCertifications());
        return ResponseEntity.ok(" DOCTORS INFO UPDATED ");
    }

}