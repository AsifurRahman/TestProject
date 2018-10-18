package com.mbstu.ehcare.dao;
import com.mbstu.ehcare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query("select p from Doctor p where p.id = ?")
    Doctor getDoctorById(Integer doctorId);
}
