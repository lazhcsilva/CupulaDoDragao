package br.com.cupuladodragao.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cupuladodragao.model.Usuario;
import br.com.cupuladodragao.service.UsuarioService;

@Controller
public class UsuarioController {

	private static String caminhoImagens = "C:\\Users\\lazhc\\Documents\\Spring Projects\\CupulaDoDragao\\src\\main\\resources\\static\\img\\usuario";
	
	private IndexController indexController;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario, Errors errors, RedirectAttributes ra,@RequestParam("file")MultipartFile arquivo) throws Exception{
		if(errors.hasErrors()) {
			ra.addFlashAttribute("mensagem", "erro");
			return this.indexController.cadastro();
		} else {
			try {
				if(!arquivo.isEmpty()) {
					byte[] bytes = arquivo.getBytes();
					Path caminho = Paths.get(caminhoImagens+String.valueOf(usuario.getIdUsuario()+arquivo.getOriginalFilename()));
					Files.write(caminho, bytes);
					usuario.setFotoUsuario(String.valueOf(usuario.getIdUsuario())+arquivo.getOriginalFilename());
				}
				this.usuarioService.criarUsuario(usuario);
			} catch(ServiceException e) {
				ra.addFlashAttribute("menssage", "Não foi possível criar usuário: " + e.getMessage());
				ra.addFlashAttribute("usuario", usuario);
				return "redirect:/cadastro";
			}
			ra.addFlashAttribute("menssage", "Conta criada com sucesso");
		}
		return "redirect:/index";
	}
	
}
