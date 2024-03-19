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

import br.com.fiap.InovaTechDuo.model.Exames;
import br.com.fiap.InovaTechDuo.repository.ExamesRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("exames")
@Slf4j
public class ExamesController {

    @Autowired
    ExamesRepository repository;

    @GetMapping
    public List<Exames> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Exames create(@RequestBody Exames exame) {
        return repository.save(exame);
    }

    @GetMapping("{id}")
    public ResponseEntity<Exames> show(@PathVariable Long id) {
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
    public Exames update(@PathVariable Long id, @RequestBody Exames exame) {
        log.info("atualizar cadastro {} para {}", id, exame);

        verificarSeCategoriaExiste(id);
        exame.setId(id);
        return repository.save(exame);
    }

    private void verificarSeCategoriaExiste(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Categoria não encontrada"));
    }
}
