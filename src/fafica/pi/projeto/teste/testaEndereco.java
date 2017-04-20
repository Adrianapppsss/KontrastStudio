package fafica.pi.projeto.teste;

import java.util.ArrayList;

import fafica.pi.projeto.entidades.Endereco;

import fafica.pi.projeto.jdbc.EnderecoDao;

public class testaEndereco {

	public static void main(String[] args) {
	
		  // testeCadastrar();
				//testeAlterar();
				//testeDeletar();
				
				testarListarTodos();
				
			}
			//Testar metodo cadastrar
			private static void testeCadastrar() {
				Endereco endereco= new Endereco();
								
				endereco.setBairro("Coqueiral");;
				endereco.setRua("Escada");
				endereco.setNum(97);
				endereco.setCidade("Toritama");
				endereco.setCEP("55125-000");
				
				
				EnderecoDao local = new EnderecoDao();
				
				local.cadastrar(endereco);
			}
			//Testar metodo alterar
			private static void testeAlterar(){
				
				Endereco endereco= new Endereco();
				endereco.setId_endereco(1);
				endereco.setBairro("Planalto");
				endereco.setRua("Das Acacias");
				endereco.setNum(12);
				endereco.setCidade("Toritama");
				endereco.setCEP("55125-000");
				
				EnderecoDao usu = new EnderecoDao();
				
				usu.alterar(endereco);
			}
			private static void testeDeletar(){
				Endereco endereco = new Endereco();
				endereco.setId_endereco(2);
				
				EnderecoDao usu = new EnderecoDao();
				usu.excluir(endereco);
			}
			 private static void testarListarTodos(){
				 EnderecoDao usu = new EnderecoDao();
				 //Lista com os valores retornados do banco
				 ArrayList<Endereco> listaResultado = usu.listarTodos();
				 //Varrendo e imprimindo a lista
				 for(Endereco c: listaResultado){
					 System.out.println("Bairro : "+c.getBairro()+"\nRua : "+c.getRua()+"\nNumero : "+c.getNum()+"\nCidade: "+c.getCidade()+"\nCEP: "+c.getCEP()+"\nID: "+c.getId_endereco());
				 }
			 }

		
	

}
