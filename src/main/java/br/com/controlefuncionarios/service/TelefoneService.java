package br.com.controlefuncionarios.service;

import org.springframework.stereotype.Service;

import br.com.controlefuncionarios.arquitetura.GenericService;
import br.com.controlefuncionarios.model.Telefones;
import br.com.controlefuncionarios.repository.TelefoneRepository;

@Service
public class TelefoneService extends GenericService<TelefoneRepository, Telefones> {

}
