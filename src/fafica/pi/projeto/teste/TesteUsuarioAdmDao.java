package fafica.pi.projeto.teste;

import java.util.List;

import fafica.pi.projeto.entidades.Usuario_ADM;
import fafica.pi.projeto.jdbc.Usuario_Adm_Dao;

public class TesteUsuarioAdmDao {

	public static void main(String[] args) {
	
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		listarTodos();
		
	}

	private static void testCadastrar() {
		Usuario_ADM adm = new Usuario_ADM();
		adm.setNome("Ana Paula");
		adm.setNomeSalao("Moda");
		adm.setEndereco("Rua Escada");
		adm.setTelefone("(81)3741-0987");
		adm.setLogin("erernn98");
		adm.setSenha("09871rre");
		
		
		Usuario_Adm_Dao usu = new Usuario_Adm_Dao();
		usu.cadastrar(adm);
	}
	
	private static void testAlterar(){
		Usuario_ADM adm = new Usuario_ADM();
		adm.setId_UsuarioAdm(2);
		adm.setNome("Henrique");
		adm.setNomeSalao("Modelo");
		adm.setEndereco("Rua Escada");
		adm.setTelefone("(81)3098-0987");
		adm.setLogin("ere98");
		adm.setSenha("098re");
		
		
		Usuario_Adm_Dao usu = new Usuario_Adm_Dao();
		usu.alterar(adm);
	}
	
	private static void testExcluir(){
		
		Usuario_ADM adm = new Usuario_ADM();
		adm.setId_UsuarioAdm(2);
		
		Usuario_Adm_Dao usu = new Usuario_Adm_Dao();
		usu.excluir(adm);;
	}
	
	private static void listarTodos(){
		
		Usuario_Adm_Dao adm = new Usuario_Adm_Dao();
		
		List<Usuario_ADM>listaResultados = adm.listarTodos();
		for(Usuario_ADM a: listaResultados){
			System.out.println("Nome: "+a.getNome()+"\n Nome do salão: "+a.getNomeSalao()+"\nEndereço: "+a.getEndereco()+"\n Telefone: "+a.getTelefone()+" \nLogin: "+a.getLogin()+"\nSenha:  "+a.getSenha());
			
		}
	}

}
