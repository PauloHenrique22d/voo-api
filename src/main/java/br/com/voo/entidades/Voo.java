package br.com.voo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "voo")
@NoArgsConstructor @AllArgsConstructor 
public class Voo implements Serializable{
	
	private static final long serialVersionUID = 983179453552144185L;

	@Id
	@NotNull
	@Column(name = "id_voo")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long idVoo;
	
	@NonNull
	@Column(name = "desc_voo")
	private String descricaoVoo;
	
	@NonNull
	@Column(name = "nome_aeroporto_origem")
	private String nomeAeroportoOrigem;
	
	@NonNull
	@Column(name = "nome_aeroporto_destino")
	private String nomeAeroportoDestino;
	
	@NonNull
	@Column(name = "hora_partida")
	private Date horarioPartida;
	
	@NonNull
	@Column(name = "hora_chegada")
	private Date horarioChegada;
	
	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAviao", nullable=false, insertable=false, updatable=false)
	private Aviao aviao;
	
	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPiloto", nullable=false, insertable=false, updatable=false)
	private Piloto piloto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoVoo", nullable=false, insertable=false, updatable=false)
	private TipoVoo tipoVoo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idStatusVoo", nullable=false, insertable=false, updatable=false)
	private StatusVoo statusVoo;
	
	@JsonBackReference
	@OneToMany(mappedBy = "voo")
	private List<VooAeroporto> aeroportosOrigemDestino;
	
}
