package com.magic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magic.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    @Query("from Doctor where city=:arg")
	List<Doctor> findAllByCity(@Param("arg") String city);
    @Query("from Doctor where city=:arg1 and speciality=:arg2")
	List<Doctor> findAllByCityAndSpeciality(@Param("arg1") String city,@Param("arg2")  String speciality);


}
