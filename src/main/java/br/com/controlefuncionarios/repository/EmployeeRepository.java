package br.com.controlefuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefuncionarios.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

}
