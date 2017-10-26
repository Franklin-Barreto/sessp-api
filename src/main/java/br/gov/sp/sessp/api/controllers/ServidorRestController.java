package br.gov.sp.sessp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.sessp.api.models.Servidor;
import br.gov.sp.sessp.api.services.ServidorService;

@RestController
@RequestMapping("/servidor")
@CrossOrigin
public class ServidorRestController {

	@Autowired
	private ServidorService servidorService;

	@PostMapping
	public void salvarServidor(@RequestBody Servidor servidor) {
		System.out.println(servidor);
		servidorService.salvar(servidor);
	}

	@GetMapping("rsCodigo/{rsCodigo}/pvCodigo/{pvCodigo}")
	public Servidor buscar(@PathVariable Integer rsCodigo, @PathVariable int pvCodigo) {
		return servidorService.buscarServidor(rsCodigo, pvCodigo);
	}

	@GetMapping
	public List<Servidor> servidores() {
		return servidorService.listarServidores();
	}
}
