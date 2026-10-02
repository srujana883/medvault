package com.medvault.medvault.controller;
import com.medvault.medvault.dto.PatientRequest;
import com.medvault.medvault.entity.Patient;
import org.springframework.web.bind.annotation.RestController;
import com.medvault.medvault.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import com.medvault.medvault.dto.PatientRequest;
import jakarta.validation.Valid;
@RestController
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService){

        this.patientService=patientService;
    }
    @PostMapping("/api/patients")
    public Patient createPatient(@Valid @RequestBody PatientRequest patientRequest){
       return   patientService.savePatient(patientRequest);

    }
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/api/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);

    }
    @GetMapping("/api/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
    @PutMapping("/api/patients/{id}")
    public Patient UpdatePatient(@PathVariable long id,@RequestBody Patient patient){
        return patientService.UpdatePatient(id, patient);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/patients/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletepatient(id);
    }
}
