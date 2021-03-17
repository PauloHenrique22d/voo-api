package br.com.voo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.voo.entidades.Piloto;

public interface PilotoRepositorio extends JpaRepository<Piloto, Long> {

}
