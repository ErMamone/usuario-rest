package com.eros.entity;

import com.eros.shared.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
@ToString
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private UUID id;

	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="created")
	private Date created;

	@Column(name="modified")
	private Date modified;

	@Column(name="last_login")
	private Date last_login;

	@Column(name="token")
	private UUID token;

	@Column(name="is_active")
	private Integer is_active;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Phone> phones;

	public Usuario (UserDTO user){
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.created = user.getCreated();
		this.modified = user.getModified();
		this.last_login = user.getLast_login();
		this.token = user.getToken();
		this.is_active = user.getIs_active();
	}
}
