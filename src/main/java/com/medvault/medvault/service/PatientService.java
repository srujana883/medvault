package com.medvault.medvault.service;
import com.medvault.medvault.entity.Patient;
import com.medvault.medvault.entity.User;
import com.medvault.medvault.repository.PatientRepository;
import com.medvault.medvault.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.medvault.medvault.exception.PatientNotFoundException;
import java.util.List;
import com.medvault.medvault.dto.PatientRequest;
@Service
public class PatientService {
    private PatientRepository patientRepository;
    private UserRepository userRepository;
    public PatientService(PatientRepository patientRepository,UserRepository userRepository){
        this.patientRepository=patientRepository;
        this.userRepository=userRepository;

    }
    public Patient savePatient(PatientRequest patientRequest){

        Patient patient = new Patient();

        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setPhone(patientRequest.getPhone());
        User user = userRepository.findById(patientRequest.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: "
                                + patientRequest.getUserId()));

        patient.setUser(user);

        return patientRepository.save(patient);
    }
    public Patient getPatientById(Long id){
        return patientRepository.findById(id)
                .orElseThrow(()->new PatientNotFoundException("patient not found with id"+id));
    }
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient UpdatePatient(Long id, Patient patient){
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found with id: " + id));
        existingPatient.setName(patient.getName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setPhone(patient.getPhone());
        return patientRepository.save(existingPatient);
    }
    public void deletepatient(Long id){
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(existingPatient);

    }

}
