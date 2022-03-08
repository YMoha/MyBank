package ma.omni.mybank.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString @Setter @Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPERATION",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable {
    @Id @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_COMPTE")
    private Compte compte;

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
