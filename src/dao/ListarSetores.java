package dao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import funcoes.ColorRender;
import modelo.Setores;

public class ListarSetores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir, btExcluir, btEditar, btAtualizar, btSetarCotas;
	private DefaultTableModel modelo = new DefaultTableModel();

	public ListarSetores() {
		criaJTable();
		criaPanel();
	}

	public void criaPanel() {
		btAtualizar = new JButton("Atualizar");
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		btSetarCotas = new JButton("Zerar Cotas");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		painelBotoes.add(btAtualizar);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelBotoes.add(btSetarCotas);

		setBotoes(false, false, false, true, true);

		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		add(painelFundo);
		setSize(900, 700);
		setVisible(true);
		btAtualizar.addActionListener(new BtAtualizarListener());
		btInserir.addActionListener(new BtInserirCotasListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
		btSetarCotas.addActionListener(new BtSetarCotas());
	}

	private void criaJTable() {
		tabela = new JTable(modelo) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};

		tabela.setPreferredScrollableViewportSize(new Dimension(650, 480));
		tabela.setDefaultRenderer(Object.class, new ColorRender(3, 0));

		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Disponivel");
		modelo.addColumn("Usados");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(60);
		pesquisar(modelo);

		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (arg0.getValueIsAdjusting()) {
					setBotoes(true, true, true, true, true);
				}

			}
		});
	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		DAOSetores dao = new DAOSetores();
		for (Setores setores : dao.getSetores()) {
			modelo.addRow(new Object[] { setores.getId(), setores.getNome(), setores.getCotasDisponiveis(),
					setores.getCotasUsadas() });
		}
	}

	public void setBotoes(boolean btinserir, boolean btexclui, boolean bteditar, boolean btatualizar,
			boolean btsetarcotas) {
		btInserir.setEnabled(btinserir);
		btExcluir.setEnabled(btexclui);
		btEditar.setEnabled(bteditar);
		btAtualizar.setEnabled(btatualizar);
		btSetarCotas.setEnabled(btsetarcotas);
	}

	private class BtInserirCotasListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();

			DefaultTableModel tableMode = (DefaultTableModel) tabela.getModel();
			int row = tabela.getSelectedRow();
			int c = (int) tableMode.getValueAt(row, 3);

			if (linhaSelecionada >= 0) {
				int idBolsista = (int) tabela.getValueAt(linhaSelecionada, 0);
				int qntdNova = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade utilizada: "));

				int qntdAtualizar = c + qntdNova;

				DAOSetores dao = new DAOSetores();
				dao.addCota(idBolsista, qntdAtualizar);
				setBotoes(false, false, false, true, true);
				pesquisar(modelo);

			} else {
				JOptionPane.showMessageDialog(null, "é necessario selecionar uma linha");
			}
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idSetor = (int) tabela.getValueAt(linhaSelecionada, 0);
				EditarSetor ib = new EditarSetor(idSetor);
			} else {
				JOptionPane.showMessageDialog(null, "é necessario selecionar uma linha");
			}
		}
	}

	private class BtAtualizarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			pesquisar(modelo);
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idSetor = (int) tabela.getValueAt(linhaSelecionada, 0);
				DAOSetores dao = new DAOSetores();
				dao.remover(idSetor);
				modelo.removeRow(linhaSelecionada);
				setBotoes(false, false, false, true, true);
			} else {
				JOptionPane.showMessageDialog(null, "é necessario selecionar uma linha");
			}
		}
	}

	private class BtSetarCotas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (JOptionPane.showConfirmDialog(null, "Deseja realmente zerar as cotas ?")) {
			case 0:
				for (int linha = 0; linha < tabela.getRowCount(); linha++) {
					// int valorColuna = (int) tabela.getModel().getValueAt(linha, 5);
					DAOSetores dao = new DAOSetores();
					dao.zerarCota(linha);
					pesquisar(modelo);
				}
				break;
			}
		}
	}

}
