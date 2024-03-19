package br.com.fiap.InovaTechDuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.InovaTechDuo.model.Alimentacao;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long>{
    
}
