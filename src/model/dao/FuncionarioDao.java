package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import felipe.jdbc.model.Contato;
import model.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDao {
    private Connection connection;
    
    public FuncionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insereFuncio(Funcionario funcionario) {
        String sql = "insert into funcionarios (senha,cpf,nome,email,cargo,departamento,perfil,matricula)" +
        		" values (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setLong(1, funcionario.getSenha());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getNome());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getDepartamento());
            stmt.setString(7, funcionario.getPerfil());
            stmt.setLong(8, funcionario.getMatricula());
            
            stmt.execute();
            stmt.close();
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
	public List<Funcionario > getLista() {
		try {
			List<Funcionario > funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario  contato = new Funcionario ();
//				contato.setId(rs.getLong("id"));
//				contato.setNome(rs.getString("nome"));
//				contato.setEmail(rs.getString("email"));
//				contato.setEndereco(rs.getString("endereco"));
//
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dtNascimento"));
//				contato.setDtNascimento(data);
//
//				contatos.add(contato);
//			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
