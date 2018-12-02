package Testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Chamado;
import model.dao.ChamadoDao;

public class TestaGetPro {

	public static void main(String[] args) {
		ChamadoDao dao = new ChamadoDao();
		DateFormat df = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");	
		long prot = 29;
		Chamado chamado = dao.getChamadoProt(prot);
		
			System.out.println("Protocolo: " + chamado.getProtocolo());
			System.out.println("Tipo: " + chamado.getTipo());
			System.out.println("Departamento: " + chamado.getDepartamento());
			System.out.println("Urgencia: " + chamado.getUrgencia());
			System.out.println("Titulo: " + chamado.getTitulo());
			System.out.println("Descrição: " + chamado.getDescricao());
			System.out.println(("Status: " + chamado.getStatus()));
			try {
			System.out.println("Data de Abertura: " + 
					df.format(chamado.getDtAbertura().getTime()) + "\n");
			System.out.println("Data de Atendimento: " + 
					df.format(chamado.getDtAtendimento().getTime()) + "\n");
			System.out.println("Data de Conclusao: " + 
					df.format(chamado.getDtConclusao().getTime()) + "\n");
			} catch(RuntimeException e) {
				
			}
		
		

	}

}
