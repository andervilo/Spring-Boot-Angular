package br.com.controlefuncionarios.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.controlefuncionarios.arquitetura.BaseEntity;


@Entity
@Table(name = "employess")
public class Employees extends BaseEntity {

	private static final long serialVersionUID = 6626876386862559849L;
	
	private String name;
	private String email;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	private List<Telefones> telefones;
	
	public Employees() {
	}	

	public Employees(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addTelefone(Telefones telefone) {
		telefone.setEmployee(this);
		this.telefones.add(telefone);
	}
	
	public void removeTelefone(Telefones telefone) {
		telefone.setEmployee(null);
		this.telefones.remove(telefone);
	}

	public List<Telefones> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefones> telefones) {
		telefones.forEach(t->{
			t.setEmployee(this);
		});
		
		this.telefones = telefones;
	}	
	
	
}
