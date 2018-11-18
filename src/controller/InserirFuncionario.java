package controller;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Tecnico;
import model.Usuario;
import model.dao.TecnicoDao;
import view.TelaCadUsuario;

public class InserirFuncionario {

	public InserirFuncionario(TelaCadUsuario cadDialog) {
//		String senha1;
//		String senha2;
		int tipoFuncionario;
		TelaCadUsuario telaNova = cadDialog;
		Funcionario funcionario = null;

		tipoFuncionario = cadDialog.cbPerfil.getSelectedIndex();

		if (tipoFuncionario == 1) {
			funcionario = new Tecnico();
		} else if (tipoFuncionario == 2) {
			funcionario = new Usuario();
		}

		funcionario.setSenha(String.valueOf(cadDialog.tfSenha.getPassword()));
		funcionario.setCpf(cadDialog.tfCpf.getText());
		funcionario.setNome(cadDialog.tfNome.getText());
		funcionario.setEmail(cadDialog.tfEmail.getText());
		funcionario.setCargo(cadDialog.tfCargo.getText());
		funcionario.setDepartamento((String) cadDialog.cbDepartamento.getSelectedItem());
		funcionario.setPerfil((String) cadDialog.cbPerfil.getSelectedItem());
		funcionario.setMatricula(Long.parseLong(cadDialog.tfMatricula.getText()));
		
		
		TecnicoDao dao = new TecnicoDao();

//		senha1 = String.valueOf(cadDialog.tfSenha.getPassword());
//		senha2 = String.valueOf(cadDialog.tfSenha2.getPassword());
//		if (senha1.equals(senha2) && !senha1.equals("")) {
			dao.insereFuncio(funcionario);
			cadDialog.tfCpf.setText("");
			cadDialog.tfNome.setText("");
			cadDialog.tfEmail.setText("");
			cadDialog.tfCargo.setText("");
			cadDialog.cbDepartamento.setSelectedItem("Selecione");
			cadDialog.cbPerfil.setSelectedItem("Selecione");
			cadDialog.tfMatricula.setText("");
			cadDialog.tfSenha.setText("");
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
//		} else {
//			cadDialog.tfSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
//			cadDialog.tfSenha2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
//			JOptionPane.showMessageDialog(null, "Senhas não conferem.");
//		}
	}
}
