package br.gov.sp.sessp.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.sessp.api.models.UnidadeAdministrativa;
import br.gov.sp.sessp.api.models.UnidadeDespesa;
import br.gov.sp.sessp.api.models.UnidadeOrcamentaria;
import br.gov.sp.sessp.api.services.UnidadesService;

@RestController
@RequestMapping("/unidades")
public class UnidadesRestController {

	@Autowired
	private UnidadesService unidadeService;

	
	@GetMapping("/uos")
	public List<UnidadeOrcamentaria> getUos() {
		return unidadeService.getUos();
	}

	@PostMapping("/uos")
	public ResponseEntity<UnidadeOrcamentaria> save(@RequestBody UnidadeOrcamentaria uo) {

		UnidadeOrcamentaria result = unidadeService.save(uo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getCodigoUo()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/uos")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar() {
		unidadeService.deletarUos();
	}

	@PutMapping("/uos/{id}/ud")
	public void adicionarUd(@PathVariable Integer id, @RequestBody UnidadeDespesa ud) {
		UnidadeOrcamentaria uo = unidadeService.getUoById(id);
		uo.adicionarUnidadeDespesa(ud);
		unidadeService.adicionarUd(uo);
	}

	@GetMapping("/uos/{id}/uds")
	public List<UnidadeDespesa> getUdsByUo(@PathVariable Integer id) {
		return unidadeService.getUdsByUo(id);
	}

	@GetMapping("/uos/{uo}/uds/{ud}/uas/{ua}")
	public UnidadeAdministrativa getUasByUoAndUd(@PathVariable Integer uo, @PathVariable Integer ud,
			@PathVariable Integer ua) {
		return unidadeService.uas(uo, ud, ua);
	}

	@GetMapping("/uos/{uo}/ud/{ud}")
	public UnidadeDespesa getUdById(@PathVariable Integer uo, @PathVariable Integer ud) {
		return unidadeService.ud(uo, ud);
	}

	@GetMapping("/uas")
	public List<UnidadeAdministrativa> listarUas() {
		return unidadeService.listarUas();
	}

}
