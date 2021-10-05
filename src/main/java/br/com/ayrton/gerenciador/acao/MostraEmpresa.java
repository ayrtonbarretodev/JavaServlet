package br.com.ayrton.gerenciador.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ayrton.gerenciador.modelo.Banco;
import br.com.ayrton.gerenciador.modelo.Empresa;

public class MostraEmpresa {
	
	public String mostrarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando empresas");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscarEmpresaPeloId(id);
		
		request.setAttribute("buscaEmpresa",empresa);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
