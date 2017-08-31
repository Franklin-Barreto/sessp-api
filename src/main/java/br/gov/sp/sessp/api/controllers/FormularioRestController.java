package br.gov.sp.sessp.api.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.sessp.api.models.Fator;
import br.gov.sp.sessp.api.models.Formulario;
import br.gov.sp.sessp.api.models.Questao;
import br.gov.sp.sessp.api.services.FormularioService;



@RestController
@RequestMapping("/form")
public class FormularioRestController {

	@Autowired
	FormularioService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Formulario form) {
		this.service.save(form);
		return ResponseEntity.ok("criado");
	}

	@RequestMapping(value = "/createTest", method = RequestMethod.GET)
	public ResponseEntity<String> createTest() {
		List<Questao> questions = new ArrayList<Questao>();

		questions.add(new Questao(5,
				"Realizou de forma adequada os encaminhamentos internos e externos, analisando os impactos nas pessoas e nos resultados."));
		questions.add(new Questao(6, "Os atendimentos prestados foram assertivos, eficazes e efetivos."));
		questions.add(new Questao(7,
				"Minimizou a ocorrência de retrabalhos, corrigindo falhas e adotando medidas preventivas."));
		questions.add(new Questao(8,
				"Priorizou atividades conforme grau de relevância para atingir os resultados esperados."));

		Fator factor = new Fator(2, "II. Grau de resolutividade",
				"Capacidade de agir com rapidez e flexibilidade, antecipando-se na resolução de problemas e/ou na execução das atividades.",
				questions);

		Formulario form = this.service.getById(1);
		// List<Fator> factors = form.getFatores();
		form.addFator(factor);
		System.out.println(form.getFatores().get(0).getQuestoes().get(0).getDescricao());
		// this.service.deleteAll();
		this.service.save(form);
		return ResponseEntity.ok("criado");
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateForm(@RequestBody Formulario form) {
		this.service.save(form);
		return ResponseEntity.ok("atualizado");

	}
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Formulario> forms() {
		return this.service.getAllForms();
	}

}