package com.mbstu.ehcare.dao;
import com.mbstu.ehcare.model.Brequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrequestRepository extends JpaRepository<Brequest,Integer> {

    @Query("select p from Brequest p where p.id = ?")
    Brequest getbrequestById(Integer brequestId);

}
