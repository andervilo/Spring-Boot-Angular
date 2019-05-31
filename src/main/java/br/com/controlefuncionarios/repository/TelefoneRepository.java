package br.com.controlefuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefuncionarios.model.Telefones;

public interface TelefoneRepository extends JpaRepository<Telefones, Long>{

}
