package com.magic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magic.entities.Doctor;
import com.magic.entities.Patient;
import com.magic.handler.DoctorNotFoundException;
import com.magic.handler.PatientNotFoundException;
import com.magic.service.DoctorService;
import com.magic.service.PatientService;

@RestController
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;

	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorList() {
		List<Doctor> doctor = doctorService.getAllDoctors();
		return ResponseEntity.ok(doctor);
	}

	@PostMapping("save-doctor")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor) {
		Doctor doctor1 = doctorService.getDoctorById(doctor.getDid());
		if (doctor1 == null) {
			doctorService.saveDoctorDetails(doctor);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctor);
	}

	@GetMapping("doctor-list-by-city")
	public ResponseEntity<List<Doctor>> getDoctorListByCity(@RequestParam("city") String city) {
		List<Doctor> doctor = doctorService.getAllDoctorsByCity(city);
		if (doctor.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found for this city");
		}
		return ResponseEntity.ok(doctor);
	}

	@GetMapping("doctor-list-by-city-and-speciality")
	public ResponseEntity<List<Doctor>> getDoctorListByCityAndSpeciality(@RequestParam("city") String city,
			@RequestParam("speciality") String speciality) {
		List<Doctor> doctor = doctorService.getAllDoctorsByCityAndSpeciality(city, speciality);
		if (doctor.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found for this city and speciality");
		}
		return ResponseEntity.ok(doctor);
	}

	@PatchMapping("update-doctor-phone")
	public ResponseEntity<Doctor> updateDoctorPhone(@RequestParam("phone") String phone, @RequestParam("did") int did) {
		Doctor doctor = doctorService.getDoctorById(did);

		if (doctor == null) {
			throw new DoctorNotFoundException("No Doctor with this id");
		}
		doctor.setPhone(phone);
		Doctor doctor1 = doctorService.updateDoctorPhoneById(doctor);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctor1);
	}

	@GetMapping("delete-doctor")
	public ResponseEntity<Doctor> deleteDoctorById(@RequestParam("did") int did) {
		Doctor doctor = doctorService.getDoctorById(did);
		if (doctor == null) {
			throw new DoctorNotFoundException("No doctor found for this city");
		}
		doctorService.deleteById(did);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("doctor-by-pid")
	public ResponseEntity<List<Doctor>> getDoctorsByPatientId(@RequestParam("pid") int pid) {
		Patient patient = patientService.getPatientById(pid);
		if (patient == null) {
			throw new PatientNotFoundException("No patient found with this id");
		}
		List<Doctor> doctor = doctorService.getDoctorBySymptom(patient.getCity(), patient.getSymptom());

		return ResponseEntity.ok(doctor);

	}

}
