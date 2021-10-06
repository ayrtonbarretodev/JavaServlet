package br.com.ayrton.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ayrton.gerenciador.acao.Acao;
import br.com.ayrton.gerenciador.acao.AlteraEmpresa;
import br.com.ayrton.gerenciador.acao.ListaEmpresas;
import br.com.ayrton.gerenciador.acao.MostraEmpresa;
import br.com.ayrton.gerenciador.acao.NovaEmpresa;
import br.com.ayrton.gerenciador.acao.NovoFormularioEmpresa;
import br.com.ayrton.gerenciador.acao.RemoveEmpresa;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.ayrton.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome ...
			Acao acao = (Acao) classe.newInstance(); //criar uma instância da classe
			nome = acao.executa(request,response); //executa o método da interface
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		//caminnho para acessar qualquer página
		//http://localhost:8080/gerenciador/entrada?acao=NomeDaClasse
		//Ex: http://localhost:8080/gerenciador/entrada?acao=NovoFormularioEmpresa

		
		String[] tipoEndereco = nome.split(":");
				
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}
}
