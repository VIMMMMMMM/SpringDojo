package com.u2.web.SpringDojo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.u2.web.SpringDojo.model.LivroModel;
import com.u2.web.SpringDojo.negocio.LivroRN;

import java.util.List;

@Controller
public class LivroController {
	
	LivroRN livroRN = new LivroRN();
	
	
	@GetMapping({"/homeLivro"})
	public String abreCadastro() {
		return "Cadastro";
	}
	
	
	@RequestMapping({"/cadastrar"})
	public String cadastrarLivro(HttpServletRequest request,
			@RequestParam(value="titulo") String titulo,
			@RequestParam(value="editora") String editora) {
		
		/* Recuperar os valores dos campos do formulário
		 * e preencher os atributos do model da entidade selecionada
		 */
		LivroModel modelLivro = new LivroModel();
		String mensagem = "";
		boolean cadastrouLivro = false;
		
		if(!titulo.equals("")) {
			modelLivro.setTitulo(titulo);
		} else {
			mensagem = "Título não pode ficar em branco.\n";
		}
		if(!editora.equals("")) {
			modelLivro.setEditora(editora);
		} else {
			mensagem += "Editora não pode ficar em branco.";
		}
		if(mensagem.equals("")) {
			//Tudo ok, então realizar o cadastro da entidade
			
			cadastrouLivro = livroRN.cadastrarLivro(modelLivro);
			
			if(!cadastrouLivro) {
				mensagem = "Livro já existente na base.";
			}
		}
		if(!mensagem.equals("")) {
			request.getSession().setAttribute("mensagem", mensagem);
		}
		
		return "Cadastro";
	}
	@GetMapping("/pesquisarLivro")
	public String abrePesquisa(){
		return "Pesquisa";
	}
	@RequestMapping(value = "/pesquisar")
	public String findByTitle(@RequestParam(value = "titulo")String titulo,
										HttpServletRequest request){
		request.getSession().setAttribute("livros",livroRN.pesquisarLivro(titulo).toString());
		return "Pesquisa";
	}

	@GetMapping("/pesquisarTodos")
	public String findAll(HttpServletRequest request){
		request.getSession().setAttribute("livros",livroRN.pesquisarTodos());
		return "Pesquisas";
	}


}
