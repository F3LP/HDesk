package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;

public class PreencheTabela {
	
	public PreencheTabela() {
		
	}
	// Preenche Tabela da Tela Inicial do Usuário
	public void preencheTabelaUsuario(JTable tabela, Funcionario autenticado) {	
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();		
            ChamadoDao dao = new ChamadoDao();
            List<Chamado> chamados = dao.getListaChamado(autenticado);
		Object rowData[] = new Object[6];
 			
		for (int i = 0; i < chamados.size(); i++) {
			rowData[0] = chamados.get(i).getStatus();
			rowData[1] = chamados.get(i).getProtocolo();
			rowData[2] = chamados.get(i).getTipo();
			rowData[3] = chamados.get(i).getTitulo();
			rowData[4] = chamados.get(i).getUrgencia();
			rowData[5] = chamados.get(i).getDtAbertura().getTime();
			model.addRow(rowData);
		}
	}
	
	// Preenche Tabela da Tela Histórico do Usuário
	public void preencheTabelaHistoricoUsuario(JTable tabela, Funcionario autenticado) {	
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();		
		ChamadoDao dao = new ChamadoDao();
		
		List<Chamado> chamados = dao.getListaChamadoHistorico(autenticado);
		Object rowData[] = new Object[10];
 			
		for (int i = 0; i < chamados.size(); i++) {
			rowData[0] = chamados.get(i).getStatus();
			rowData[1] = chamados.get(i).getProtocolo();
			rowData[2] = autenticado.getMatricula();
			rowData[3] = chamados.get(i).getDepartamento();
			rowData[4] = chamados.get(i).getUrgencia();
			rowData[5] = chamados.get(i).getTitulo();
			
			//MUDAR ESSA LINHA, CONFIG APENAS PARA TESTE
			rowData[6] = autenticado.getMatricula(); 
			
			
			rowData[7] = chamados.get(i).getDtAbertura().getTime();
			rowData[8] = chamados.get(i).getDtAtendimento().getTime();
			rowData[9] = chamados.get(i).getDtConclusao().getTime();
			model.addRow(rowData);
		}
	}
	// Preenche Tabela da Tela Inicial do Técnico
		public void preencheTabelaTecnico(JTable tabela, Funcionario autenticado) {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();		
		ChamadoDao dao = new ChamadoDao();
		List<Chamado> chamados = dao.getListaChamadoTelaTec(autenticado);
		Object rowData[] = new Object[9];
 			
		for (int i = 0; i < chamados.size(); i++) {
			rowData[0] = chamados.get(i).getStatus();
			rowData[1] = chamados.get(i).getProtocolo();
			rowData[2] = chamados.get(i).getDtAbertura().getTime();
			rowData[3] = chamados.get(i).getUrgencia();		
			rowData[4] = chamados.get(i).getTipo();
			rowData[5] = chamados.get(i).getUsuario().getMatricula();
			rowData[6] = chamados.get(i).getDepartamento();
			rowData[7] = chamados.get(i).getTitulo();
			rowData[8] = chamados.get(i).getTecnico().getMatricula();
	
			model.addRow(rowData);
		}
	}
	
	//Preenche Tabela da Tela Histórico do Técnico
	public void preencheTabelaHistoricoTec(JTable tabela, Funcionario autenticado) {	
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();		
		ChamadoDao dao = new ChamadoDao();
		List<Chamado> chamados = dao.getListaChamadoHistoricoCompleta(autenticado);
		Object rowData[] = new Object[10];
 			
		for (int i = 0; i < chamados.size(); i++) {
			
			rowData[0] = chamados.get(i).getStatus();
			rowData[1] = chamados.get(i).getProtocolo();
			rowData[2] = chamados.get(i).getUsuario().getMatricula();
			rowData[3] = autenticado.getDepartamento();
			rowData[4] = chamados.get(i).getUrgencia();	
			rowData[5] = chamados.get(i).getTitulo();
			rowData[6] = chamados.get(i).getTecnico();
			rowData[7] = chamados.get(i).getDtAbertura().getTime();
			rowData[8] = chamados.get(i).getDtAtendimento().getTime();
			rowData[9] = chamados.get(i).getDtConclusao().getTime();
			
			model.addRow(rowData);
			
			
			
		}
	}
}
