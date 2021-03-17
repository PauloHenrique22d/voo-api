package br.com.voo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "TipoVoo")
@NoArgsConstructor @AllArgsConstructor 
public class TipoVoo implements Serializable{
	
	private static final long serialVersionUID = -3018210579058592180L;
	
	@Id
	@NotNull
	@Column(name = "id_tipo_voo")
	private Long idTipoVoo;
	
	@NotNull
	@Column( name = "sigl_tipo_voo")
	private String siglaTipoVoo;
	
	@NotNull
	@Column( name = "desc_tipo_voo")
	private String descricaoTipoVoo;

}
