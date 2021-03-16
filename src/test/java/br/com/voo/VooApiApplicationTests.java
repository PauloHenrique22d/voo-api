package br.com.voo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.voo.controle.VooControle;
import br.com.voo.entidades.Aeroporto;
import br.com.voo.entidades.Aviao;
import br.com.voo.entidades.Piloto;
import br.com.voo.entidades.StatusVoo;
import br.com.voo.entidades.TipoVoo;
import br.com.voo.entidades.Voo;
import br.com.voo.entidades.VooAeroporto;
import br.com.voo.entidades.pk.VooAeroportoPK;
import br.com.voo.repositorio.VooRepositorio;
import br.com.voo.servico.VooServico;

@SpringBootTest
class VooApiApplicationTests {

	@Mock
	private VooControle controle;

	@Mock
	private VooRepositorio repositorio;

	@InjectMocks
	private VooServico servico;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controle).isNotNull();
	}

	@Test
	public void testSalvarComSucesso() {

		// Cria Mock do voo
		Voo voo = Mockito.mock(Voo.class);

		Mockito.when(servico.salvar(getVooCompleto())).thenReturn(voo);

	}

	@Test
	public void testListarTodos() {

		List<Voo> todos = new LinkedList<Voo>();
		todos.add(getVooCompleto());
		
		// MOCK ALERTA: retorna mock
		when(repositorio.findAll()).thenReturn(todos);

	}

	/*
	 * @Test public void testCamposObrigatoriosInvalidos() { Voo voo = new Voo();
	 * 
	 * Exception thrown = assertThrows( Exception.class, () -> controle.criar(voo,
	 * null), "Expected doThing() to throw, but it didn't" );
	 * 
	 * assertTrue(thrown.getMessage().contains("Stuff"));
	 * 
	 * 
	 * 
	 * }
	 */

	private Voo getVooCompleto() {

		Voo voo = new Voo();
		voo.setIdVoo(1L);
		voo.setDescricaoVoo("Voo 1");
		voo.setHorarioPartida(LocalDateTime.now());
		voo.setHorarioChegada(LocalDateTime.now());
		voo.setNomeAeroportoDestino("Galeao");
		voo.setNomeAeroportoOrigem("Pinto Martins");

		Aviao aviao = new Aviao();
		aviao.setIdAviao(1L);

		Piloto piloto = new Piloto();
		piloto.setIdPiloto(1L);
		piloto.setNome("Luccas Carlos");
		piloto.setEstaEmVoo(true);
		piloto.setCpf("09734512395");

		StatusVoo statusVoo = new StatusVoo();
		statusVoo.setIdStatusVoo(1L);
		statusVoo.setDescricaoStatus("Aguardando Decolagem");

		TipoVoo tipoVoo = new TipoVoo();
		tipoVoo.setIdTipoVoo(1L);
		tipoVoo.setSiglaTipoVoo("COM");

		// Many-To-Many
		ArrayList<VooAeroporto> vooAeroportos = new ArrayList<VooAeroporto>();
		VooAeroporto vooAeroporto = new VooAeroporto();

		VooAeroportoPK pk = new VooAeroportoPK();
		pk.setAeroportoId(1L);
		pk.setVooId(1L);

		vooAeroporto.setId(pk);
		vooAeroportos.add(vooAeroporto);

		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setIdAeroporto(1L);
		aeroporto.setLatitude(-3.7760207129917815);
		aeroporto.setLongetude(-38.5330966);
		aeroporto.setNomeAeroporto("Pinto MArtins");
		aeroporto.setSiglaAeroporto("PTMT");

		vooAeroporto.setId(pk);
		vooAeroporto.setSentido("Ida");
		vooAeroporto.setAeroporto(aeroporto);
		vooAeroporto.setVoo(new Voo());

		voo.setAviao(aviao);
		voo.setPiloto(piloto);
		voo.setStatusVoo(statusVoo);
		voo.setTipoVoo(tipoVoo);
		voo.setAeroportosOrigemDestino(vooAeroportos);

		return voo;

	}

}
