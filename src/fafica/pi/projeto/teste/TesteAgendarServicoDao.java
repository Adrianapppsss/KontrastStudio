package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.AgendarServico;
import fafica.pi.projeto.jdbc.AgendarServicoDao;

public class TesteAgendarServicoDao {

	public static void main(String[] args) {
		
		AgendarServico agenda = new AgendarServico();
		
		agenda.setId_agendamento(1);
		agenda.setId_cliente(18);
		agenda.setId_profissional(4);
		agenda.setData(null);
		
		
		AgendarServicoDao agendaDao = new AgendarServicoDao();
		agendaDao.cadastrar(agenda);
	}

}
