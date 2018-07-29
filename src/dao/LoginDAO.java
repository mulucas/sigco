package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conecao.ConnectionFactory;
import gui.MenuPrincipal;

public class LoginDAO {

	public void acessarSistema(JTextField nome, JPasswordField senha) {
		try {
			Connection fab = new ConnectionFactory().getConnection();
			PreparedStatement stmt = fab.prepareStatement("select * from login");
			ResultSet rs = stmt.executeQuery();
			boolean quebra = false;
			while (rs.next()) {
				if (nome.getText().equals(rs.getString("nome")) && senha.getText().equals(rs.getString("senha"))) {
					quebra = true;
					break;
				} else {
					quebra = false;
				}
			}
			if (quebra) {
				MenuPrincipal.abrir();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!");
			}
			rs.close();
			stmt.close();
			fab.close();

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ao entrar deu erro!" + erro);
		}
	}
}
