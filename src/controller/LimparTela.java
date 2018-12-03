package controller;

import view.TelaExcluirUsuario;

public class LimparTela {
	public LimparTela(TelaExcluirUsuario tela) {
		tela.tfMatricula.setText(null);
		tela.tfNome.setText(null);
		tela.tfEmail.setText(null);
		tela.tfCargo.setText(null);
		tela.cbDepartamento.setSelectedIndex(0);
		tela.cbPerfil.setSelectedIndex(0);
	}
}
