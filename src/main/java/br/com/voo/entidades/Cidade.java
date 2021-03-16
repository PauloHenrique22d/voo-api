package br.com.voo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "cidade")
@NoArgsConstructor @AllArgsConstructor 
public class Cidade implements Serializable{

	private static final long serialVersionUID = 5584232236778932243L;

	@Id
	@NotNull
	@Column(name = "id_cidade")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long idCidade;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "estado")
	private String estado;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
	private List<Aeroporto> aeroportos;
	 
	
	
}
