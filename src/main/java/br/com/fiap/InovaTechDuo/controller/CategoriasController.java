package br.com.fiap.InovaTechDuo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.status;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.InovaTechDuo.enums.CategoriasEnum;
import br.com.fiap.InovaTechDuo.enums.IconesEnum;
import br.com.fiap.InovaTechDuo.model.Categorias;
import br.com.fiap.InovaTechDuo.repository.CategoriasRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("explorar")
@Slf4j
public class CategoriasController {

    @Autowired
    CategoriasRepository repository;

    @GetMapping
    public List<Categorias> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria) {

        CategoriasEnum categoriaEnum = CategoriasEnum.valueOf(categoria.getNome().toUpperCase());
        IconesEnum iconeEnum = IconesEnum.valueOf(categoria.getIcone().toUpperCase());

        List<CategoriasEnum> listCategorias = Arrays.asList(CategoriasEnum.values());
        List<IconesEnum> listIcone = Arrays.asList(IconesEnum.values());

        if (listCategorias.contains(categoriaEnum) || listIcone.contains(iconeEnum)) {
            repository.save(categoria);
            return status(CREATED).body(categoria);
        }

        return status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("{id}")
    public ResponseEntity<Categorias> show(@PathVariable Long id) {
        log.info("buscando categoria com id {}", id);

        return repository.findById(id).map(ResponseEntity::ok).orElse(status(NOT_FOUND).build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando categoria {}", id);
        
        verificarSeCategoriaExiste(id);
        repository.deleteById(id);
    }

    private void verificarSeCategoriaExiste(Long id) {
        repository.findById(id).orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Categoria não encontrada"));
    }

}