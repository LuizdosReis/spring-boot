package controleGastos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import controleGastos.converter.LocalDateAttributeConverter;

@Entity
public class Despesa {

	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate data;
	private BigDecimal valor;

	public Despesa() {
	}

	public Despesa(LocalDate data, String descricao, BigDecimal valor) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
