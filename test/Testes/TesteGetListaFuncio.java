package Testes;

import java.util.List;

import model.Funcionario;
import model.dao.FuncionarioDao;

public class TesteGetListaFuncio {
	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();

		List<Funcionario> funcionarios = dao.getListaFuncio();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Matricula: " + funcionario.getMatricula());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());			
			System.out.println("Email: " + funcionario.getEmail());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Departamento: " + funcionario.getDepartamento());
			System.out.println("Perfil: " + funcionario.getPerfil() + "\n");
		}
	}
}
