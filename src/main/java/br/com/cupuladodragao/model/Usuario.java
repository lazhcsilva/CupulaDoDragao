package br.com.cupuladodragao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	private String nome;
	
	private String sobreNome;
	
	private String email;
	
	private String senha;
	
	private String senha2;
	
	private Date dataNascimento;
	
	private int controle = 0;
	
	private String fotoUsuario;
	
	public Usuario() {}

	public Usuario(Integer idUsuario, String nome, String sobreNome, String email, String senha, String senha2,
			Date dataNascimento, int controle, String fotoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.senha = senha;
		this.senha2 = senha2;
		this.dataNascimento = dataNascimento;
		this.controle = controle;
		this.fotoUsuario = fotoUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getControle() {
		return controle;
	}

	public void setControle(int controle) {
		this.controle = controle;
	}
	
	public String getFotoUsuario() {
		return fotoUsuario;
	}
	
	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email
				+ ", senha=" + senha + ", senha2=" + senha2 + ", dataNascimento=" + dataNascimento + "]";
	}
	
}
