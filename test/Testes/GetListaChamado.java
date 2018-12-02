package Testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Chamado;
import model.Funcionario;
import model.Usuario;
import model.dao.ChamadoDao;

public class GetListaChamado {

	public static void main(String[] args) {
		
				ChamadoDao dao = new ChamadoDao();
				DateFormat df = new SimpleDateFormat("yy/MM/dd - HH:mm:ss");	
				Funcionario fun = new Usuario();
				fun.setMatricula(7);
				List<Chamado> chamados = dao.getListaChamadoHistorico(fun);
				
				for (Chamado chamado : chamados) {
					System.out.println("Protocolo: " + chamado.getProtocolo());
					System.out.println("Tipo: " + chamado.getTipo());
					System.out.println("Departamento: " + chamado.getDepartamento());
					System.out.println("Urgencia: " + chamado.getUrgencia());
					System.out.println("Titulo: " + chamado.getTitulo());
					System.out.println("Descrição: " + chamado.getDescricao());
					System.out.println(("Status: " + chamado.getStatus()));
					System.out.println("Data de Abertura: " + 
							df.format(chamado.getDtAbertura().getTime()) + "\n");
			
				}
				
				
	}

}
