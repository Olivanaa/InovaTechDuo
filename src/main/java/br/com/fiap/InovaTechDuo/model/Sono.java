package br.com.fiap.InovaTechDuo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Sono {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Positive
    private double meta;

    @NotBlank
    @Positive
    private double horasDormidas;
    
}
