package fafica.pi.projeto.teste;

import java.util.ArrayList;

import fafica.pi.projeto.entidades.Profissional;
import fafica.pi.projeto.entidades.Cliente;
import fafica.pi.projeto.jdbc.ClienteDAO;
import fafica.pi.projeto.jdbc.ProfissionalDao;

public class TestaProfissionarioDao {

	public static void main(String[] args) {
		
		

		//testeCadastrar();
		//testAlterar();
		//testExcluir();
		testarListarTodos();
		
	}

	private static void testeCadastrar() {
		Profissional profis = new Profissional();
		profis.setNome("Mariana");
		profis.setEspecialidade("Cabelereira");
		
		ProfissionalDao pro = new ProfissionalDao();
		pro.cadastrar(profis);
	}

	private static void testAlterar(){
		
		Profissional profis = new Profissional();
		profis.setId_profissional(1);
		profis.setNome("Leal");
		profis.setEspecialidade("Cabelereiro");
		
		ProfissionalDao pro = new ProfissionalDao();
		pro.alterar(profis);
	
	}
	
	private static void testExcluir(){
		
		Profissional profis = new Profissional();
		profis.setId_profissional(6);
		
		ProfissionalDao pro = new ProfissionalDao();
		pro.excluir(profis);
	}
	
	 private static void testarListarTodos(){
		 ProfissionalDao usu = new ProfissionalDao();
		 //Lista com os valores retornados do banco
		 ArrayList<Profissional> listaResultado = usu.listarTodos();
		 //Varrendo e imprimindo a lista
		 for(Profissional c: listaResultado){
			 System.out.println("NOME: "+c.getNome()+"\nEspecialidade: "+c.getEspecialidade()+"\nID: "+c.getId_profissional());
		 }
	 }
}
