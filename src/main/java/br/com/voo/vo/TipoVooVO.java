package br.com.voo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class TipoVooVO implements Serializable{
	
	private static final long serialVersionUID = -50968767090378381L;

	private Long idTipoVoo;
	private String siglaTipoVoo;
	private String descricaoTipoVoo;

}
