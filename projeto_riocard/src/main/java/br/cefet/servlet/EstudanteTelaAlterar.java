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


public class EstudanteTelaAlterar extends HttpServlet implements IControl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5896482377536503230L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Pegar o ID
		int id = Integer.valueOf(req.getParameter("id"));
		Estudante estudante = null;
	
		// Buscar no banco o registro do ID (PostDao)
		EstudanteDao eDao = new EstudanteDao();	
		try {
			estudante = eDao.buscarUm(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Despachar no Form
		
		req.setAttribute("estudante", estudante);
	    RequestDispatcher rd = req.getRequestDispatcher("/form/frmestudantealterar.jsp");
	    rd.forward(req, res);
		
	}
	
	

}
