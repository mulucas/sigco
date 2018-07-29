package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conecao.*;
import modelo.Professor;

public class ProfessorDAO {

	private Connection connection;

	public ProfessorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Professor professor) {
		int c = Integer.parseInt(professor.getQntdAlunos());
		int d = c*12;
		String vc = Integer.toString(d);
		
		String sql = "INSERT INTO professor(nome,matricula,numeroAlunos,cotasDisponiveis) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getMatricula());
			stmt.setString(3, professor.getQntdAlunos());
			stmt.setString(4, vc);
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void atualizar(Professor professor) {
		if (professor != null) {
			String sql = "UPDATE Professor SET NOME=?, MATRICULA=?, numeroAlunos=? WHERE ID=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, professor.getNome());
				stmt.setString(2, professor.getMatricula());
				stmt.setString(3, professor.getQntdAlunos());
				stmt.setInt(4, professor.getId());

				stmt.execute();
				JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
				stmt.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao atualizar Professor no banco de" + "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O Professor enviado por parâmetro está vazio");
		}
	}

	public void remover(int id) {
		String sql = "DELETE FROM Professor WHERE ID =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir Professor do banco de dados " + e.getMessage());
		}
	}
	public void addCota(int id, int cotas) {
		
		String sql = "UPDATE Professor SET cotasUsadas=? WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cotas);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao add cotas no Professor do banco de dados " + e.getMessage());
		}
	}

	public List<Professor> getProfessor() {
		ArrayList<Professor> professores = new ArrayList<Professor>();
		String sql = "SELECT * FROM PROFESSOR";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();

				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setQntdAlunos(rs.getString("numeroAlunos"));
				professor.setCotasUsadas(rs.getString("cotasUsadas"));
				professor.setCotasDisponiveis(rs.getString("cotasDisponiveis"));
				professores.add(professor);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Professor" + e.getMessage());
		}
		return professores;
	}

	public Professor getProfessorById(int id) {
		Professor professor = new Professor();
		String sql = "SELECT * FROM Professor WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setQntdAlunos(rs.getString("numeroAlunos"));
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Professor pelo id" + e.getMessage());
		}
		return professor;
	}
}
