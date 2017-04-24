package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Servico_Salao;


public class ServicoSalaoDao {

	 
		private Connection con = Conexao.getConnection();
		
		public void cadastrar(Servico_Salao servico_Salao){
			
			String sql = "insert into servico_salao(cabelos, depilacaomasculina, depilacaofeminina, manicure_pedicure, servico_especial, valor_servico) values(?,?,?,?,?,?)";
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setString(1, servico_Salao.getCabelos());
				preparador.setString(2, servico_Salao.getDepilacaoMasculina());
				preparador.setString(3, servico_Salao.getDepilacaoFeminina());
				preparador.setString(4, servico_Salao.getManicure_pedicure());
				preparador.setString(5, servico_Salao.getServico_especial());
				preparador.setDouble(6, servico_Salao.getValor_servico());
				
				
				
				preparador.execute();
				preparador.close();
				System.out.println("CADASTRADO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		public void alterar(Servico_Salao servico_Salao){
			
			String sql = "update servico_salao set cabelos=?, depilacaomasculina=?,depilacaofeminina=?,manicure_pedicure=?,servico_especial=?, valor_servico=? where id_servico=?";
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setString(1, servico_Salao.getCabelos());
				preparador.setString(2, servico_Salao.getDepilacaoFeminina());
				preparador.setString(3, servico_Salao.getDepilacaoMasculina());
				preparador.setString(4, servico_Salao.getManicure_pedicure());
				preparador.setString(5, servico_Salao.getServico_especial());
				preparador.setDouble(6,servico_Salao.getValor_servico());
				preparador.setInt(7,servico_Salao.getId_Servico());
				
				
				preparador.execute();
				preparador.close();
				System.out.println("ALTERADO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		public void excluir(Servico_Salao servico_Salao){
			
			String sql = "delete from servico_salao where id_salao=?";
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setInt(1,servico_Salao.getId_Servico());
				
				
				//Executa o comando no banco
				preparador.execute();
				preparador.close();
				System.out.println("EXCLUIDO COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
		}
		
		public ArrayList<Servico_Salao> listarTodos(){
			//Montando a consulta SQL
			String sql = "select * from servico_salao";
			//Constroe o PreparedStatement passando o sql
			ArrayList<Servico_Salao> lista = new ArrayList<>();
			try {
				//Executando a consulta SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Executa uma consulta atravez do executeQuery...E em seguida guarda essa consulta dentro do resultSet
				
				ResultSet resultado= preparador.executeQuery();
				/*Faz uma varredura em todas as linhas retornadas 
				E captura seus dados.*/
				
				
				while(resultado.next()){
					Servico_Salao servico = new Servico_Salao();
					
					/*Capturando os valores dos resultados
					 * e os atribuindo para cada objeto*/
					 
					servico.setId_Servico(resultado.getInt("id_salao"));//Pega o valor da coluna
					servico.setCabelos(resultado.getString("cabelos"));
					servico.setDepilacaoMasculina(resultado.getString("depilacaoMasculina"));
					servico.setDepilacaoFeminina(resultado.getString("depilacaoFeminina"));
					servico.setManicure_pedicure(resultado.getString("manicure_pedicure"));
					servico.setServico_especial(resultado.getString("servico_especial"));
					servico.setValor_servico(resultado.getDouble("valor_servico"));
					
					lista.add(servico);
				}
				preparador.close();
				System.out.println("RETORNANDO LISTA COM SUCESSO!");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return lista;
			
			
			
		}


}
