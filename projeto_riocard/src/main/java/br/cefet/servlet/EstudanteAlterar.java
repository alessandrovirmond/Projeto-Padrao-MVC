package br.cefet.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.EstudanteDao;

import br.cefet.model.Estudante;


public class EstudanteAlterar extends HttpServlet implements IControl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String msg = null;
		int id = Integer.valueOf(req.getParameter("id"));
		String nome = String.valueOf(req.getParameter("nome"));
		int matricula = Integer.valueOf(req.getParameter("matricula"));
		
		Estudante estudante = new Estudante();
		estudante.setId(id);
		estudante.setNome(nome);
		estudante.setMatricula(matricula);
		
		EstudanteDao eDao = new EstudanteDao();
		try {
			eDao.alterar(estudante);
			msg ="Estudante alterado com sucesso!!!";
		} catch (SQLException e) {
			msg ="Tente mais tarde!";
		}
		
		req.setAttribute("msg", msg);
		String nextPage = req.getParameter("nextPage");
	    RequestDispatcher rd = req.getRequestDispatcher(nextPage);
	    rd.forward(req, res);

	
	}

}
