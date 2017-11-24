package br.gov.sp.sessp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.sessp.api.models.Menu;
import br.gov.sp.sessp.api.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@PostMapping
	public void salvar(@RequestBody Menu menu) {
		menuService.salvar(menu);
	}

	@GetMapping
	public List<Menu> obterMenu() {
		return menuService.obterMenu();
	}
}
