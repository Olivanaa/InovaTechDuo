package br.com.fiap.InovaTechDuo.model;



import br.com.fiap.InovaTechDuo.validation.TipoCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Categorias {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @TipoCategoria
    private String nome;
    
    @TipoCategoria
    private String icone;


} 
    

