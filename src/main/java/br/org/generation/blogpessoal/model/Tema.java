package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
	
	@Entity
	@Table(name = "tb_tema")
	public class Tema {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_tema;
		
		@NotNull (message = "O atributo descrição é obrigatório!")
		@Size(min = 10, max = 255, message = "O atributo descrição deve conter no minímo 10 e no máximo 255 caracteres")
		private String descricao;
		
		@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("tema")
		private List<Postagem> postagem;

		public long getId_tema() {
			return id_tema;
		}

		public void setId_tema(long id_tema) {
			this.id_tema = id_tema;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		} 	
		
	}
	
