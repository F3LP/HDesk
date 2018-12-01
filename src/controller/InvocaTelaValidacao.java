/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Chamado;
import model.Funcionario;
import model.Tecnico;
import model.dao.ChamadoDao;
import view.TelaInicialTecnico;
import view.TelaValidaChamado;

/**
 *
 * @author Felipe
 */
public class InvocaTelaValidacao {

	public InvocaTelaValidacao(JTable tabela, TelaInicialTecnico telaTec, Funcionario autenticado) {
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
		
			TelaValidaChamado tela = new TelaValidaChamado(telaTec, true, autenticado);
            tela.setProtoc(prot);
			tela.tfMatricula.setText(String.valueOf(chamado.getUsuario().getMatricula()));
			tela.tfTitulo.setText(chamado.getTitulo());
			tela.tfDescricao.setText(chamado.getDescricao());
			
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
