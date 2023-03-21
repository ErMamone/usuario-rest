package com.eros.controller;

import com.eros.entity.Usuario;
import com.eros.service.UsuarioService;
import com.eros.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

	private final UsuarioService usuarioService;

	@GetMapping("/")
	public String getAll(){
		List<Usuario> usersList;
		try {
			usersList = usuarioService.getAll();
			log.info(usersList.toString());
		}catch (Exception e){
			return e.getMessage();
		}
		return usersList.toString();
	}

	@PostMapping("/")
	public String createUser(@RequestBody UserDTO userDTO){
		Usuario user;
		try {
			user = usuarioService.save(userDTO);
		}catch (Exception e){
			return "Error:" + e.getMessage();
		}
		return user.toString();
	}

	@GetMapping("/{name}")
	public String getByName(@RequestParam String name){
		Usuario user;
		try {
			user = usuarioService.getByName(name);
		}catch (Exception e){
			return e.getMessage();
		}
		return user.toString();
	}

	@DeleteMapping("/del{name}")
	public String delete(@RequestParam String name){
		Usuario usuario;
		try {
			usuario = usuarioService.getByName(name);
			usuarioService.delete(name);
		}catch (Exception e){
			return e.getMessage();
		}
		return "Deteled";
	}

}
