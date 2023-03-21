package com.eros.repository;

import com.eros.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	public Usuario findByName(String name);


	@Query("select case when count(c)> 0 then true else false end from Usuario c where c.email = :email")
	boolean existByEmail(@Param("email") String email);


}
