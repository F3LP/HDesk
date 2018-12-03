package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Chamado {
    private Funcionario usuario;
    private Funcionario tecnico;
    private long protocolo;
    private String tipo;
    private String departamento;
    private String urgencia;
    private String titulo;
    private String descricao;
    private String conclusao;
    private String status = "Pendente";
	private Calendar dtAbertura;
    private Calendar dtAtendimento;
    private Calendar dtConclusao;
    
    
	public Funcionario getUsuario() {
		return usuario;
	}
	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
	}
	public Funcionario getTecnico() {
		return tecnico;
	}
	public void setTecnico(Funcionario tecnico) {
		this.tecnico = tecnico;
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
	public Calendar getDtAbertura() {
		return dtAbertura;
	}
	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
    
	
}
