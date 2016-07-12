package mz.com.cenfoss.zk.java.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="celular")
public class Celular {
	private long id;
	private String marca;
	private String modelo;
	private String fabricante;
	private long serial;
	private String cor;

	@Override
	public String toString() {
		return "Celular\nMarca: " + marca + "\nModelo: " + modelo + "\nFabricante: " + fabricante + "\nSerial:" + serial
				+ "Cor:" + cor;
	}

	@Column(name="marca")
	public String getMarca() {
		return marca;
	}

	@Column(name="modelo")
	public String getModelo() {
		return modelo;
	}

	@Column(name="fabricante")
	public String getFabricante() {
		return fabricante;
	}

	@Column(name="serial")
	public long getSerial() {
		return serial;
	}

	@Column(name="cor")
	public String getCor() {
		return cor;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
