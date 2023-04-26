package com.magic.service;

import com.magic.entities.Patient;

public interface PatientService {

	Patient getPatientById(int pid);

	void savePatientDetails(Patient patient);

}
