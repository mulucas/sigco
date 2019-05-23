package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conecao.ConnectionFactory;
import gui.Inicio;

public class DAOLogin {

	private Connection connection = new ConnectionFactory().getConnection();;
	
	public void adicionaUsuario(JTextField nome, JTextField senha) {
		String sql = "INSERT INTO login(nome,senha) VALUES(?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome.getText());
			stmt.setString(2, senha.getText());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	public boolean acessarSistema(JTextField nome, JPasswordField senha) {
		boolean verificaUsuarioNoBanco = false;
		try {
			Connection fab = new ConnectionFactory().getConnection();
			PreparedStatement stmt = fab.prepareStatement("select * from login");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (nome.getText().equals(rs.getString("nome")) && senha.getText().equals(rs.getString("senha"))) {
					verificaUsuarioNoBanco = true;
					break;
				} else {
					verificaUsuarioNoBanco = false;
				}
			}
			if (verificaUsuarioNoBanco) {
				Inicio.abrir();
			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorreto!");
			}
			rs.close();
			stmt.close();
			fab.close();

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ao entrar deu erro!" + erro);
		}
		return verificaUsuarioNoBanco;
	}
}
