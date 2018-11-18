/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.TelaCadChamado;

public abstract class Funcionario {
    private long matricula;
    private String senha;
    private String cpf;
    private String nome;
    private String email;
    private String cargo;
    private String departamento;
    private String perfil;
   
    public Funcionario() {	
    }
    
	public Funcionario(long matricula, String senha, String cpf, String nome, String email, String cargo,
			String departamento, String perfil) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.departamento = departamento;
		this.perfil = perfil;
	}
	public long getMatricula() {
        return matricula;
    }
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
