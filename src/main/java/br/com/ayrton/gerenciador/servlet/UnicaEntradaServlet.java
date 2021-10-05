package br.com.ayrton.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String caminho = null;
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			caminho = acao.executa(request, response);
		}else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			caminho = acao.remove(request, response);
		}else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			caminho = acao.mostrarEmpresa(request, response);
		}else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			caminho = acao.novaEmpresa(request, response);
		}else if(paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			caminho = acao.alteraEmpresa(request, response);
		}else if(paramAcao.equals("FormularioEmpresa")) {
			NovoFormularioEmpresa acao = new NovoFormularioEmpresa();
			caminho = acao.formNovaEmpresa(request, response);
		}
		
		String[] tipoEndereco = caminho.split(":");
		
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}
}
