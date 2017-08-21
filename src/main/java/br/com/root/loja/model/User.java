package br.com.root.loja.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true, nullable=false,length=11)
	private String cpf;
	
	@Column(nullable=false,length=100)
	private String nome;
		
	@Column(nullable=false,length=1)
	private String sexo;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtnasc;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false,updatable = false)
    private Date dtcriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(insertable=false)
    private Date dtalteracao;

	@Column(nullable=false,length=10)
	private String telefone;
	
	@Column(nullable=true,length=11)
	private String celular;
	
	@Column(nullable=false)
	private String endereco;
	
	@Column(nullable=false,length=100)
	private String estado;
	
	@Column(nullable=false,length=100)
	private String cidade;
	
	@Column(nullable=false,length=100)
	private String bairro;
	
	@Column(nullable=false,length=8)
	private String cep;
	
	@Column(nullable=false,length=100)
	private String complemento;
	
	@Column(unique=true,nullable=false,length=100)
	private String email;
	
	@Column(nullable=false)
	private String senha;

	@Column(nullable=false)
	private int ativo = State.ATIVO.getState();

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinTable(name = "usuario_usuario_profile", 
             joinColumns = { @JoinColumn(name = "usuario_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "usuario_profile_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Date getDtcriacao() {
		return dtcriacao;
	}

	public void setDtcriacao(Date dtcriacao) {
		this.dtcriacao = dtcriacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtalteracao() {
		return dtalteracao;
	}

	public void setDtalteracao(Date dtalteracao) {
		this.dtalteracao = dtalteracao;
	}
}
