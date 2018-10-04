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

public class DAOBolsista {

	private Connection connection;

	public DAOBolsista() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Bolsista bolsista) {
		String sql = "INSERT INTO bolsistas(nome,matricula,curso, cotasUsadas,cotasDisponiveis) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, bolsista.getNome());
			stmt.setString(2, bolsista.getMatricula());
			stmt.setString(3, bolsista.getCurso());
			stmt.setString(4, "0");
			stmt.setInt(5, bolsista.getCotasDisponiveis());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void atualizar(Bolsista bolsista) {
		if (bolsista != null) {
			String sql = "UPDATE BOLSISTAS SET NOME=?, MATRICULA=?, CURSO=? WHERE ID=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, bolsista.getNome());
				stmt.setString(2, bolsista.getMatricula());
				stmt.setString(3, bolsista.getCurso());
				stmt.setInt(4, bolsista.getId());
				stmt.execute();
				JOptionPane.showMessageDialog(null, "BOLSISTA alterado com sucesso");
				stmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao atualizar BOLSISTA no banco de" + "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O BOLSISTA enviado por par�metro est� vazio");
		}
	}

	public void remover(int id) {
		String sql = "DELETE FROM BOLSISTAS WHERE ID =?";
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
		String sql = "SELECT * FROM BOLSISTAS";
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
		String sql = "SELECT * FROM BOLSISTAS WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
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
			JOptionPane.showMessageDialog(null, "Erro ao listar BOLSISTA pelo id " + e.getMessage());
		}
		return bolsista;
	}

	public void addCota(int idBolsista, int qntd) {
		String sql = "UPDATE bolsistas SET cotasUsadas=? WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, qntd);
			stmt.setInt(2, idBolsista);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao add cotas no bolsista do banco de dados " + e.getMessage());
		}
	}
	public void zerarCota(int linha ) {
		String sql = "UPDATE bolsistas SET cotasUsadas=? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao zerar as cotas dos professores" + e.getMessage());
		}
	}
}