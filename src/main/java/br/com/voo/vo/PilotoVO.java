package br.com.voo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PilotoVO implements Serializable{

	
	private static final long serialVersionUID = 4254366969127651078L;
	
	private Long idPiloto;
	private String nome;
	private String cpf;
	private boolean estaEmVoo;

}
