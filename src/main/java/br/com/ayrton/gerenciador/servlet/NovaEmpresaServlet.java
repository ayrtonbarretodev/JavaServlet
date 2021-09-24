package br.com.ayrton.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		//o método getParameter sempre retorna uma String
		String nomeDaEmpresa = req.getParameter("nome"); //lendo um parâmetro a partir da requisição
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		//chamar o JSP para mostrar os dados no navegador
		RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
		rd.forward(req, resp);
	}

}
