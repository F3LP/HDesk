package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Funcionario;
import model.Usuario;
import model.dao.FuncionarioDao;
import view.TelaExcluirUsuario;

public class BuscarFuncionario {

	public BuscarFuncionario(TelaExcluirUsuario tela, long mat) {
		Funcionario funcio = new Usuario();
		FuncionarioDao dao = new FuncionarioDao();

		int indiceDep = 0;
		int indicePerfil = 0;

		try {
			List<Funcionario> funcionarios = dao.getListaFuncio();
			for (Funcionario funcionario : funcionarios) {
				if (funcionario.getMatricula() == mat) {
					funcio.setMatricula(funcionario.getMatricula());
					funcio.setCargo(funcionario.getCargo());
					funcio.setCpf(funcionario.getCargo());
					funcio.setDepartamento(funcionario.getDepartamento());
					funcio.setPerfil(funcionario.getPerfil());
					funcio.setNome(funcionario.getNome());
					funcio.setEmail(funcionario.getEmail());
				}
				tela.tfMatricula.setText(String.valueOf(funcio.getMatricula()));
				tela.tfNome.setText(funcio.getNome());
				tela.tfEmail.setText(funcio.getEmail());
				tela.tfCargo.setText(funcio.getCargo());

				if (funcionario.getDepartamento().equals("Administração")) {
					indiceDep = 1;
				} else if (funcionario.getDepartamento().equals("Diretoria")) {
					indiceDep = 2;
				} else if (funcionario.getDepartamento().equals("Financeiro")) {
					indiceDep = 3;
				} else if (funcionario.getDepartamento().equals("Marketing")) {
					indiceDep = 4;
				} else if (funcionario.getDepartamento().equals("RH")) {
					indiceDep = 5;
				} else if (funcionario.getDepartamento().equals("TI")) {
					indiceDep = 6;
				} else if (funcionario.getDepartamento().equals("Vendas")) {
					indiceDep = 7;
				}

				tela.cbDepartamento.setSelectedIndex(indiceDep);

				if (funcionario.getPerfil().equals("Técnico")) {
					indicePerfil = 1;
				} else if (funcionario.getPerfil().equals("Usuário")) {
					indicePerfil = 2;
				}

				tela.cbPerfil.setSelectedIndex(indicePerfil);
			}
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Registro não encontrado.");
		}
		if (funcio.getMatricula() == 0) {
			tela.tfMatricula.setText("");
			JOptionPane.showMessageDialog(null, "Registro não encontrado.");
		}
	}
}
