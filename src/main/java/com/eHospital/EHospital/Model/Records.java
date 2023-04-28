package com.eHospital.EHospital.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Records")
@Entity
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Getter @Setter String id;

    @ElementCollection
    private @Getter @Setter List <String> findings;
    @ElementCollection
    private @Getter @Setter List <String> diagnostics;
    @ElementCollection
    private @Getter @Setter List <String> medications;
}
