package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection getConexao(){
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "12345";
		String nomeBancoDados = "ifesta";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
