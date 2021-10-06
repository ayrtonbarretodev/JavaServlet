package br.com.ayrton.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoFormularioEmpresa implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("Formulário para cadastrar empresa");
		
		return "forward:formNovaEmpresa.jsp";
	}
}
