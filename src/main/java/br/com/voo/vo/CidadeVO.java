package br.com.voo.vo;

import java.io.Serializable;
import java.util.List;

import br.com.voo.entidades.Aeroporto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CidadeVO implements Serializable{


	private static final long serialVersionUID = -1843005399449367082L;
	
	private Long idCidade;
	private String nome;
	private String estado;
	private List<Aeroporto> aeroportos;
	 
	
	
}
