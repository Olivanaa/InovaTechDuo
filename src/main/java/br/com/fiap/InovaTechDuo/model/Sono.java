package br.com.fiap.InovaTechDuo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Sono {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @DecimalMin(value = "0.0")
    private double meta;

    @NotNull
    @DecimalMin(value = "0.0")
    private double horasDormidas;
    
}
