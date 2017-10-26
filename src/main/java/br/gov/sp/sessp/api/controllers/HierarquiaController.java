package br.gov.sp.sessp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.sessp.api.models.Avaliador;
import br.gov.sp.sessp.api.services.HierarquiaService;

@RestController
@RequestMapping("/hierarquia")
@CrossOrigin
public class HierarquiaController {

	@Autowired
	private HierarquiaService hierarquia;

	@PostMapping("/avaliador")
	public void salvarAvaliador(@RequestBody Avaliador avaliador) {
		hierarquia.salvarAvaliador(avaliador);
	}

	@GetMapping("/avaliador")
	public List<Avaliador> listarAvaliadores() {
		return hierarquia.listarAvaliadores();
	}

}
