package br.com.voo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	private LocalDateTime horarioPartida;
	
	@NonNull
	@Column(name = "hora_chegada")
	private LocalDateTime horarioChegada;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAviao")
	private Aviao aviao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPiloto")
	private Piloto piloto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoVoo")
	private TipoVoo tipoVoo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idStatusVoo")
	private StatusVoo statusVoo;
	
	@OneToMany(mappedBy = "voo", fetch = FetchType.EAGER)
	private List<VooAeroporto> aeroportosOrigemDestino;
	
}
