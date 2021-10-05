package br.com.ayrton.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ayrton.gerenciador.modelo.Banco;
import br.com.ayrton.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	public void novaEmpresa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("Cadastrando nova empresa");
		
		//o método getParameter sempre retorna uma String
		String nomeDaEmpresa = req.getParameter("nome"); //lendo um parâmetro a partir da requisição
		String paramDataEmpresa = req.getParameter("data");
		
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		req.setAttribute("empresa",empresa.getNome());
		resp.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
