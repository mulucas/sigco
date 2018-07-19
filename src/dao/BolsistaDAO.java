package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conecao.*;
import modelo.Bolsista;

public class BolsistaDAO {

	private Connection connection;

	public BolsistaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Bolsista bolsista) {
		String sql = "INSERT INTO bolsista(nome,matricula,curso, cotasUsadas) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, bolsista.getNome());
			stmt.setString(2, bolsista.getMatricula());
			stmt.setString(3, bolsista.getCurso());
			stmt.setString(4, "0");
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void atualizar(Bolsista bolsista) {
		if (bolsista != null) {
			String sql = "UPDATE BOLSISTA SET NOME=?, MATRICULA=?, CURSO=? WHERE ID=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, bolsista.getNome());
				stmt.setString(2, bolsista.getMatricula());
				stmt.setString(3, bolsista.getCurso());

				stmt.execute();
				JOptionPane.showMessageDialog(null, "BOLSISTA alterado com sucesso");
				stmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao atualizar BOLSISTA no banco de" + "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O BOLSISTA enviado por parâmetro está vazio");
		}
	}

	public void remover(int id) {
		String sql = "DELETE FROM BOLSISTA WHERE ID =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir BOLSISTA do banco de dados " + e.getMessage());
		}
	}

	public List<Bolsista> getBolsista() {
		ArrayList<Bolsista> bolsistas = new ArrayList<Bolsista>();
		String sql = "SELECT * FROM BOLSISTA";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Bolsista bolsista = new Bolsista();

				bolsista.setId(rs.getInt("id"));
				bolsista.setNome(rs.getString("nome"));
				bolsista.setMatricula(rs.getString("matricula"));
				bolsista.setCurso(rs.getString("curso"));
				bolsista.setCotasUsadas(rs.getInt("cotasUsadas"));
				bolsista.setCotasDisponiveis(rs.getInt("cotasDisponiveis"));
				bolsistas.add(bolsista);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar BOLSISTA" + e.getMessage());
		}
		return bolsistas;
	}

	public Bolsista getBolsistaById(int id) {
		Bolsista bolsista = new Bolsista();
		String sql = "SELECT * FROM BOLSISTA WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				bolsista.setId(rs.getInt("id"));
				bolsista.setNome(rs.getString("nome"));
				bolsista.setMatricula(rs.getString("matricula"));
				bolsista.setCurso(rs.getString("curso"));
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar BOLSISTA pelo id" + e.getMessage());
		}
		return bolsista;
	}
}
