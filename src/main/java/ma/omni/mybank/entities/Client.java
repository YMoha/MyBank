package ma.omni.mybank.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@Table @AllArgsConstructor @NoArgsConstructor @ToString @Getter @Setter
public class Client implements Serializable {

    @Id @GeneratedValue
    private Long code;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)

    private Collection<Compte> comptes;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    
}
