package br.cefet.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.EstudanteDao;
import br.cefet.model.Estudante;

public class ServletEstudanteListar extends HttpServlet implements IControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		String texto = null;
		List<Estudante> estudantes = null;
		EstudanteDao eDao = new EstudanteDao();
		
		texto = req.getParameter("texto");
		
		try {
			estudantes = eDao.listar(texto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("estudantes", estudantes);
		
		RequestDispatcher rd = req.getRequestDispatcher("/form/estudantelistar.jsp");
		rd.forward(req, res);
		
	}

}