package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conecao.ConnectionFactory;
import modelo.Setores;

public class DAOSetores {
	private Connection connection;

	public DAOSetores() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Setores setores) {
		String sql = "INSERT INTO setores(nome,cotasDisponiveis,cotasUsadas) VALUES(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, setores.getNome());
			stmt.setInt(2, setores.getCotasDisponiveis());
			stmt.setString(3, "0");
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void atualizar(Setores setores) {
		if (setores != null) {
			String sql = "UPDATE setores SET NOME=? WHERE ID=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, setores.getNome());
				stmt.setInt(2, setores.getId());
				stmt.execute();
				JOptionPane.showMessageDialog(null, "SETOR alterado com sucesso");
				stmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao atualizar SETOR no banco de" + "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O SETOR enviado por parametro está vazio");
		}
	}

	public void remover(int id) {
		String sql = "DELETE FROM SETORES WHERE ID =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir SETOR do banco de dados " + e.getMessage());
		}
	}

	public List<Setores> getSetores() {
		ArrayList<Setores> bolsistas = new ArrayList<Setores>();
		String sql = "SELECT * FROM setores";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Setores bolsista = new Setores();

				bolsista.setId(rs.getInt("id"));
				bolsista.setNome(rs.getString("nome"));
				bolsista.setCotasUsadas(rs.getInt("cotasUsadas"));
				bolsista.setCotasDisponiveis(rs.getInt("cotasDisponiveis"));
				bolsistas.add(bolsista);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar SETOR" + e.getMessage());
		}
		return bolsistas;
	}

	public Setores getSetorById(int id) {
		Setores bolsista = new Setores();
		String sql = "SELECT * FROM SETORES WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs = stmt.executeQuery();
			while (rs.next()) {
				bolsista.setId(rs.getInt("id"));
				bolsista.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar SETOR pelo id " + e.getMessage());
		}
		return bolsista;
	}

	public void addCota(int idSetor, int qntd) {
		String sql = "UPDATE SETORES SET cotasUsadas=? WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, qntd);
			stmt.setInt(2, idSetor);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao add cotas no SETOR do banco de dados " + e.getMessage());
		}
	}
	public void zerarCota(int linha ) {
		String sql = "UPDATE SETORES SET cotasUsadas=? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao zerar as cotas dos SETORES" + e.getMessage());
		}
	}
}
