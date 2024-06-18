package com.example.springGrpcExample.persistence.record;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UsersTRec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="identifier")
    private Long id;

    @Column(name="full_name", length = 40, nullable = false)
    private String fullName;

    @Column(name="email", length = 50, unique = true, nullable = false)
    private String email;

}
