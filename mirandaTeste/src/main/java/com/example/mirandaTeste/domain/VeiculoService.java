package com.example.mirandaTeste.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;
	
	public Iterable<Veiculo> getAllVeiculos() {
		return repository.findAll();
	}
	
	
	public Optional<Veiculo> getVeiculobyId(Long id ) {
		return repository.findVeiculoById(id);
	}
	
	public Veiculo postVeiculo(Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	public Veiculo updateVeiculo(Veiculo veiculo,Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro, sem ID");
		
		Optional<Veiculo> optional = getVeiculobyId(id);
		if (optional.isPresent()) {
			Veiculo doBancoDeDados = optional.get();
			
			doBancoDeDados.setVeiculo(veiculo.getVeiculo());;
			doBancoDeDados.setMarca(veiculo.getMarca());
			doBancoDeDados.setAno(veiculo.getAno());
			doBancoDeDados.setDescricao(veiculo.getDescricao());
			doBancoDeDados.setVendido(veiculo.isVendido());
			doBancoDeDados.setChassi(veiculo.getChassi());
			doBancoDeDados.setPreco(veiculo.getPreco());
			
			repository.save(doBancoDeDados);
			
			return doBancoDeDados;
		} else {
			throw new RuntimeException("Não se foi possivel atualizar o registro");
		}
	}


	public void deleteVeiculoById(Long id) {
		Optional<Veiculo> carroSerDeletado = repository.findVeiculoById(id);
		
		if(carroSerDeletado.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RuntimeException( "Nao havia nenhum carro a ser deletado");
		}
	}
	
	
	
	
}
