package Testes;

import javax.swing.JOptionPane;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;
import model.dao.FuncionarioDao;

public class TestaInsereChamado {
	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula(123789);
		
		Chamado chamado = new Chamado();
		chamado.setFuncionario(funcionario);
		chamado.setTipo("Dúvida");
		chamado.setDepartamento("Diretoria");
		chamado.setUrgencia("baixa");
		chamado.setTitulo("Cadastrar usuário");
		chamado.setDescricao("O funcionário da matrícula 123456 precisa de acesso ao sistema help desk");
		
		ChamadoDao dao = new ChamadoDao();
		dao.insereChamado(chamado);
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
		;
	}

}
