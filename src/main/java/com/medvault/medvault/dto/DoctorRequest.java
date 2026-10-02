package com.medvault.medvault.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequest {
    @NotNull
    private Long userId;

    @NotBlank
    private String name;

    @NotBlank
    private String specialization;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phone;
}
