package br.com.cupuladodragao.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImagemController {

	private static String caminhoImagem = "C:\\Users\\lazhc\\Documents\\Spring Projects\\CupulaDoDragao\\src\\main\\resources\\static\\img\\usuario";
	private static String caminhoImagemPost = "C:\\Users\\lazhc\\Documents\\Spring Projects\\CupulaDoDragao\\src\\main\\resources\\static\\img\\post";
	
	@GetMapping("/mostrarImagemUsuario/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem")String imagem) throws IOException{
		File imagemArquivoFile = new File(caminhoImagem+imagem);
		if(imagem!=null || imagem.trim().length()>0) {
			return Files.readAllBytes(imagemArquivoFile.toPath());
		}
		return Files.readAllBytes(imagemArquivoFile.toPath());
	}
	
	@GetMapping("/mostrarImagemPost/{imagem}")
	@ResponseBody
	public byte[] retornarImagemPost(@PathVariable("imagem")String imagem) throws IOException{
		File imagemArquivoFile = new File(caminhoImagemPost+imagem);
		if(imagem!=null || imagem.trim().length()>0) {
			return Files.readAllBytes(imagemArquivoFile.toPath());
		}
		return Files.readAllBytes(imagemArquivoFile.toPath());
	}
	
}
