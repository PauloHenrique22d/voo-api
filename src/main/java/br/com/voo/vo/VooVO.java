package br.com.voo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import antlr.collections.List;
import br.com.voo.entidades.Aviao;
import br.com.voo.entidades.Piloto;
import br.com.voo.entidades.StatusVoo;
import br.com.voo.entidades.TipoVoo;
import br.com.voo.entidades.VooAeroporto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class VooVO implements Serializable{
	
	private static final long serialVersionUID = 9001780429241723227L;
	
	private Long idVoo;
	private String descricaoVoo;
	private String nomeAeroportoOrigem;
	private String nomeAeroportoDestino;
	private Date horarioPartida;
	private Date horarioChegada;
	private Aviao aviao;
	private Piloto piloto;
	private TipoVoo tipoVoo;
	private StatusVoo statusVoo;
	private ArrayList<VooAeroporto> aeroportosOrigemDestino;
	
}
