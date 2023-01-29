package br.cefet.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.EstudanteDao;

public class EstudanteRemover extends HttpServlet implements IControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7124185348476337590L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) {

		int id = Integer.valueOf(req.getParameter("id"));
		EstudanteDao eDao = new EstudanteDao();		
		try {
			eDao.remover(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
