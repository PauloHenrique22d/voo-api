package br.com.voo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class StatusVooVO implements Serializable{
	
	private static final long serialVersionUID = 329007763012428202L;
	
	private Long idStatusVoo;
	private String descricaoStatus;

}
