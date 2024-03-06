package br.com.fiap.InovaTechDuo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.InovaTechDuo.enums.CategoriasEnum;
import br.com.fiap.InovaTechDuo.enums.IconesEnum;
import br.com.fiap.InovaTechDuo.model.Categorias;

@RestController
@RequestMapping("explorar")
public class CategoriasController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categorias> repository = new ArrayList<>();

    @GetMapping
    public List<Categorias> index() {
        return repository;
    }

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria) {

        CategoriasEnum categoriaEnum = CategoriasEnum.valueOf(categoria.nome().toUpperCase());
        IconesEnum iconeEnum = IconesEnum.valueOf(categoria.icone().toUpperCase());

        List<CategoriasEnum> listCategorias = Arrays.asList(CategoriasEnum.values());
        List<IconesEnum> listIcone = Arrays.asList(IconesEnum.values());

        if (!listCategorias.contains(categoriaEnum) || !listIcone.contains(iconeEnum)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        log.info("Cadastrando categoria {}", categoria);
        repository.add(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);

    }

    @GetMapping("{id}")
    public ResponseEntity<Categorias> show(@PathVariable Long id) {
        log.info("buscando categoria com id {}", id);

        for (Categorias categoria : repository) {
            if (categoria.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(categoria);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}