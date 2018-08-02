package dao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import funcoes.ColorRender;
import modelo.Professor;

public class ListarProfessor extends JPanel {

	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir, btExcluir, btEditar;
	private DefaultTableModel modelo = new DefaultTableModel();

	public ListarProfessor() {
		criaJTable();
		criaPanel();
	}

	public void criaPanel() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		add(painelFundo);
		setSize(900, 700);
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
	}

	private void criaJTable() {
		tabela = new JTable(modelo);
	
		tabela.setPreferredScrollableViewportSize(new Dimension(650, 480));
		tabela.setDefaultRenderer(Object.class, new ColorRender(1,0));

		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Matricula");
		modelo.addColumn("Nº de Alunos");
		modelo.addColumn("Disponivel");
		modelo.addColumn("Usados");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(60);
		pesquisar(modelo);
	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ProfessorDAO dao = new ProfessorDAO();
		for (Professor prof : dao.getProfessor()) {
			modelo.addRow(new Object[] { prof.getId(), prof.getNome(), prof.getMatricula(), prof.getQntdAlunos(),prof.getCotasDisponiveis(), prof.getCotasUsadas() });
		}
	}

	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idProfessor = (int) tabela.getValueAt(linhaSelecionada, 0);
				int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de utilizada: "));
				ProfessorDAO dao = new ProfessorDAO();
				dao.addCota(idProfessor, op);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idProfessor = (int) tabela.getValueAt(linhaSelecionada, 0);
				AtualizarBolsista ib = new AtualizarBolsista(modelo, idProfessor, linhaSelecionada);
				/*contentPane.removeAll();
				contentPane.add(ib);
				contentPane.validate();*/
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idProfessor = (int) tabela.getValueAt(linhaSelecionada, 0);
				ProfessorDAO dao = new ProfessorDAO();
				dao.remover(idProfessor);
				modelo.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}
}