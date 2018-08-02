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
import gui.MenuPrincipal;
import modelo.Bolsista;

public class ListarBolsista extends JPanel{

	private static final long serialVersionUID = 1L;
	private Container contentPane;
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir, btExcluir, btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();
 
    public ListarBolsista() {
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
        btInserir.addActionListener(new BtInserirBolsistaListener());
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        
        tabela.setPreferredScrollableViewportSize(new Dimension(650, 480));
        tabela.setDefaultRenderer(Object.class, new ColorRender(2, 0));
        
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Matricula");
        modelo.addColumn("Curso");
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
        BolsistaDAO dao = new BolsistaDAO();
        for (Bolsista bolsistas : dao.getBolsista()) {
            modelo.addRow(new Object[]{bolsistas.getId(), bolsistas.getNome(), bolsistas.getMatricula(), bolsistas.getCurso(), bolsistas.getCotasDisponiveis(), bolsistas.getCotasUsadas()});
        }
    }
 
    private class BtInserirBolsistaListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
        	int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			
			DefaultTableModel tableMode = (DefaultTableModel) tabela.getModel();
			int row = tabela.getSelectedRow();
			int c = (int) tableMode.getValueAt(row, 5);
			
			if (linhaSelecionada >= 0) {
				int idBolsista = (int) tabela.getValueAt(linhaSelecionada, 0);
				int qntdNova = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantidade de utilizada: "));
				
				int qntdAtualizar = c+qntdNova;
				
				BolsistaDAO dao = new BolsistaDAO();
				dao.addCota(idBolsista, qntdAtualizar);
				
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
                int idBolsista = (int) tabela.getValueAt(linhaSelecionada, 0);
                AtualizarBolsista ib = new AtualizarBolsista(modelo, idBolsista, linhaSelecionada);
                /*contentPane.removeAll();
                contentPane.add(ib);
                contentPane.validate();*/
                ib.setVisible(true);
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
                int idBolsista= (int) tabela.getValueAt(linhaSelecionada, 0);
                BolsistaDAO dao = new BolsistaDAO();
                dao.remover(idBolsista);
                modelo.removeRow(linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }
}