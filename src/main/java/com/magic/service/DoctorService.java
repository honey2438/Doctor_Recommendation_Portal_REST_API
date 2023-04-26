package com.magic.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.magic.entities.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(int did);

	void saveDoctorDetails(Doctor doctor);

	List<Doctor> getAllDoctorsByCity(String city);
    
	List<Doctor> getAllDoctorsByCityAndSpeciality(String city, String speciality);

	Doctor updateDoctorPhoneById(Doctor doctor);

	void deleteById(int did);

	List<Doctor> getDoctorBySymptom(String city, String symptom);

	

}
