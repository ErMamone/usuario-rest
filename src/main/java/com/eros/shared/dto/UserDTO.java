package com.eros.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private UUID id;

	private String name;

	private String email;

	private String password;

	private Date created;

	private Date modified;

	private Date last_login;

	private UUID token;

	private Integer is_active;

	private List<PhoneDTO> phoneDTOList;


}
