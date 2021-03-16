package br.com.voo.vo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import br.com.voo.entidades.Cidade;
import br.com.voo.entidades.VooAeroporto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor 
public class AeroportoVO implements Serializable{
	
	
	private static final long serialVersionUID = -8794688723164516412L;
	
	private Long idAeroporto;
	private String nomeAeroporto;
	private String siglaAeroporto;
	private Double latitude;
	private Double longetude;
	private Cidade cidade;
    private Set<VooAeroporto> voosOrigemDestino;
}
