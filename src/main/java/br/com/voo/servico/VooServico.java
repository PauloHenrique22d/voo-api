package br.com.voo.servico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voo.entidades.Piloto;
import br.com.voo.entidades.Voo;
import br.com.voo.repositorio.PilotoRepositorio;
import br.com.voo.repositorio.VooRepositorio;
import br.com.voo.vo.PilotoVO;
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
	
	@Autowired 
	private PilotoRepositorio pilotoRepositorio;

	/**
	 * Lista todos os voos cadastrados
	 * @return  uma lista de voos
	 * @throws RuntimeException
	 */
	public List<Voo> findAll() throws RuntimeException{
		
		try {
			return vooRepositorio.findAll();
		} catch (Exception e) {
			log.info("Ocorreu um erro ao consultar Voos");
			return new ArrayList<>();
		}
	}

	/**
	 * @param id
	 * @return O voo consultado
	 * @throws RuntimeException
	 */
	public Optional<Voo> findById(Long id) throws RuntimeException{
		
		Optional<Voo> voos = null;
		
		try {
			voos = vooRepositorio.findById(id);
			return voos;
		} catch (Exception e) {
			log.info("Ocorreu um erro ao consultar um determinado Voo");
			return voos;
		}
	}

	/**
	 * Salva o voo em questao
	 * @param voo
	 * @return o voo salvo
	 * @throws RuntimeException
	 */
	public Voo salvar(Voo voo) throws RuntimeException{
		
		try {
			return vooRepositorio.save(voo);
		} catch (Exception e) {
			log.info("Ocorreu um erro ao salvar Voo");
			return new Voo();
		}
	}

}
