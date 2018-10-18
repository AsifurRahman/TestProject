package com.mbstu.ehcare.dao;
import com.mbstu.ehcare.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Integer> {

    @Query("select p from Donor p where p.id = ?")
    Donor getDonorById(Integer donorId);
    @Query("select p from Donor p where p.bgroup = ?")
    List<Donor> getDonorBybgroup(String bgroup);
}
