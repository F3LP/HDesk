package Testes;

import java.util.List;

import model.Chamado;
import model.dao.ChamadoDao;

public class GetListaChamado {

	public static void main(String[] args) {
		
				ChamadoDao dao = new ChamadoDao();
				
				List<Chamado> chamados = dao.getListaChamado();
				
				for (Chamado chamado : chamados) {
					System.out.println("Protocolo: " + chamado.getProtocolo());
					System.out.println("Tipo: " + chamado.getTipo());
					System.out.println("Departamento: " + chamado.getDepartamento());
					System.out.println("Urgencia: " + chamado.getUrgencia());
					System.out.println("Titulo: " + chamado.getTitulo());
					System.out.println("Descrição: " + chamado.getDescricao());
					System.out.println(("Status: " + chamado.getStatus()));
					System.out.println("Data de Abertura: " + 
							chamado.getDtAbertura().getTime() + "\n");
				}
			
		

	}

}
