package com.magic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.entities.Patient;
import com.magic.repo.PatientRepo;
import com.magic.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
@Autowired PatientRepo patientRepo;

@Override
public Patient getPatientById(int pid) {
return patientRepo.findById(pid).orElse(null);
}

@Override
public void savePatientDetails(Patient patient) {
	patientRepo.save(patient);
	
}
}
