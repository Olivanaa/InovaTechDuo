package br.com.fiap.InovaTechDuo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
import lombok.Data;

@Data
@Entity
public class Sono {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

<<<<<<< HEAD
    @NotNull
    @DecimalMin(value = "0.0")
    private double meta;

    @NotNull
    @DecimalMin(value = "0.0")
=======
    @NotBlank
    @Positive
    private double meta;

    @NotBlank
    @Positive
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
    private double horasDormidas;
    
}
