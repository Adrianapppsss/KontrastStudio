package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Endereco;


public class EnderecoDao {
	
	//Ponteiro para uma coneção com o banco 
		private Connection con = Conexao.getConnection();
		
		public void cadastrar(Endereco endereco){
			//Montando sql
			String sql = "insert into endereco (bairro, rua, num, cep, cidade) values(?,?,?,?,?)";
			//Constroe o PreparedStatement passando o sql
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Substituindo as interogações pelos dados do objeto
				preparador.setString(1, endereco.getBairro());
				preparador.setString(2, endereco.getRua());
				preparador.setInt(3, endereco.getNum());
				preparador.setString(4,endereco.getCidade());
				preparador.setString(5,endereco.getCEP());
				
				//Executa o comando no banco
				preparador.execute();
				preparador.close();
				System.out.println("CADASTRADO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		public void alterar(Endereco endereco){
			//Montando sql
			String sql = "update endereco set bairro=?, rua=?, num=?, cidade=?, cep=? where id_endereco=?";
			//Constroe o PreparedStatement passando o sql
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Substituindo as interogações pelos dados do objeto
				preparador.setString(1, endereco.getBairro());
				preparador.setString(2, endereco.getRua());
				preparador.setInt(3, endereco.getNum());
				preparador.setString(4,endereco.getCidade());
				preparador.setString(5,endereco.getCEP());
				preparador.setInt(6, endereco.getId_endereco());
				
				
				//Executa o comando no banco
				preparador.execute();
				preparador.close();
				System.out.println("ALTERADO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		public void excluir(Endereco endereco){
			//Montando sql
			String sql = "delete from endereco where id_endereco=?";
			//Constroe o PreparedStatement passando o sql
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Substituindo as interogações pelos dados do objeto
				preparador.setInt(1, endereco.getId_endereco());
				
				
				//Executa o comando no banco
				preparador.execute();
				preparador.close();
				System.out.println("EXCLUIDO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		
		public ArrayList<Endereco> listarTodos(){
			//Montando a consulta SQL
			String sql = "select * from endereco";
			//Constroe o PreparedStatement passando o sql
			ArrayList<Endereco> lista = new ArrayList<>();
			try {
				//Executando a consulta SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Executa uma consulta atravez do executeQuery...E em seguida guarda essa consulta dentro do resultSet
				
				ResultSet resultado= preparador.executeQuery();
				/*Faz uma varredura em todas as linhas retornadas 
				E captura seus dados.*/
				
				
				while(resultado.next()){
					/*Para cada linha retornada um novo objeto será criado
					para armazenar esses dados.*/
					Endereco endereco = new Endereco();
					
					/*Capturando os valores dos resultados
					 * e os atribuindo para cada objeto*/
					 
					endereco.setId_endereco(resultado.getInt("id_endereco"));//Pega o valor da coluna
					endereco.setBairro(resultado.getString("bairro"));
					endereco.setRua(resultado.getString("rua"));
					endereco.setNum(resultado.getInt("num"));
					endereco.setCidade(resultado.getString("cidade"));
					endereco.setCEP(resultado.getString("CEP"));
					lista.add(endereco);
				}
				preparador.close();
				System.out.println("RETORNANDO LISTA COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return lista;
			
			
			
		}


}
