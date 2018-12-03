package controller;

import javax.swing.JFrame;

import view.TelaExcluirUsuario;

public class InvocaTelaExcluirUsuario {

	public InvocaTelaExcluirUsuario(JFrame frame) {
		
		TelaExcluirUsuario tela = new TelaExcluirUsuario(frame, true);	
		tela.setVisible(true);
	}
}
// excluir essa tela