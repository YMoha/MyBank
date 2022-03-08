package ma.omni.mybank.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString @Setter @Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {
    @Id
    private String codeCmpt;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT")
    private Client client;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte(String codeCmpt, Date dateCreation, double solde, Client client) {
        this.codeCmpt = codeCmpt;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }
}
