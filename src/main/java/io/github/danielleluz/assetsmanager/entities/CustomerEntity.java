package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}")
    private String taxId;

    @NotBlank
    private String externalId;

    @NotBlank
    private String street;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipCode;

    @OneToMany(mappedBy = "customer")
    private List<AgreementEntity> agreements;
}
