package br.gov.sp.sessp.api.models;

public class SubMenu {

	private String titulo;
	private String url;

	public SubMenu() {
	}

	public SubMenu(String titulo, String url) {

		this.titulo = titulo;
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrl() {
		return url;
	}

}
