package br.com.ayrton.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ayrton.gerenciador.modelo.Banco;
import br.com.ayrton.gerenciador.modelo.Empresa;

public class ListaEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresas");
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		//chamar o JSP para mostrar os dados no navegador
			RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
			request.setAttribute("listaEmpresas",listaEmpresas);
			rd.forward(request, response);
	}
}
