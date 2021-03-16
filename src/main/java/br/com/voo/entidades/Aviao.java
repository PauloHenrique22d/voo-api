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
@Table (name = "aviao")
@NoArgsConstructor @AllArgsConstructor 
public class Aviao implements Serializable{

	
	private static final long serialVersionUID = 4915866105338351330L;
	
	@Id
	@NotNull
	@Column(name = "id_aviao")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long idAviao;

}
