package fafica.pi.projeto.teste;

import java.util.ArrayList;

import fafica.pi.projeto.entidades.Produto;
import fafica.pi.projeto.entidades.Tendencias;
import fafica.pi.projeto.jdbc.TendenciaDao;

public class TesteTendencia {
	
  public static void main(String[] args) {
	
	   
	// testeCadastrar();
		// testAlterar();
		// testExcluir();
		 testarListarTodos();
		
	}

	private static void testeCadastrar() {
		Tendencias tendencia = new Tendencias();
		
		tendencia.setNome("corte pixie");
		
		
		TendenciaDao ten= new TendenciaDao();
		
		ten.Cadastar(tendencia);
	}
	private static void testAlterar(){
		
		Tendencias tendencia= new Tendencias();
	
		tendencia.setCodigo(6);
		tendencia.setNome("Corte Militar");
		TendenciaDao ten = new TendenciaDao();
		ten.alterar(tendencia);
	
	}
	
	private static void testExcluir(){
		
		Tendencias tendencia = new Tendencias();
		tendencia.setCodigo(2);
		
		TendenciaDao ten = new TendenciaDao();
		ten.excluir(tendencia);
	}
	
	 private static void testarListarTodos(){
		 TendenciaDao produto= new TendenciaDao();
		 //Lista com os valores retornados do banco
		 ArrayList<Tendencias> listaResultado = produto.listarTodos();
		 //Varrendo e imprimindo a lista
		 for(Tendencias c: listaResultado){
			 System.out.println("NOME: "+c.getNome()+"\nTenencia: "+c.getCodigo()+"\nID Cliente: "+c.getId_cliente()+"\nUsuario Adm"+c.getId_usuario_adm());
		 
	 }


}
}
