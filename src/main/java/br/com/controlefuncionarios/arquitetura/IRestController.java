package br.com.controlefuncionarios.arquitetura;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IRestController<E> {
		
	public ResponseEntity<?> listAll();	
	public ResponseEntity<?> showById(@PathVariable(value = "id") Long id);	
	public ResponseEntity<?> create(@Valid @RequestBody E object, Errors errors);	
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody E object, Errors errors);	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id);

}
