package br.gov.sp.sessp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.Avaliador;
import br.gov.sp.sessp.api.repository.hierarquia.AvaliadorRepository;

@Service
public class HierarquiaService {

	@Autowired
	private AvaliadorRepository avaliadorRepository;

	public void salvarAvaliador(Avaliador avaliador) {
		avaliadorRepository.save(avaliador);
	}

	public List<Avaliador> listarAvaliadores() {
		return avaliadorRepository.findAll();
	}

}
