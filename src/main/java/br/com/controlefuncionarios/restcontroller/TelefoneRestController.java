package br.com.controlefuncionarios.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefuncionarios.arquitetura.AbstractRestController;
import br.com.controlefuncionarios.model.Telefones;
import br.com.controlefuncionarios.service.TelefoneService;

@RestController
@RequestMapping("/api/v1/telefones")
public class TelefoneRestController extends AbstractRestController<Telefones, TelefoneService>{

}
