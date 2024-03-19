package br.com.fiap.InovaTechDuo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
=======
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Exames {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

<<<<<<< HEAD
    @NotNull
=======
    @NotBlank
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
    private LocalDate data;

    @NotBlank
    @Size(min = 4, max = 255)
    private String nome;

    @Size(min = 3, max = 500)
    private String localizacao; 
    
<<<<<<< HEAD
    @NotNull
=======
    @NotBlank
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
    private LocalDateTime horario;

    
    
}