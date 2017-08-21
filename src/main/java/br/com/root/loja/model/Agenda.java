package br.com.root.loja.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="agenda")
public class Agenda {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(insertable=false)
    private Date periodoini;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(insertable=false)
    private Date periodofim;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Servico agendaServico = new Servico();

}
