package br.com.cupuladodragao.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cupuladodragao.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmailIgnoreCase(String email);

}
