package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Estudante;

public class EstudanteDao {
	
private Connection con = null;

	
	public EstudanteDao() {
		con = ConnectionFactory.getConnection();
	}
	

	public void adicionar(Estudante estudante) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert into estudante (nome, matricula) " + " values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, estudante.getNome());
		stmt.setInt(2, estudante.getMatricula());
		System.out.println(estudante.getNome());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Estudante> listar(String texto) throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		texto = "%" + texto + "%";
		String sql = "select nome, matricula, id from estudante where " + 
		" nome like (?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, texto);
		ResultSet rs = stmt.executeQuery();

		Estudante estudante = null;
		List<Estudante> estudantes = new ArrayList<Estudante>();
		
		while(rs.next()) {
			
			String nome = rs.getString("nome");
			int matricula = rs.getInt("matricula");
			int id = rs.getInt("id");
		
			estudante = new Estudante();
			estudante.setNome(nome);
			estudante.setMatricula(matricula);
			estudante.setId(id);
			
			estudantes.add(estudante);
		}
		return estudantes;
	}
	
public void remover(int id) throws SQLException {
		
		String sql = "delete from estudante where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
		}
	
	public void alterar(Estudante estudante) throws SQLException {
		String sql = "update estudante set nome = ?, matricula = ? "
				+ " where id = ?";
				
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, estudante.getNome());
		stmt.setInt(2, estudante.getMatricula());
		stmt.setInt(3, estudante.getId());
		stmt.execute();
		stmt.close();
		con.close();
		}

	public Estudante buscarUm(int id) throws SQLException {
		String sql = "select * from estudante where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
	
		ResultSet rs = stmt.executeQuery();
		Estudante estudante = null;
		
		if (rs.next()) {
			estudante = new Estudante();
			estudante.setId(rs.getInt("id"));
			estudante.setNome(rs.getString("nome"));
			estudante.setMatricula(rs.getInt("matricula"));

		}
		stmt.execute();
		stmt.close();
		con.close();
		return estudante;
	}
	
	
}


