package br.com.controlefuncionarios.arquitetura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




public interface IService<E extends BaseEntity, R extends JpaRepository<E, Long>> {
		
	public abstract List<?> findAll();
	
	public abstract E findById(Long id);
	
	public abstract E create(E object);
	
	public abstract E update(Long id, E object);
	
	public abstract boolean delete(Long id);	
	
	public JpaRepository<E, Long> getRepository();

}
