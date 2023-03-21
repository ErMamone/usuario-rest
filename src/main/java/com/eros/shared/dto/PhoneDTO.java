package com.eros.shared.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

	private Long number;

	private BigInteger cityCode;

	private BigInteger countryCode;

}
