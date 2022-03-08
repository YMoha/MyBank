package ma.omni.mybank.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString @Getter @Setter
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

    private double decouvert;

    public CompteCourant(String codeCmpt, Date dateCreation, double solde, Client client, double decouvert) {
        super(codeCmpt, dateCreation, solde, client);
        this.decouvert = decouvert;
    }


}
