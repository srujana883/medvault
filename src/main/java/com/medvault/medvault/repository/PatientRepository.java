package com.medvault.medvault.repository;
import com.medvault.medvault.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Long>{

}
