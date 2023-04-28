package com.eHospital.EHospital.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Document (collection = "Authentication")
@AllArgsConstructor
@NoArgsConstructor

public class LogInAuth {

    @Id
    @GeneratedValue
    private @Getter @Setter String id;
    private @Getter @Setter String emailAddress;
    private @Getter @Setter String password;
}
