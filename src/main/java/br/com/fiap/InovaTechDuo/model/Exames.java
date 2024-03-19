package br.com.fiap.InovaTechDuo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Exames {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private LocalDate data;

    @NotBlank
    @Size(min = 4, max = 255)
    private String nome;

    @Size(min = 3, max = 500)
    private String localizacao; 
    
    @NotBlank
    private LocalDateTime horario;

    
    
}