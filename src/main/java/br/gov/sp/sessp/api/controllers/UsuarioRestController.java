package br.gov.sp.sessp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.sessp.api.models.Usuario;
import br.gov.sp.sessp.api.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {

		usuarioService.cadastrarUsuario(usuario);
	}
}
