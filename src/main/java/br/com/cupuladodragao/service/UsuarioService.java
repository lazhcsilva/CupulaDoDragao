package br.com.cupuladodragao.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cupuladodragao.model.Usuario;
import br.com.cupuladodragao.persistence.UsuarioDAO;
import br.com.cupuladodragao.utils.Utils;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario findUsuarioByEmail(String email) {
		return usuarioDAO.findByEmailIgnoreCase(email);
	}
	
	public void criarUsuario(Usuario usuario) throws ServiceException{
		if(this.findUsuarioByEmail(usuario.getEmail()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		} else {
			String senhaCriptografada;
			try {
				senhaCriptografada = Utils.criptografarSenha(usuario.getSenha());
				usuario.setSenha(senhaCriptografada);
				this.usuarioDAO.save(usuario);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void save(Usuario usuario) {
		this.usuarioDAO.save(usuario);
	}
	
}
