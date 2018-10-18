package com.mbstu.ehcare.dao;
import com.mbstu.ehcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query("select p from Patient p where p.id = ?")
    Patient getPatientById(Integer patientId);
    @Query("select p from Patient p where p.bgroup = ?")
    List<Patient> getPatientBybgroup(String bgroup);
}
