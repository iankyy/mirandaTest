package com.example.mirandaTeste.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
	
	Optional<Veiculo> findVeiculoById(Long id);

}
