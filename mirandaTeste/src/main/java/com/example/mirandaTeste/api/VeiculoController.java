package com.example.mirandaTeste.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.mirandaTeste.domain.Veiculo;
import com.example.mirandaTeste.domain.VeiculoService;

@RestController
@RequestMapping("/api/v1/carros")
public class VeiculoController {
	@Autowired
	private VeiculoService service;
	
	@GetMapping()
	public Iterable<Veiculo> getAllVeiculos() {
		return service.getAllVeiculos();
	}
	
	@GetMapping("/{id}")
	public Optional<Veiculo> getVeiculoId(@PathVariable("id") Long id) {
		return service.getVeiculobyId(id);
	}
	
	@PostMapping()
	public String postVeiculo(@RequestBody Veiculo veiculo) {
		service.postVeiculo(veiculo);
		
		return "Carro Adicionado com sucesso";
	}
	
	@PutMapping("/{id}")
	public String updateVeiculoById (@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		Veiculo c = service.updateVeiculo(veiculo, id);
		return "Carro atualizado: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		service.deleteVeiculoById(id);
		
		return "Carro deletado com sucesso";
	}
	

}
