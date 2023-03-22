package com.eros.entity;

import com.eros.shared.dto.PhoneDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Long id;

	@Column(name = "number")
	private Long number;

	@Column(name = "city_code")
	private BigInteger cityCode;

	@Column(name = "country_code")
	private BigInteger countryCode;

	@Override
	public String toString() {
		return "\t{\n" +
				"\t\t\"number\":\"" + number + "\",\n" +
				"\t\t\"cityCode\":\"" + cityCode + "\",\n" +
				"\t\t\"countryCode\":\"" + countryCode + "\"\n" +
				"\t}\n";
	}

	public Phone(PhoneDTO phone) {
		this.number = phone.getNumber();
		this.cityCode = phone.getCityCode();
		this.countryCode = phone.getCountryCode();
	}
}
