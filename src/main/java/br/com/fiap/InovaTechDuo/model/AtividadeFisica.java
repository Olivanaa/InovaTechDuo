package br.com.fiap.InovaTechDuo.model;

import br.com.fiap.InovaTechDuo.validation.TipoAtividade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class AtividadeFisica {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @TipoAtividade
    private String tipo;

    @Positive
    private double tempo;
    
    private String calorias;
    
}
