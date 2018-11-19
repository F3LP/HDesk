package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Chamado;
import model.ConnectionFactory;
import model.Funcionario;

public class ChamadoDao {
	private Connection connection;

	public ChamadoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insereChamado(Chamado chamado) {
		String sql = "insert into chamado (funcionario_mat,tipo,departamento,urgencia,titulo,descricao,dtAbertura,status)" +
				" values (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, chamado.getFuncionario().getMatricula());
			stmt.setString(2, chamado.getTipo());
			stmt.setString(3, chamado.getDepartamento());
			stmt.setString(4, chamado.getUrgencia());
			stmt.setString(5, chamado.getTitulo());
			stmt.setString(6, chamado.getDescricao());
			stmt.setDate(7, new Date(chamado.getDtAbertura().getTimeInMillis()));
			stmt.setString(8, chamado.getStatus());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Chamado> getListaChamado() {
		try {
			List<Chamado> chamados = new ArrayList<Chamado>();
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT protocolo,tipo,departamento,urgencia,titulo,descricao,status,dtAbertura FROM chamado");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setProtocolo(rs.getLong("protocolo"));
				chamado.setTipo(rs.getString("tipo"));
				chamado.setDepartamento(rs.getString("departamento"));
				chamado.setUrgencia(rs.getString("urgencia"));
				chamado.setTitulo(rs.getString("titulo"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				
				Calendar dtAbertura = Calendar.getInstance();
				dtAbertura.setTime(rs.getDate("dtAbertura"));
				chamado.setDtAbertura(dtAbertura);
							
				chamados.add(chamado);				
			}
			rs.close();
			stmt.close();
			return chamados;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Chamado> getListaChamado(Funcionario funcionario) {	
		long funcionario_mat = funcionario.getMatricula();
		try {
			List<Chamado> chamados = new ArrayList<Chamado>();
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT protocolo,tipo,departamento,urgencia,titulo,descricao,status,dtAbertura FROM chamado WHERE funcionario_mat = " 
					+ funcionario.getMatricula() + " AND status = 'Pendente' OR status = 'Aberto'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setProtocolo(rs.getLong("protocolo"));
				chamado.setTipo(rs.getString("tipo"));
				chamado.setDepartamento(rs.getString("departamento"));
				chamado.setUrgencia(rs.getString("urgencia"));
				chamado.setTitulo(rs.getString("titulo"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				
				Calendar dtAbertura = Calendar.getInstance();
				dtAbertura.setTime(rs.getDate("dtAbertura"));
				chamado.setDtAbertura(dtAbertura);
							
				chamados.add(chamado);				
			}
			rs.close();
			stmt.close();
			return chamados;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
