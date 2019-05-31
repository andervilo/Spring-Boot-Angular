package br.com.controlefuncionarios.service;

import org.springframework.stereotype.Service;

import br.com.controlefuncionarios.arquitetura.GenericService;
import br.com.controlefuncionarios.model.Employees;
import br.com.controlefuncionarios.repository.EmployeeRepository;

@Service
public class EmployeeService extends GenericService<EmployeeRepository, Employees> {

}
