package com.eros.entity;

import com.eros.shared.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Phone> phones;

	@ToString.Exclude
	@Column(name = "created")
	private Date created;

	@ToString.Exclude
	@Column(name = "modified")
	private Date modified;

	@ToString.Exclude
	@Column(name = "last_login")
	private Date last_login;

	@ToString.Exclude
	@Column(name = "token")
	private String token;

	@ToString.Exclude
	@Column(name = "is_active")
	private Integer is_active;


	public Usuario(UserDTO user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.created = user.getCreated();
		this.modified = user.getModified();
		this.last_login = user.getLast_login();
		this.token = user.getToken();
		this.is_active = user.getIs_active();
	}

	@Override
	public String toString() {
		return "{\n" +
				"\t\"id\":\"" + id + "\",\n" +
				"\t\"name\":\"" + name + "\",\n" +
				"\t\"email\":\"" + email + "\",\n" +
				"\t\"password\":\"" + password + "\",\n" +
				"\t\"phones\": " + phones.toString() + " \n" +
				"}\n";
	}
}
