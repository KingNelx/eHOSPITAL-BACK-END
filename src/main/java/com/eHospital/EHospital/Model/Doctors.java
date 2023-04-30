package com.eHospital.EHospital.Model;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Lob;

@Document(collection = "Doctors")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    // @Lob
    // private @Getter @Setter byte[] doctorsPhoto;
    private @Getter @Setter String specialization;
    private @Getter @Setter String contactNumber;
    private @Getter @Setter String email;
    private @Getter @Setter String address;
    private @Getter @Setter String licenseNumber;
    @ElementCollection
    private @Getter @Setter List <String> certifications;
}
