package dao;
import java.sql.*;
public class Productdao {
	private Connection conexao;
	
	public Productdao() {
		conexao=null;
	}
	public boolean conectar() {
		String driverName ="org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url ="jdbc:postgresql://" + serverName +":" +porta+"/" +mydatabase;
		String username ="brunoti2cc";
		String password = "ti@cc";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			System.out.println("conexão efetuada com sucesso");
		}catch (ClassNotFoundException e) {
			System.err.println("Conexão não efetuada--Driver não encoantrado"+e.getMessage());
		}catch(SQLException e) {
			System.err.println("Conexão não efetuada-"+e.getMessage());
		}
		return status;
	}
	public boolean inserirUsuario(Usuario usuario) {
		boolean status =false;
		try {
			Statement st =conexao.createStatement();
			st.executeUpdate("INSERT INTO: usuario (codigo, login, senha, sexo) "  + "VALUES(" +usuario.getCodigo()+", "+ usuario.getLogin()+", "+usuario.getSenha()+ ", "+ usuario.getSexo()+ ");");
			st.close();
			status = true;
		} catch(SQLException u) {
			throw new RuntimeExpection(u);
		}
		return status;
	}
	
}
