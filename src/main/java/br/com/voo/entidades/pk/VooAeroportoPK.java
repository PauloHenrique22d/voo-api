package br.com.voo.entidades.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class VooAeroportoPK implements Serializable {

	private static final long serialVersionUID = -2637632079235794505L;

	@Column(name = "id_voo")
    Long vooId;

    @Column(name = "id_aeroporto")
    Long aeroportoId;

}