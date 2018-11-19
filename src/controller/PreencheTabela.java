package controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Chamado;
import model.Funcionario;
import model.dao.ChamadoDao;

public class PreencheTabela {

	public PreencheTabela(JTable tabela, Funcionario autenticado){	
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
}
