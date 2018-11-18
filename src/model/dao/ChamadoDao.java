package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Chamado;
import model.ConnectionFactory;

public class ChamadoDao {
	private Connection connection;

	public ChamadoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insereChamado(Chamado chamado) {
		String sql = "insert into chamado (funcionario_mat,tipo,departamento,urgencia,titulo,descricao)" +
				" values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, chamado.getFuncionario().getMatricula());
			stmt.setString(2, chamado.getTipo());
			stmt.setString(3, chamado.getDepartamento());
			stmt.setString(4, chamado.getUrgencia());
			stmt.setString(5, chamado.getTitulo());
			stmt.setString(6, chamado.getDescricao());
		
			JOptionPane.showMessageDialog(null, "Matrícula: " + chamado.getFuncionario().getMatricula());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
