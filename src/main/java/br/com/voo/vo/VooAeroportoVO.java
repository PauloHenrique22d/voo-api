package br.com.voo.vo;

import java.io.Serializable;

import br.com.voo.entidades.Aeroporto;
import br.com.voo.entidades.Voo;
import br.com.voo.entidades.pk.VooAeroportoPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class VooAeroportoVO implements Serializable {

	private static final long serialVersionUID = 1975494509031857048L;

	private VooAeroportoPK id;
	private Voo voo;
    private Aeroporto aeroporto;
    private String sentido;
}
