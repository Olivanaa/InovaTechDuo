package br.com.fiap.InovaTechDuo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.InovaTechDuo.model.Sono;
import br.com.fiap.InovaTechDuo.repository.SonoRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("sono")
@Slf4j
public class SonoController {

    @Autowired
    SonoRepository repository;

    @GetMapping
    public List<Sono> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Sono create(@RequestBody Sono sono) {
        return repository.save(sono);
    }

    @GetMapping("{id}")
    public ResponseEntity<Sono> show(@PathVariable Long id) {
        log.info("buscando cadastro com id {}", id);

        return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(status(NOT_FOUND).build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando cadastro {}", id);

        verificarSeCategoriaExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Sono update(@PathVariable Long id, @RequestBody Sono sono) {
        log.info("atualizar cadastro {} para {}", id, sono);

        verificarSeCategoriaExiste(id);
        sono.setId(id);
        return repository.save(sono);
    }

    private void verificarSeCategoriaExiste(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Categoria não encontrada"));
    }
}
