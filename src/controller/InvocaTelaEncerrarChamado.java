package controller;

import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;
import view.TelaDetalhes;
import view.TelaEncerrarChamado;

public class InvocaTelaEncerrarChamado {
	public InvocaTelaEncerrarChamado(Frame frame, JTable tabela, Funcionario autenticado) {
		TelaEncerrarChamado telaEncerrar;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

		JTable table = new JTable();
		table = tabela;
		long prot = 0;
		boolean erro = true;
		int indiceDep = 0;
		int indiceUrgencia = 0;
		int indiceTipo = 0;

		int linha;

		try {
			linha = tabela.getSelectedRow();
			prot = (long) tabela.getModel().getValueAt(linha, 1);
			frame.dispose();
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Selecione um chamado.");
			erro = false;
		}

		if (erro != false) {
			Chamado chamado = new Chamado();
			ChamadoDao dao = new ChamadoDao();
			chamado = dao.getChamadoProt(prot);
			chamado.setDtConclusao(Calendar.getInstance());
			

			telaEncerrar = new TelaEncerrarChamado(frame, true, chamado, autenticado);
			telaEncerrar.tfProtocolo.setText(String.valueOf(chamado.getProtocolo()));
			telaEncerrar.tfMatricula.setText(String.valueOf(chamado.getUsuario().getMatricula()));
			telaEncerrar.tfTitulo.setText(chamado.getTitulo());
			telaEncerrar.tfDescricao.setText(chamado.getDescricao());
			chamado.setConclusao(telaEncerrar.tfConclusao.getText());
			try {
				telaEncerrar.tfDtAbertura.setText(df.format(chamado.getDtAbertura().getTime()));
				telaEncerrar.tfDtAtendimento.setText(df.format(chamado.getDtAtendimento().getTime()));

			} catch (RuntimeException e) {
//				tela.tfDtAbertura.setText("");
//				tela.tfDtAtendimento.setText("");
//				tela.tfDtConclusao.setText("");
			}
			
			if (chamado.getTipo().equals("Dúvida")) {
				indiceTipo = 1;
			} else if (chamado.getTipo().equals("Requisição")) {
				indiceTipo = 2;
			}

			telaEncerrar.cbTipo.setSelectedIndex(indiceTipo);

			if (chamado.getDepartamento().equals("Administração")) {
				indiceDep = 1;
			} else if (chamado.getDepartamento().equals("Diretoria")) {
				indiceDep = 2;
			} else if (chamado.getDepartamento().equals("Financeiro")) {
				indiceDep = 3;
			} else if (chamado.getDepartamento().equals("Marketing")) {
				indiceDep = 4;
			} else if (chamado.getDepartamento().equals("RH")) {
				indiceDep = 5;
			} else if (chamado.getDepartamento().equals("TI")) {
				indiceDep = 6;
			}else if (chamado.getDepartamento().equals("Vendas")) {
				indiceDep = 7;
			}

			telaEncerrar.cbDepartamento.setSelectedIndex(indiceDep);

			if (chamado.getUrgencia().equals("Baixa")) {
				indiceUrgencia = 1;
			} else if (chamado.getUrgencia().equals("Média")) {
				indiceUrgencia = 2;
			} else if (chamado.getUrgencia().equals("Alta")) {
				indiceUrgencia = 3;
			}
			telaEncerrar.cbUrgencia.setSelectedIndex(indiceUrgencia);
			telaEncerrar.setVisible(true);	
			}
		
	}

}
