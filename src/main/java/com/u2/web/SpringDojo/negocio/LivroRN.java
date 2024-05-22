package com.u2.web.SpringDojo.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.u2.web.SpringDojo.model.LivroModel;

public class LivroRN {
	private HashMap<String, LivroModel> hashLivro = new HashMap<>();
	private LivroModel livro = new LivroModel();

	public boolean cadastrarLivro(LivroModel model) {

		//Fazer o cadastramento através do título
		if(!hashLivro.containsKey(model.getTitulo())) {
			hashLivro.put(model.getTitulo(), model);
		} else {
			return false;
		}

		return true;
	}
	public LivroModel pesquisarLivro(String titulo){
		if (!hashLivro.containsKey(titulo)){
			throw new RuntimeException();
		}else {
			return hashLivro.get(titulo);
		}

	}

	public LivroModel pegarLivroAntigo(String titulo){
		if (!hashLivro.containsKey(titulo)){
			throw new RuntimeException();
		}else {
			livro = pesquisarLivro(titulo);
			System.out.println(livro.toString() + " dentro de pegar livro antigo");
			return livro;
		}
	}

	public LivroModel editarLivro(String titulo, String editora){
		//hashLivro.containsKey(titulo);
		System.out.println(livro.toString() + " dentro de editar");
		if(!titulo.equals(livro.getTitulo())){
			livro.setTitulo(titulo);
		}
		if(!editora.equals(livro.getEditora())){
			livro.setEditora(editora);
		}
		return hashLivro.put(livro.getTitulo(),livro);
	}

	public HashMap<String, LivroModel> pesquisarTodos() {
		return hashLivro;
	}

	public List<LivroModel> listarTodosLivros() {
		return new ArrayList<>(hashLivro.values());
	}
}