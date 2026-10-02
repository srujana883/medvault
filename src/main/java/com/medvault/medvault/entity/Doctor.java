package com.medvault.medvault.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable=false)
     private String name;
    @NotBlank
    @Column(nullable = false)
    private  String Specialization;
    @NotBlank
    @Column(nullable = false)
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String Phone;
    @OneToOne
    @JoinColumn(name="user_id",nullable = false,unique = true)
     private  User user;

}
