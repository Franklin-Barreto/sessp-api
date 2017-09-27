package br.gov.sp.sessp.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Menu {

	@Id
	private Integer codigo;
	private String titulo;
	private String url;
	private List<SubMenu> subMenus;

	public Menu() {
	}

	public Menu(Integer codigo, String titulo, String url, List<SubMenu> subMenus) {

		this.codigo = codigo;
		this.titulo = titulo;
		this.url = url;
		this.subMenus = subMenus;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrl() {
		return url;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public void addSubMenu(SubMenu menu) {
		this.subMenus.add(menu);
	}

}
