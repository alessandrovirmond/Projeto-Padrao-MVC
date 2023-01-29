package br.cefet.servlet;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.UsuarioDao;
import br.cefet.model.Usuario;

public class UsuarioAdicionar extends HttpServlet implements IControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("entrou UsuarioADD");
		// 1. Extrair os dados do form (get)
		String nome = null;
		String login = null;
		String senha = null;
		
		nome = String.valueOf(req.getParameter("nome"));
		login = String.valueOf(req.getParameter("login"));
		senha = String.valueOf(req.getParameter("senha"));

		// 2. Instanciar um Usuario
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setLogin(login);

		// 3. Instanciar um UsuarioDao
		UsuarioDao uDao = new UsuarioDao();
		String msg = null;
		try {
			uDao.add(usuario);
			msg = "Usuário registrado.";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg = "Não foi possível registrar o usuário!";
		}
		
		req.setAttribute("msg", msg);
		String nextPage = req.getParameter("nextPage");
	    RequestDispatcher rd = req.getRequestDispatcher(nextPage);
	    rd.forward(req, res);
	}

}
