package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDao {
    private Connection connection;
    
    public FuncionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insereFuncio(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (senha,cpf,nome,email,cargo,departamento,perfil,matricula)" +
        		" VALUES (?,?,?,?,?,?,?,?)";
        
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
    
	public List<Funcionario> getListaFuncio() {
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM funcionarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario  funcionario = new Funcionario ();
				funcionario.setMatricula(rs.getLong("matricula"));
				funcionario.setSenha(rs.getLong("senha"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setDepartamento(rs.getString("departamento"));
				funcionario.setPerfil(rs.getString("perfil"));
				
				funcionarios.add(funcionario);				
			}
			rs.close();
			stmt.close();
			return funcionarios;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
