package br.com.controlefuncionarios.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.controlefuncionarios.arquitetura.BaseEntity;

@Entity
public class Telefones extends BaseEntity {

	private static final long serialVersionUID = 3400308600629566411L;
	
	private String numero;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employees employee;

	public Telefones(String numero, Employees employee) {
		super();
		this.numero = numero;
		this.employee = employee;
	}

	public Telefones() {
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	
	

}
