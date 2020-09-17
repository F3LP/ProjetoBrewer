package com.cervejaria.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?", message = "SKU deve seguir o padrão XX9999.")
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@Size(min = 1, max = 50, message = "A descrição deve conter entre 1 e 50 caracteres")
	private String descricao;

	@NotNull(message = "O valor é obrigatório.")
	@DecimalMin("0.01")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@DecimalMin(value = "0.50", message = "O valor da cerveja deve ser maior que R$0,50.")
	@DecimalMax(value="9999999.99", message = "O valor da cerveja deve ser menor que R$ 9.999.999,99")
	private BigDecimal valor;
	
	@NotNull(message = "O teor alcoolico é obrigatório.")
	@Column(name = "teor_alcoolico")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal teorAlcoolico;
	
	@NotNull(message = "O campo comissão é obrigatório.")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal comissao;
	
	@Column(name = "quantidade_estoque")
	@Max(value = 9999, message = "A quantidade de estoque deve ser menor que 9.999.")
	@NotNull(message = "O campo estoque é obrigatório.")
	private Integer quantidadeEstoque;
	
	@NotNull(message = "O campo origem é obrigatório.")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message = "O campo sabor é obrigatório.")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	@NotNull(message = "O campo estilo é obrigatório.")
	private Estilo estilo;
	
	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		sku = sku.toUpperCase();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}
