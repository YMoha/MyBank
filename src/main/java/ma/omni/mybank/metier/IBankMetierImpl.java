package ma.omni.mybank.metier;

import ma.omni.mybank.entities.*;
import ma.omni.mybank.repository.CompteRepository;
import ma.omni.mybank.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class IBankMetierImpl implements IBankMetier{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String codeCmpt) {

        Compte cp=compteRepository.findById(codeCmpt).orElse(null);
        if (cp==null) throw new RuntimeException("Compte Introvable !!");
        return cp;
    }

    @Override
    public void verser(String codeCmpt, double montant) {
        Compte cp = consulterCompte(codeCmpt);
        Versement v = new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);


    }

    @Override
    public void retirer(String codeCmpt, double montant) {
        Compte cp = consulterCompte(codeCmpt);
        double facilitecaisse=0;
        if (cp instanceof CompteCourant)
            facilitecaisse=((CompteCourant) cp).getDecouvert();
        if (cp.getSolde()+facilitecaisse<montant)
            throw new RuntimeException("solde insufisant !!!");
        Retrait r = new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String codeCmpt1, String codeCmpt2, double montant) {
        retirer(codeCmpt1,montant);
        verser(codeCmpt2,montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCmpt, int page, int size) {
        return operationRepository.listOperation(codeCmpt, PageRequest.of(page,size));
    }
}
