package ma.omni.mybank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

    private double taux;

    public CompteEpargne(String codeCmpt, Date dateCreation, double solde, Client client, double taux) {
        super(codeCmpt, dateCreation, solde, client);
        this.taux = taux;
    }
}
