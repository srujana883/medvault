package com.medvault.medvault.controller;

import com.medvault.medvault.dto.DoctorRequest;
import com.medvault.medvault.entity.Doctor;
import com.medvault.medvault.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    private DoctorService doctorService;
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService=doctorService;
    }
    @PostMapping("api/doctors")
    public Doctor createDoctor(@Valid@RequestBody DoctorRequest doctorRequest){
        return doctorService.saveDoctor((doctorRequest));
    }

}
