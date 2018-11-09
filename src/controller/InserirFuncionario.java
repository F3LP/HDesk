package controller;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.dao.FuncionarioDao;
import view.TelaCadUsuario;

public class InserirFuncionario {

    public InserirFuncionario(TelaCadUsuario cadDialog){
         
        Funcionario funcionario = new Funcionario();
        funcionario.setSenha(Long.parseLong(cadDialog.tfSenha.getText()));
        funcionario.setCpf(cadDialog.tfCpf.getText());
        funcionario.setNome(cadDialog.tfNome.getText());
        funcionario.setEmail(cadDialog.tfEmail.getText());
        funcionario.setCargo(cadDialog.tfCargo.getText());
        funcionario.setDepartamento((String)cadDialog.cbDepartamento.getSelectedItem());
        funcionario.setPerfil((String)cadDialog.cbPerfil.getSelectedItem());
        funcionario.setMatricula(Long.parseLong(cadDialog.tfMatricula.getText()));
        
        FuncionarioDao dao = new FuncionarioDao();
        dao.insereFuncio(funcionario);
        JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
           
        cadDialog.tfSenha.setText("");
        cadDialog.tfCpf.setText("");
        cadDialog.tfNome.setText("");
        cadDialog.tfEmail.setText("");
        cadDialog.tfCargo.setText("");
        cadDialog.cbDepartamento.setSelectedItem("Selecione");
        cadDialog.cbPerfil.setSelectedItem("Selecione");
        cadDialog.tfMatricula.setText("");
    }
}
