package ma.omni.mybank.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@Data
@ToString  @NoArgsConstructor @Setter
@DiscriminatorValue("V")
public class Versement extends Operation{


    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
