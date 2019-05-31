package br.com.controlefuncionarios.arquitetura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;



public class GenericService<R extends JpaRepository<E, Long>, E extends BaseEntity> implements IService<E,R>{
	
	@Autowired
	private R repository;

	@Override
	public List<?> findAll() {
		return repository.findAll();
	}

	@Override
	public E findById(Long id) {
		Optional<E> model = repository.findById(id);
		if(model.isPresent()) return model.get();
		return null;
	}

	@Override
	public E create(E object) {
		return repository.saveAndFlush(object);
	}

	@Override
	public E update(Long id, E object) {
		Optional<E> model = repository.findById(id);
		if(model.isPresent()) {
			BeanUtils.copyProperties(object, model.get(), "id");
			return repository.saveAndFlush(model.get());			
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		Optional<E> model = repository.findById(id);
		if(model.isPresent()) {
			repository.delete(model.get());			
			return true;			
		}
		return false;
	}

	@Override
	public JpaRepository<E, Long> getRepository() {
		return this.repository;
	}	
	

}
