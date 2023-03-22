package com.eros.service.impl;

import com.eros.entity.Usuario;
import com.eros.exceptions.ExistingEmailException;
import com.eros.exceptions.InvalidEmailException;
import com.eros.exceptions.InvalidPasswordException;
import com.eros.repository.UsuarioRepository;
import com.eros.service.PhoneService;
import com.eros.service.UsuarioService;
import com.eros.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {


	//Minimo 8 caracteres, 1 especial, 1 mayus y 1 numerico
	private final Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

	private final Pattern patternMail = Pattern.compile("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

	private final UsuarioRepository usuarioRepository;

	private final PhoneService phoneService;

	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getByName(String name) {
		return usuarioRepository.findByName(name);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public Usuario save(UserDTO usuarioDTO) throws ExistingEmailException, InvalidEmailException, InvalidPasswordException {
		if (usuarioRepository.existByEmail(usuarioDTO.getEmail())) {
			throw new ExistingEmailException(usuarioDTO.getEmail() + " is already registered!");
		}

		if (!patternMail.matcher(usuarioDTO.getEmail()).matches()) {
			throw new InvalidEmailException(usuarioDTO.getEmail() + " is not a valid email!");
		}

		if (!patternPassword.matcher(usuarioDTO.getPassword()).matches()) {
			throw new InvalidPasswordException("The password dont match with the basic (min 8 characters, 1 letter upper another lower, 1 number and 1 special char)");
		}

		usuarioDTO.setCreated(new Date());
		usuarioDTO.setModified(new Date());
		usuarioDTO.setLast_login(new Date());
		usuarioDTO.setToken(null);

		var user = new Usuario(usuarioDTO);

		user.setPhones(phoneService.saveList(usuarioDTO.getPhoneDTOList()));

		return usuarioRepository.save(user);
	}

	@Override
	public void delete(String name) {
		var userToDelete = usuarioRepository.findByName(name);
		usuarioRepository.delete(userToDelete);
	}

	@Override
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}
}
