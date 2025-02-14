package br.com.rosa.domain.client;

import br.com.rosa.domain.address.dto.DataAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.rosa.domain.client.dto.UpdateClient;
import br.com.rosa.domain.client.dto.ClientRegister;
import br.com.rosa.domain.person.Pessoa;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client extends Pessoa{

	private String nameReason;
	private String cpfCnpj;
	private String rgStateRegistration;
	private LocalDate dateBirthCompanyFormation;
	
	public Client(ClientRegister data, DataAddress addrees) {

		super(data.email(), addrees, data.phone1(), data.phone2());
		this.nameReason = data.name();
		this.cpfCnpj = data.cpf();
		this.rgStateRegistration = data.rg();
		this.dateBirthCompanyFormation = data.dateBirth();
	}
	
	public Client(Long id) {
		
		super(id);
	}
	
	public void atualizarInformacoes(UpdateClient data) {
		if(data.email() != null && !this.getEmail().equals(data.email())) {
			super.setEmail(data.email());
		}
		if(data.cep() != null && !this.getAddress().getCep().equals(data.cep())) {
			super.getAddress().setCep(data.cep());
			//super.setAddrees(new Endereco(dados.endereco()));
		}
		if(data.street() != null && !this.getAddress().getStreet().equals(data.street())) {
			super.getAddress().setStreet(data.street());
			//super.setAddrees(new Endereco(dados.endereco()));
		}
		if(data.city() != null && !this.getAddress().getCity().equals(data.city())) {
			super.getAddress().setCity(data.city());
			//super.setAddrees(new Endereco(dados.endereco()));
		}
		if(data.district() != null && !this.getAddress().getDistrict().equals(data.district())) {
			super.getAddress().setDistrict(data.district());
			//super.setAddrees(new Endereco(dados.endereco()));
		}
		if(data.number() != null && !this.getAddress().getNumber().equals(data.number())) {
			super.getAddress().setNumber(data.number());
			//super.setAddrees(new Endereco(dados.endereco()));
		}
		if(data.phone1() != null && !this.getPhone1().equals(data.phone1())) {
			super.setPhone1(data.phone1());
		}

		if(data.phone2() != null && !this.getPhone2().equals(data.phone2())) {
			super.setPhone2(data.phone2());
		}

		
	}
	
}
