package fafica.pi.projeto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.pi.projeto.entidades.Usuario_ADM;
import fafica.pi.projeto.jdbc.Usuario_Adm_Dao;

/**
 * Servlet implementation class controllerSistema
 */
@WebServlet("/kts")
public class controllerSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public controllerSistema() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String nome = request.getParameter("textnome");
		String login = request.getParameter("textlogin");
		String senha = request.getParameter("textsenha");
		String nomeSalao = request.getParameter("textnomesalao");
		String endereco = request.getParameter("textendereco");
		String telefone = request.getParameter("texttelefone");
		
		Usuario_ADM adm = new Usuario_ADM();
		adm.setNome(nome);
		adm.setLogin(login);
		adm.setSenha(senha);
		adm.setNomeSalao(nomeSalao);
		adm.setEndereco(endereco);
		adm.setTelefone(telefone);
		
		Usuario_Adm_Dao usuDao = new Usuario_Adm_Dao();
		usuDao.cadastrar(adm);
		
		PrintWriter saida = response.getWriter();
		saida.print("cadastrado com sucesso!!!");
	}

}
