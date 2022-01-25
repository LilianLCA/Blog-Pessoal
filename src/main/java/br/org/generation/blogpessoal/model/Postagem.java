package br.org.generation.blogpessoal.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotNull (message = "O atributo titulo é obrigatório")
	@Size (min = 01, max = 50, message = "O atributo titulo deve conter no minimo 01 e máximo 100 caracteres")
	private String titulo; 
	
	@NotNull (message = "O atributo texto é obrigatório")
	@Size (min = 01, max = 1000, message = "O atributo texto deve conter no minimo 01 e máximo 1000 caracteres")
	private String texto; 
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
