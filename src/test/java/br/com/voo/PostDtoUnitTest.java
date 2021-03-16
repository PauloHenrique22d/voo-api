package br.com.voo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import br.com.voo.entidades.Voo;
import br.com.voo.vo.VooVO;

/**
 * Testa a conversao de entidades em vo's
 * @author phsou
 *
 */
public class PostDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConverteVooEntidadeParaVooVo_thenCorrect() {
        Voo voo = new Voo();
        voo.setIdVoo(1L);
        voo.setNomeAeroportoDestino("Galeão");
        voo.setNomeAeroportoOrigem("Pinto Martins");

        VooVO vooVo = modelMapper.map(voo, VooVO.class);
        assertEquals(voo.getIdVoo(), vooVo.getIdVoo());
        assertEquals(voo.getNomeAeroportoDestino(), vooVo.getNomeAeroportoDestino());
        assertEquals(voo.getNomeAeroportoOrigem(), vooVo.getNomeAeroportoOrigem());
    }
}