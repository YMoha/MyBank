package ma.omni.mybank.repository;

import ma.omni.mybank.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    @Query("SELECT o FROM Operation o WHERE o.compte.codeCmpt=:x order by o.dateOperation desc ")
    public Page<Operation> listOperation(@Param("x") String codeCmpt, Pageable pageable);

}
