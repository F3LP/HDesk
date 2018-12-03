package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Funcionario;
import model.Tecnico;
import model.Usuario;
import model.dao.FuncionarioDao;
import view.TelaInicialTecnico;
import view.TelaInicialUsuario;
import view.TelaLogin;

public class ControleAutenticacao {

	public ControleAutenticacao(TelaLogin telaLogin, JTextField tfMatricula, JPasswordField tfSenha) {

		TelaInicialTecnico telaTec;
		TelaInicialUsuario telaUsuario;
		Funcionario autenticado = null;
		boolean autentica = false;
		String password = String.valueOf(tfSenha.getPassword());	
		FuncionarioDao dao = new FuncionarioDao();

		List<Funcionario> funcionarios = dao.getListaFuncio();

		try {
			for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == Long.parseLong(tfMatricula.getText()) && 
					funcionario.getSenha().equals(password)) {
			    autentica = true;          
				if (funcionario.getPerfil().equals("Técnico")) {
					autenticado = new Tecnico();
					autenticado.setNome(funcionario.getNome());
					autenticado.setMatricula(funcionario.getMatricula());
					telaTec = new TelaInicialTecnico(autenticado);		
					telaTec.setVisible(true);
					break;
				} else if (funcionario.getPerfil().equals("Usuário")) {
					autenticado = new Usuario();
					autenticado.setNome(funcionario.getNome());
					autenticado.setMatricula(funcionario.getMatricula());
					telaUsuario = new TelaInicialUsuario(autenticado);					
					telaUsuario.setVisible(true);
					break;
				}				
			}			
		}
	} catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Caracteres inválidos!");
	}
		if (autentica == false) {
			telaLogin.dispose();
			JOptionPane.showMessageDialog(null, "Matrícula/Senha errada");		
			new TelaLogin().setVisible(true);			
		}
	}
}
