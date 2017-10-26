package br.gov.sp.sessp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.Servidor;
import br.gov.sp.sessp.api.repository.servidor.ServidorRepository;

@Service
public class ServidorService {

	@Autowired
	ServidorRepository servidorRepository;

	public void salvar(Servidor servidor) {
		System.out.println(servidor.getNome());
		servidorRepository.save(servidor);
	}

	public Servidor buscarServidor(Integer rsCodigo, int pvCodigo) {
		return servidorRepository.findByRsCodigoAndInfoServidorPvCodigo(rsCodigo, pvCodigo);
	}

	public List<Servidor> listarServidores() {
		return servidorRepository.findAll();
	}
}
