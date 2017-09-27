package br.gov.sp.sessp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.Menu;
import br.gov.sp.sessp.api.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menurepo;

	public Menu salvar(Menu menu) {
		return menurepo.save(menu);
	}
	
	public List<Menu> obterMenu(){
		return menurepo.findAll();
	}
}
