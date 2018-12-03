package controller;

import view.TelaEncerrarChamado;

public class LimparTelaEncerrar {
	public LimparTelaEncerrar(TelaEncerrarChamado telaEncChamad) {
		telaEncChamad.tfMatricula.setText(null);
		telaEncChamad.tfProtocolo.setText(null);
		telaEncChamad.cbDepartamento.setSelectedIndex(0);
		telaEncChamad.cbTipo.setSelectedIndex(0);
		telaEncChamad.cbUrgencia.setSelectedIndex(0);
		telaEncChamad.tfDtAbertura.setText(null);
		telaEncChamad.tfDtAtendimento.setText(null);
		telaEncChamad.tfDtConclusao.setText(null);
		telaEncChamad.tfTitulo.setText(null);
		telaEncChamad.tfDescricao.setText(null);
		telaEncChamad.tfConclusao.setText(null);
	}
}
