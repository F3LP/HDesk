package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;
import view.TelaCadChamado;

public class InserirChamado {

	public  InserirChamado(TelaCadChamado cadDialog, Funcionario funcionario) {
				
		Chamado chamado = new Chamado();
		chamado.setTipo((String)cadDialog.cbTipo.getSelectedItem());
		chamado.setDepartamento((String)cadDialog.cbDepartamento.getSelectedItem());
		chamado.setUrgencia((String)cadDialog.cbUrgencia.getSelectedItem());
		chamado.setTitulo(cadDialog.tfTitulo.getText());
		chamado.setDescricao(cadDialog.tfDescricao.getText());
		chamado.setFuncionario(funcionario);
		chamado.setDtAbertura(Calendar.getInstance());
			
		ChamadoDao dao = new ChamadoDao();
		dao.insereChamado(chamado);
		
		cadDialog.cbTipo.setSelectedIndex(0);
		cadDialog.cbDepartamento.setSelectedIndex(0);
		cadDialog.cbUrgencia.setSelectedIndex(0);
		cadDialog.tfTitulo.setText("");
		cadDialog.tfDescricao.setText("");
				
		JOptionPane.showMessageDialog(null, "Seu chamado foi registrado!");
	}
	
}
