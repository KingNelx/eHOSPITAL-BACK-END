package com.hospital.hospitalmanagementsystem.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String middleName;
    private @Getter @Setter String dateOfBirth;
    private @Getter @Setter String gender;
    private @Getter @Setter String contactNumber;
    private @Getter @Setter String email;
    private @Getter @Setter String address;
}
