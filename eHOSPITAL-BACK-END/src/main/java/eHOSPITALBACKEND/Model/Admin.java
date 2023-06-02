package eHOSPITALBACKEND.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Document(collection = "Admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstname;
    private @Getter @Setter String lastname;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
    private @Getter @Setter String username;
}
