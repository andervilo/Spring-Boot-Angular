package br.com.controlefuncionarios.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefuncionarios.arquitetura.AbstractRestController;
import br.com.controlefuncionarios.model.Employees;
import br.com.controlefuncionarios.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController extends AbstractRestController<Employees, EmployeeService>{

}
