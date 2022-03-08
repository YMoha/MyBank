package ma.omni.mybank;

import ma.omni.mybank.entities.*;
import ma.omni.mybank.metier.IBankMetier;
import ma.omni.mybank.repository.ClientRepository;
import ma.omni.mybank.repository.CompteRepository;
import ma.omni.mybank.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyBankApplication.class, args);
    }
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBankMetier iBankMetier;
    @Override
    public void run(String... args) throws Exception {

        //**********Creation de Clients****************
        Client c1=clientRepository.save(new Client("Jack","Jack@email.com"));
        Client c2=clientRepository.save(new Client("Anna","Anna@email.com"));
        Client c3=clientRepository.save(new Client("Yassin","Yassin@email.com"));
        Client c4=clientRepository.save(new Client("Bernat","Bernat@email.com"));
        Client c5=clientRepository.save(new Client("Imane","Imane@email.com"));
        //**********Creation des Comptes***************
        Compte cp1=compteRepository.save(new CompteCourant("c1",new Date(),10000,c1,5000));
        Compte cp2=compteRepository.save(new CompteEpargne("c2",new Date(),20000,c2,11000));
        Compte cp3=compteRepository.save(new CompteCourant("c3",new Date(),10000,c3,5000));
        Compte cp4=compteRepository.save(new CompteEpargne("c4",new Date(),50000,c4,25000) );
        Compte cp5=compteRepository.save(new CompteCourant("c5",new Date(),80000,c5,4000));
        //***********Creation des Operations************
        operationRepository.save(new Versement(new Date(),2000,cp1));
        operationRepository.save(new Retrait(new Date(),5000,cp1));
        operationRepository.save(new Versement(new Date(),50000,cp2));
        operationRepository.save(new Retrait(new Date(),63000,cp2));
        operationRepository.save(new Versement(new Date(),11300,cp3));
        operationRepository.save(new Retrait(new Date(),33300,cp3));
        operationRepository.save(new Versement(new Date(),8000,cp4));
        operationRepository.save(new Retrait(new Date(),2000,cp4));
        operationRepository.save(new Versement(new Date(),23000,cp5));
        operationRepository.save(new Retrait(new Date(),50000,cp5));
        //***********Consulter un Compte*******************

        Compte cmp=iBankMetier.consulterCompte(cp1.getCodeCmpt());
        System.out.println(cmp.toString());
        //***********Versement***************************

        

        iBankMetier.verser("c1",20000);
        //***********Retrait*****************************

        iBankMetier.retirer("c3",999);

        //************Virement************************

        iBankMetier.virement("c2","c5",2000);

        //****************PAge Des Operation*******************

        iBankMetier.listOperation("c1",1,3);


    }
}
