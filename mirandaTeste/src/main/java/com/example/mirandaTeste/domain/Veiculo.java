package com.example.mirandaTeste.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" )
	private Long id;

	@Column(name="veiculo" )
	private String veiculo;
	
	@Column(name="marca" )
	private String marca;
	
	@Column(name="ano" )
	private int ano;
	
	@Column(name="descricao" )
	private String descricao;
	
	@Column(name="vendido" )
	private boolean vendido;
	
	@Column(name="createdAt" )
	private LocalDate created;
	
		
	
	@Column(name="updatedAt", nullable = true)
	private LocalDate updated;
	
	@Column(name="chassi", unique=true )
	private String chassi;
	
	@Column(name="preco", precision = 10, scale = 2)
	private BigDecimal preco;
	
	@PrePersist
    public void prePersist() {
        created = LocalDate.now();
        int currentYear = LocalDate.now().getYear();
        if (ano > currentYear) {
            throw new IllegalStateException("O ano do veículo não pode ser maior que o ano atual");
        }
        
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("O valor do carro não pode ser negativo");
        }
    }
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
