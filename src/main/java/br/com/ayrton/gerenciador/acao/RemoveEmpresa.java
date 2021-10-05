package br.com.ayrton.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ayrton.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("removendo empresa");
		
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.delete(id);
		
		resp.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
