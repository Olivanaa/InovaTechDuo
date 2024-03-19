package br.com.fiap.InovaTechDuo.model;



<<<<<<< HEAD
import br.com.fiap.InovaTechDuo.validation.TipoCategoria;
=======
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
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
<<<<<<< HEAD

    @TipoCategoria
    private String nome;
    
    @TipoCategoria
=======
    private String nome;
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
    private String icone;


} 
    

