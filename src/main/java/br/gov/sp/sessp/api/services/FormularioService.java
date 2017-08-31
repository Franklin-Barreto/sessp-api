package br.gov.sp.sessp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.Formulario;
import br.gov.sp.sessp.api.repository.formulario.FormularioRepository;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository repository;

	public void save(Formulario form) {
		this.repository.save(form);
	}

	public List<Formulario> getAllForms() {
		return this.repository.findAll();
	}

	public Formulario getById(Integer id) {
		return this.repository.findOne(id);
	}

	public void update(Formulario form) {
		this.repository.update(form);
	}

	public void deleteAll() {
		this.repository.deleteAll();
	}

}