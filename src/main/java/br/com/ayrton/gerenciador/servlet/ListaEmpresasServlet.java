package br.com.ayrton.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListaEmpresasServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		//chamar o JSP para mostrar os dados no navegador
			RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
			request.setAttribute("listaEmpresas",listaEmpresas);
			rd.forward(request, response);
		
	}

}
