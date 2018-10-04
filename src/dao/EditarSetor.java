package dao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Bolsista;
import modelo.Setores;

public class EditarSetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;

	JLabel lbCadastrarBolsista, lbNome, lbMatricula, lbCurso,lbId;
	private JTextField tfId, tfNome, tfMatricula;
	private JButton btAlterar, btLimpar;

	Setores setores;

	public EditarSetor(int id) {
		DAOSetores dao = new DAOSetores();
		setores = dao.getSetorById(id);
		
		criaJanela();
		setVisible(true);

		tfId.setText(Integer.toString(setores.getId()));
		tfNome.setText(setores.getNome());
	}

	public void criaJanela() {
		setTitle("Formulário Setor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// --------------------------------JPANEL---------------------------------------
		pnForm = new JPanel();
		pnForm.setBackground(Color.WHITE);
		pnForm.setBounds(0, 61, 320, 241);
		contentPane.add(pnForm);
		pnForm.setLayout(null);

		lbCadastrarBolsista = new JLabel("CADASTRAR SETOR");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 222, 14);
		contentPane.add(lbCadastrarBolsista);

		lbId = new JLabel("ID:");
		lbId.setBounds(32, 13, 170, 20);
		pnForm.add(lbId);
		
		lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 48, 78, 29);
		pnForm.add(lbNome);

		// --------------------------------JTextField---------------------------------------
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setBounds(120, 13, 170, 20);
		pnForm.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(120, 53, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);

		// --------------------------------JButton---------------------------------------
		btAlterar = new JButton("ALTERAR");
		btAlterar.setBounds(45, 194, 117, 23);
		btAlterar.addActionListener(new BtAlterarListener());
		pnForm.add(btAlterar);

		btLimpar = new JButton("LIMPAR");
		btLimpar.setBounds(168, 194, 117, 23);
		btLimpar.addActionListener(new BtLimparListener());
		pnForm.add(btLimpar);
	}

	private class BtAlterarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Setores setores = new Setores();
			setores.setId(Integer.parseInt(tfId.getText()));
			setores.setNome(tfNome.getText());
			
			if (tfNome.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
			} else {
				DAOSetores dao = new DAOSetores();
				dao.atualizar(setores);
				dispose();
			}
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			limparCampos(pnForm);
		}
	}

	private void limparCampos(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}

}
