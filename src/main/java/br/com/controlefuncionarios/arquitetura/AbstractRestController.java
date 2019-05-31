package br.com.controlefuncionarios.arquitetura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SuppressWarnings("rawtypes")
public abstract class AbstractRestController<E extends BaseEntity, S extends IService>  implements IRestController<E>{
	@Autowired
	private S service;
	
	@SuppressWarnings("unchecked")
	@GetMapping("")
	@Override
	public ResponseEntity<?> listAll() {
		List<E> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<E> showById(@PathVariable Long id) {
		E entity = (E) service.findById(id);
		if(entity==null)
			return ResponseEntity.notFound().build();
		return (ResponseEntity<E>) ResponseEntity.ok().body(entity);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("")
	@Override
	public ResponseEntity<?> create(@Valid @RequestBody E object , Errors errors) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();

        if (errors.hasErrors()) {	
            return ResponseEntity.badRequest().body(UtilsValidator.formatarErros(errors));
        }
		
		if(object == null) {
			map.put("success", false);
			map.put("message", "Requisição feita com objeto nulo!");
			return ResponseEntity.badRequest().body(map);
		}
		
		E entity = (E) service.create(object);
		
		if(entity == null) {
			map.put("success", false);
			map.put("message", "Não foi possível executar esta operação!");
			return ResponseEntity.badRequest().body(map);
		}
		
		map.put("success", true);
		map.put("data", entity);
		map.put("message", "Operação realizada com sucesso!");
		
		return ResponseEntity.ok().body(map);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<?> update(Long id, @Valid E object, Errors errors) {
		Map<Object, Object> map = new HashMap<Object, Object>();

        if (errors.hasErrors()) {	
            return ResponseEntity.badRequest().body(UtilsValidator.formatarErros(errors));
        }
		
		if(object == null) {
			map.put("success", false);
			map.put("message", "Requisição feita com objeto nulo!");
			return ResponseEntity.badRequest().body(map);
		}
		
		
		E entity = (E) service.update(id, object);
		
		if(entity == null) {
			map.put("success", false);
			map.put("message", "Não foi possível executar esta operação!");
			return ResponseEntity.badRequest().body(map);
		}
		
		map.put("success", true);
		map.put("data", entity);
		map.put("message", "Operação realizada com sucesso!");
		
		return ResponseEntity.ok().body(map);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Map<Object, Object>> delete(@PathVariable Long id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(service.delete(id)) {
			map.put("success", true);
			return ResponseEntity.ok().body(map);
		}
		
		map.put("success", false);
		return ResponseEntity.ok().body(map);
	}

	public S getService() {
		return service;
	}	
}
