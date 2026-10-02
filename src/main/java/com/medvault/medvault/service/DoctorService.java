package com.medvault.medvault.service;

import com.medvault.medvault.dto.DoctorRequest;
import com.medvault.medvault.entity.Doctor;
import com.medvault.medvault.entity.User;
import com.medvault.medvault.repository.DoctorRepository;
import com.medvault.medvault.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    public DoctorService(DoctorRepository doctorRepository,UserRepository userRepository){
        this.doctorRepository=doctorRepository;
        this.userRepository=userRepository;
    }
    public Doctor saveDoctor(DoctorRequest doctorRequest) {

        User user = userRepository.findById(doctorRequest.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with id: "
                                        + doctorRequest.getUserId()));

        Doctor doctor = new Doctor();

        doctor.setName(doctorRequest.getName());
        doctor.setSpecialization(doctorRequest.getSpecialization());
        doctor.setPhone(doctorRequest.getPhone());
        doctor.setUser(user);

        return doctorRepository.save(doctor);
    }
}
