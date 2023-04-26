package com.magic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.entities.Patient;
import com.magic.handler.PatientNotFoundException;
import com.magic.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	PatientService patientService;

	@PostMapping("add-patient")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient) {
		Patient patient1 = patientService.getPatientById(patient.getPid());
		if (patient1 != null) {
			throw new PatientNotFoundException("Patient with this id already exist");
		}
		patientService.savePatientDetails(patient);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(patient);
	}
}
