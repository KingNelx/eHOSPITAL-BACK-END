package com.eHospital.EHospital.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String gender;
    @Lob
    private @Getter @Setter byte[] patientPhoto;
    private @Getter @Setter String address;
    private @Getter @Setter String contactNumber;

}
