package br.gov.sp.sessp.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.Usuario;
import br.gov.sp.sessp.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
