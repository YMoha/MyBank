package ma.omni.mybank.repository;

import ma.omni.mybank.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte,String> {

}
