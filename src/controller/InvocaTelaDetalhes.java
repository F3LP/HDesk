/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Chamado;
import model.dao.ChamadoDao;
import view.TelaDetalhes;
import view.TelaValidaChamado;

/**
 *
 * @author Felipe
 */
public class InvocaTelaDetalhes {
	public InvocaTelaDetalhes(Frame frame, JTable tabela) {
		TelaDetalhes tela;
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
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Selecione um chamado.");
			erro = false;
		}

		if (erro != false) {
			Chamado chamado = new Chamado();
			ChamadoDao dao = new ChamadoDao();
			chamado = dao.getChamadoProt(prot);

			tela = new TelaDetalhes(frame, true);
			tela.tfProtocolo.setText(String.valueOf(chamado.getProtocolo()));
			tela.tfMatricula.setText(String.valueOf(chamado.getUsuario().getMatricula()));
			tela.tfTitulo.setText(chamado.getTitulo());
			tela.tfDescricao.setText(chamado.getDescricao());
			
			try {
				tela.tfDtAbertura.setText(df.format(chamado.getDtAbertura().getTime()));
				tela.tfDtAtendimento.setText(df.format(chamado.getDtAtendimento().getTime()));
				tela.tfDtConclusao.setText(df.format(chamado.getDtConclusao().getTime()));

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

			tela.cbTipo.setSelectedIndex(indiceTipo);

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
			} else if (chamado.getDepartamento().equals("Vendas")) {
				indiceDep = 6;
			}

			tela.cbDepartamento.setSelectedIndex(indiceDep);

			if (chamado.getUrgencia().equals("Baixa")) {
				indiceUrgencia = 1;
			} else if (chamado.getUrgencia().equals("Média")) {
				indiceUrgencia = 2;
			} else if (chamado.getUrgencia().equals("Alta")) {
				indiceUrgencia = 3;
			}

			tela.cbUrgencia.setSelectedIndex(indiceUrgencia);

			tela.setVisible(true);
		}
	}

}
