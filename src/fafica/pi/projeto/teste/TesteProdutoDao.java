package fafica.pi.projeto.teste;

import java.util.ArrayList;

import fafica.pi.projeto.entidades.Produto;
import fafica.pi.projeto.entidades.Profissional;
import fafica.pi.projeto.jdbc.ProdutoDao;
import fafica.pi.projeto.jdbc.ProdutoDao;

public class TesteProdutoDao {

	public static void main(String[] args) {
		
		//testeCadastrar();
		 //testAlterar();
		 //testExcluir();
		//testarListarTodos();
		
	}

	private static void testeCadastrar() {
		Produto produto = new Produto();
		produto.setNome("Hidratação Loreal");
		produto.setPreco(100.00);
		
		ProdutoDao prod = new ProdutoDao();
		prod.cadastrar(produto);
	}
	private static void testAlterar(){
		
		Produto produto= new Produto();
	
		produto.setId_produto(2);
		produto.setNome("Kit");
		produto.setPreco(250.00);
		
		ProdutoDao pro = new ProdutoDao();
		pro.alterar(produto);
	
	}
	
	private static void testExcluir(){
		
		Produto produto = new Produto();
		produto.setId_produto(7);
		
		ProdutoDao pro = new ProdutoDao();
		pro.excluir(produto);
	}
	
	 private static void testarListarTodos(){
		 ProdutoDao produto= new ProdutoDao();
		 //Lista com os valores retornados do banco
		 ArrayList<Produto> listaResultado = produto.listarTodos();
		 //Varrendo e imprimindo a lista
		 for(Produto c: listaResultado){
			 System.out.println("NOME: "+c.getNome()+"\nPreço: "+c.getPreco()+"\nID do produto: "+c.getId_produto());
		 }
	 }

}
