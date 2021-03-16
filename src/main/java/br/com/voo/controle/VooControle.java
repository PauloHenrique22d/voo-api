package br.com.voo.controle;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.voo.entidades.Voo;
import br.com.voo.servico.VooServico;
import br.com.voo.vo.VooVO;

@RestController
@RequestMapping("/voo")
@CrossOrigin(origins = "http://localhost:4200")
public class VooControle {
	
	@Autowired
	private VooServico vooServico;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<?> listar() {
		
		List<Voo> voos = vooServico.findAll();
        voos.stream().map(this::convertToDto).collect(Collectors.toList() ) ;
		return !voos.isEmpty() ? ResponseEntity.ok(voos) : ResponseEntity.noContent().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Voo> criar(@RequestBody Voo voo, HttpServletResponse response) {
		vooServico.salvar(voo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(voo.getIdVoo())
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(voo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscaPeloCodigo(@PathVariable Long id) {
		
		Optional<Voo> voo = vooServico.findById(id);
		voo.stream().map(this::convertToDto).collect(Collectors.toList() ) ;
		return voo != null ? ResponseEntity.ok(voo) : ResponseEntity.notFound().build();
	}
	
	private VooVO convertToDto(Voo voo) {
		VooVO vooVO = modelMapper.map(voo, VooVO.class);
	    return vooVO;
	}

}
