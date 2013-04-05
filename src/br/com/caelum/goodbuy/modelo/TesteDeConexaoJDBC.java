package br.com.caelum.goodbuy.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexaoJDBC {
	
	public Connection getConexao(){
		
		String url = "jdbc:mysql://localhost:3306/fj28";
		String usuario = "root";
		String senha = "";
		
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		TesteDeConexaoJDBC teste = new TesteDeConexaoJDBC();
		if (teste.getConexao() != null)
			System.out.println("Deu certo");
		else
			System.out.println("Deu errado");
	}
	
}
