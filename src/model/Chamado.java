package model;

import java.util.Calendar;

public class Chamado {
    private Funcionario funcionario;
    private long protocolo;
    private String tipo;
    private String departamento;
    private String urgencia;
    private String titulo;
    private String descricao;
    private Calendar dtAbertuta;
    private Calendar dtAtendimento;
    private Calendar dtConclusao;
    
    
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public long getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDtAbertuta() {
		return dtAbertuta;
	}
	public void setDtAbertuta(Calendar dtAbertuta) {
		this.dtAbertuta = dtAbertuta;
	}
	public Calendar getDtAtendimento() {
		return dtAtendimento;
	}
	public void setDtAtendimento(Calendar dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	public Calendar getDtConclusao() {
		return dtConclusao;
	}
	public void setDtConclusao(Calendar dtConclusao) {
		this.dtConclusao = dtConclusao;
	}
    
    
    


    
}
