package br.com.root.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servico")
public class Servico {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private Boolean sobencomenda;
	
	@Column(nullable=false,length=100)
	private String descricao;
	
	@Column(nullable=true)
	private BigDecimal valor;
}
	