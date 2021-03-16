package br.com.voo.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "aeroporto")
@NoArgsConstructor @AllArgsConstructor 
public class Aeroporto implements Serializable{

	
	private static final long serialVersionUID = 5156789396252350498L;
	
	@Id
	@NotNull
	@Column(name = "id_aeroporto")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long idAeroporto;
	
	@Column(name = "nome_aeroporto")
	private String nomeAeroporto;
	
	@Column(name = "sigl_aeroporto")
	private String siglaAeroporto;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longetude")
	private Double longetude;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCidade", nullable=false, insertable=false, updatable=false)
	private Cidade cidade;
	
	@JsonBackReference
	@OneToMany(mappedBy = "aeroporto")
    private List<VooAeroporto> voosOrigemDestino;
}
