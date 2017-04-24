package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Tendencias;

public class TendenciaDao {
	
	private Connection con = Conexao.getConnection();
	
	public void Cadastar(Tendencias tendencia){
		
		String sql = "insert into nova_Tendencia (nome) values (?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,tendencia.getNome());
			
			preparador.execute();
			preparador.close();
			System.out.println("Tendencia Cadastrada ");
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
					
		}
		public void alterar(Tendencias tendencia){
			String sql = "Update nova_Tendencia set nome=? where codigo=?";
			
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,tendencia.getNome());
			preparador.setInt(2,tendencia.getCodigo());
			
			
			
			preparador.execute();
			preparador.close();
			System.out.println("Alterado com sucesso");
			
				} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		public void excluir(Tendencias tendencia){
			String sql = "delete from nova_Tendencia where codigo=?";
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setInt(1,tendencia.getCodigo());
				
				preparador.execute();
				preparador.close();
				System.out.println("Excluido com sucesso ");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public ArrayList<Tendencias>listarTodos(){
			String sql = "select * from nova_tendencia";
			
			ArrayList<Tendencias> lista = new ArrayList<>();
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()){
					
					Tendencias tendencia = new Tendencias();
					
					tendencia.setCodigo(resultado.getInt("codigo"));
					tendencia.setNome(resultado.getString("nome"));
					tendencia.setId_cliente(resultado.getInt("id_cliente"));
					tendencia.setId_usuario_adm(resultado.getInt("id_usuario_adm"));
					
					lista.add(tendencia);
					
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
			

			
		}
		
}
