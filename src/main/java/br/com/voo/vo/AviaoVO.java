package br.com.voo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AviaoVO implements Serializable{
	
	private static final long serialVersionUID = -5834279760236325638L;
	
	private Long idAviao;

}
