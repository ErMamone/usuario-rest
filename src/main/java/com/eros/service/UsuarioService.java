package com.eros.service;

import com.eros.entity.Usuario;
import com.eros.exceptions.ExistingEmailException;
import com.eros.exceptions.InvalidEmailException;
import com.eros.exceptions.InvalidPasswordException;
import com.eros.shared.dto.UserDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface UsuarioService {
	List<Usuario> getAll();

	Usuario getByName(String name);

	Usuario save(UserDTO usuarioDTO) throws ExistingEmailException, InvalidEmailException, InvalidPasswordException;

	void delete(String name);
}
