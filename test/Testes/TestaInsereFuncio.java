package Testes;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Usuario;
import model.dao.TecnicoDao;


public class TestaInsereFuncio {
    public static void main(String[] args){
        Funcionario funcionario = new Usuario();
        funcionario.setMatricula(123789);
        funcionario.setSenha(String.valueOf(funcionario.setPassword("44444"));
        funcionario.setCpf("228.228.229-05");
        funcionario.setNome("Jooo");
        funcionario.setEmail("jao@gmail.com");
        funcionario.setCargo("Analista Financeiro");
        funcionario.setDepartamento("Financeiro");
        funcionario.setPerfil("Usuário");
        
        TecnicoDao dao = new TecnicoDao();
        dao.insereFuncio(funcionario);
        JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
        ;
    }
}
