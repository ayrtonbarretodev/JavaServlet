package br.com.ayrton.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return listaEmpresas;
	}
	
	public 	Empresa buscarEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public 	Usuario existeUsuario(String nome, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(nome, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	public void delete(Integer id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator(); //funciona parecido com um for
		
		while(it.hasNext()) { //enquanto tiver um próximo
			Empresa emp = it.next(); //vá avançando
			
			if(emp.getId() == id) { // e se o id da empresa for igual ao id recebido, a empresa é removida
				it.remove(); //remove a empresa
			}
		}
	}

}
