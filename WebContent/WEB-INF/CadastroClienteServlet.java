import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JScrollBar;
import dao.ClienteDao;
import modelo.Cliente;
import conexao.ConnectionFactory;

@WebServlet("/CadastroClienteServlet")
public class CadastroClienteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//requisitando paramentros do formulario
		String nome = request.getParameter("nomecompleto");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		String cpf = request.getParameter("cpf");
		String sexo = request.getParameter("sexo");
		String data = request.getParameter("data");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");

		//criando Usu�rio
		Cliente cliene = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setCPF(cpf);
		cliente.setSexo(sexo);
		cliente.setData(data);
		cliente.setTelefone(telefone);
		cliente.setCelular(celular);
		cliente.setCep(cep);
		cliente.setEndereco(endereco);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setCidade(cidade);
		cliente.setEstado(estado);
		cliente.setPais(pais);
		
		// criando sess�o
		HttpSession session = request.getSession(true);
		session.setAttribute("autorizado", cliente);

		ClienteDAO cadastrar;
		try {
			cadastrar = new ClienteDao();
			if(cadastrar.insertCliente(cliente)){
				response.sendRedirect("inicial-cliente.jsp");
			}
			//jsp de erro.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
