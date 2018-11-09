package controller;

import javax.swing.JOptionPane;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;
import view.TelaCadChamado;

public class InserirChamado {

	public InserirChamado(TelaCadChamado cadDialog) {
		
		Chamado chamado = new Chamado();
		chamado.setTipo((String)cadDialog.cbTipo.getSelectedItem());
		chamado.setDepartamento((String)cadDialog.cbDepartamento.getSelectedItem());
		chamado.setUrgencia((String)cadDialog.cbUrgencia.getSelectedItem());
		chamado.setTitulo(cadDialog.tfTitulo.getText());
		chamado.setDescricao(cadDialog.tfDescricao.getText());
		//chamado.setFuncionario(this.valueOf(this));
		
		
		ChamadoDao dao = new ChamadoDao();
		dao.insereChamado(chamado);
		JOptionPane.showMessageDialog(null, "Seu chamado foi registrado!");
	}
	
}
