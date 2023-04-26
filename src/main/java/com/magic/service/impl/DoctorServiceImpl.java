package com.magic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.entities.Doctor;
import com.magic.handler.NoDoctorAtYourLocationException;
import com.magic.handler.NoDoctorForYourSymptomException;
import com.magic.repo.DoctorRepo;
import com.magic.repo.PatientRepo;
import com.magic.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PatientRepo patientRepo;
	static final Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("arthritis", "orthopedic");
		map.put("backpain", "orthopedic");
		map.put("tissue injuries", "orthopedic");
		map.put("dysmenorrhea", "gynecology");
		map.put("skin infection", "dermatology");
		map.put("skin burn", "dermatology");
		map.put("ear pain", "ent");
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorById(int did) {
		return doctorRepo.findById(did).orElse(null);
	}

	@Override
	public void saveDoctorDetails(Doctor doctor) {
		doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctorsByCity(String city) {
		return doctorRepo.findAllByCity(city);
	}

	@Override
	public List<Doctor> getAllDoctorsByCityAndSpeciality(String city, String speciality) {
		return doctorRepo.findAllByCityAndSpeciality(city, speciality);
	}

	@Override
	public Doctor updateDoctorPhoneById(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public void deleteById(int did) {
		doctorRepo.deleteById(did);

	}

	@Override
	public List<Doctor> getDoctorBySymptom(String city, String symptom) {
		String speciality = map.get(symptom);
		if(speciality==null) {
			throw new NoDoctorForYourSymptomException("There isn't any doctor present at your location for your symptom");
		}
		List<Doctor> doctor = doctorRepo.findAllByCityAndSpeciality(city, speciality);
		if (doctor.isEmpty()) {
			throw new NoDoctorAtYourLocationException("We are still waiting to expand to you location");
		}
		return doctor;

	}
}
