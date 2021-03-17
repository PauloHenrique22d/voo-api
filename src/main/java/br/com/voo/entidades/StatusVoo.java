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
@Table (name = "status_voo")
@NoArgsConstructor @AllArgsConstructor 
public class StatusVoo implements Serializable{
	
	
	private static final long serialVersionUID = 3841440388158849823L;

	@Id
	@NotNull
	@Column(name = "id_status_voo")
	private Long idStatusVoo;
	
	@Column(name = "stat_voo")
	private String descricaoStatus;

}
