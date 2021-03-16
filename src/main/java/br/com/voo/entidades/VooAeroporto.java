package br.com.voo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import br.com.voo.entidades.pk.VooAeroportoPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "voo_aeroporto")
@NoArgsConstructor @AllArgsConstructor 
public class VooAeroporto implements Serializable {

	private static final long serialVersionUID = -7551061439747402594L;

	@EmbeddedId
	private VooAeroportoPK id;
	
	@ManyToOne
    @MapsId("vooId")
    @JoinColumn(name = "idVoo")
	@JsonBackReference
	private Voo voo;

    @ManyToOne
    @MapsId("aeroportoId")
    @JoinColumn(name = "idAeroporto")
    private Aeroporto aeroporto;
    
    @NotNull
	@Column(name = "sentido")
    private String sentido;
}
