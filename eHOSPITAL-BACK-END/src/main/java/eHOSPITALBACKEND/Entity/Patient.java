package eHOSPITALBACKEND.Entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.ElementCollection;
import java.util.List;
@Document(collection = "Patient")
public class Patient {
    @Id
    @Column(nullable = false)
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String firstName;
    @Column(nullable = false)
    private @Getter @Setter String lastName;
    @Column(nullable = false)
    private @Getter @Setter String patientType;
    @Column(nullable = false)
    private @Getter @Setter String gender;
    @Column(nullable = false)
    private @Getter @Setter String contactNumber;
    @Column(nullable = false)
    private @Getter @Setter String age;
    @Column(nullable = false)
    private @Getter @Setter String temporaryAddress;
    @Column(nullable = false)
    private @Getter @Setter String permanentAddress;
    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> medicalRecords;

}
