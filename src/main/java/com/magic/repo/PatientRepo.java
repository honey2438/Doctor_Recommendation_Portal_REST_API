package com.magic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
