package ma.omni.mybank.metier;

import ma.omni.mybank.entities.Compte;
import ma.omni.mybank.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBankMetier {
    public Compte consulterCompte(String codeCmpt);
    public void verser(String codeCmpt, double montant);
    public void retirer(String codeCmpt,double montant);
    public void virement(String codeCmpt1,String codeCmpt2,double montant);
    public Page<Operation> listOperation(String codeCmpt, int page, int size);

}
