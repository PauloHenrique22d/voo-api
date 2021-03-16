package br.com.voo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.voo.entidades.Voo;

public interface VooRepositorio extends JpaRepository<Voo, Long> {

}
