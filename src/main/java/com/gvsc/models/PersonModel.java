package com.gvsc.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "person")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private Long id;
	
	@Column(name = "NAME", nullable = false)
    @Size(min = 3, max = 50, message = "Name must have between 3 and 20 letters")
	@NotBlank
	private String name;
	
	@Column(name = "CPF", nullable = false)
	@NotBlank
	@Size(min = 11, max = 11, message = "CPF must have between 11 letters")
	private String cpf;
	
	@Column(name = "CELLPHONE", nullable = false)
	@NotBlank
    @Size(min = 11, max = 11, message = "Cellphone must have between 11 letters")
	private String cellphone;
	
	@Column(name = "ADDRESS", nullable = false)
    @Size(min = 5, max = 50, message = "Address must have between 5 and 50 letters")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
