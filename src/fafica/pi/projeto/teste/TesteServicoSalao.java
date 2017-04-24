package fafica.pi.projeto.teste;

import java.util.ArrayList;

import fafica.pi.projeto.entidades.Servico_Salao;
import fafica.pi.projeto.entidades.Servico_Salao;
import fafica.pi.projeto.jdbc.ServicoSalaoDao;
import fafica.pi.projeto.jdbc.ServicoSalaoDao;

public class TesteServicoSalao {

	public static void main(String[] args) {
		

	    //testeCadastrar();
		//testeAlterar();
		//testeExcluir();		
		//testarListarTodos();
		
	}
	//Testar metodo cadastrar
	private static void testeCadastrar() {
		Servico_Salao servico = new Servico_Salao();
		
		servico.setCabelos("Pintar cabelos logos");
		servico.setDepilacaoFeminina("Sobrancelha");
		servico.setDepilacaoMasculina("Depilação Peito");
		servico.setManicure_pedicure("Unhas em gel");
		servico.setServico_especial("Noiva Vip");
		servico.setValor_servico(30.00);
		
		ServicoSalaoDao usu = new ServicoSalaoDao();
		
		usu.cadastrar(servico);
	}
	//Testar metodo alterar
	private static void testeAlterar(){
		
		Servico_Salao servico= new Servico_Salao();
		servico.setId_Servico(2);
		servico.setCabelos("Corta Cabelos ");
		servico.setDepilacaoFeminina("Perna inteira");
		servico.setDepilacaoMasculina("Axila");
		servico.setManicure_pedicure("Unhas ");
		servico.setServico_especial("Casamento");
		servico.setValor_servico(100.00);
		
		ServicoSalaoDao usu = new ServicoSalaoDao();
		
		usu.alterar(servico);
	}
	private static void testeExcluir(){
		Servico_Salao servico = new Servico_Salao();
		servico.setId_Servico(7);
		
		ServicoSalaoDao usu = new ServicoSalaoDao();
		usu.excluir(servico);
	}
	 private static void testarListarTodos(){
		 ServicoSalaoDao usu = new ServicoSalaoDao();
		 //Lista com os valores retornados do banco
		 ArrayList<Servico_Salao> listaResultado = usu.listarTodos();
		 //Varrendo e imprimindo a lista
		 for(Servico_Salao c: listaResultado){
			 System.out.println("Serviços para cabelo: "+c.getCabelos()+"\nDepilação Masculina: "+c.getDepilacaoMasculina()+"\nDepilação Feminina: "+c.getDepilacaoFeminina()+"\nManicure & Pedicure: "+c.getManicure_pedicure()+"\nID: "+c.getId_Servico());
		 }
	 

	}

}
