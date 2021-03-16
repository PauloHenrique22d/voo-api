package br.com.voo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voo.entidades.Voo;
import br.com.voo.repositorio.VooRepositorio;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de servico responsavel por implementar as regras de negocio de um voo
 * @author phsousa
 *
 */
@Service
@Slf4j
public class VooServico {

	@Autowired
	private VooRepositorio vooRepositorio;

	public List<Voo> findAll() {

		List<Voo> voos = vooRepositorio.findAll();
		return voos;
		
	}

	public Optional<Voo> findById(Long id) {
		
		// log.debug("teste log info");
		// log.info("teste log error");
		
		return vooRepositorio.findById(id);
	}

	public Voo salvar(Voo voo) {

		return vooRepositorio.save(voo);
	}

}
