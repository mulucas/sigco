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

public class EditarBolsista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;

	JLabel lbCadastrarBolsista, lbNome, lbMatricula, lbCurso,lbId;
	private JTextField tfId, tfNome, tfMatricula;
	private JButton btAlterar, btLimpar;
	private JComboBox cbCurso;

	Bolsista bolsista;

	public EditarBolsista(int id) {
		DAOBolsista dao = new DAOBolsista();
		bolsista = dao.getBolsistaById(id);
		
		criaJanela();
		setVisible(true);

		tfId.setText(Integer.toString(bolsista.getId()));
		tfNome.setText(bolsista.getNome());
		tfMatricula.setText(bolsista.getMatricula());

	}

	public void criaJanela() {
		setTitle("Formulário bolsista");
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

		lbCadastrarBolsista = new JLabel("CADASTRAR BOLSISTA");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 222, 14);
		contentPane.add(lbCadastrarBolsista);

		lbId = new JLabel("ID:");
		lbId.setBounds(32, 13, 170, 20);
		pnForm.add(lbId);
		
		lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 48, 78, 29);
		pnForm.add(lbNome);

		lbMatricula = new JLabel("MATRICULA:");
		lbMatricula.setBounds(32, 85, 78, 29);
		pnForm.add(lbMatricula);

		lbCurso = new JLabel("CURSO:");
		lbCurso.setBounds(32, 127, 78, 29);
		pnForm.add(lbCurso);

		// --------------------------------JComboBox---------------------------------------
		cbCurso = new JComboBox();
		cbCurso.setModel(
				new DefaultComboBoxModel(new String[] { "SELECIONAR...", "INFORMATICA", "QUIMICA", "RP", "BIOLOGIA" }));
		cbCurso.setBounds(120, 131, 170, 20);
		pnForm.add(cbCurso);

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


		tfMatricula = new JTextField();
		tfMatricula.setBounds(120, 89, 170, 20);
		pnForm.add(tfMatricula);
		tfMatricula.setColumns(10);

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
			Bolsista bolsista = new Bolsista();
			bolsista.setId(Integer.parseInt(tfId.getText()));
			bolsista.setNome(tfNome.getText());
			bolsista.setMatricula(tfMatricula.getText());
			bolsista.setCurso(cbCurso.getSelectedItem().toString());

			if ((tfNome.getText().isEmpty()) || (tfMatricula.getText().isEmpty())
					|| (cbCurso.getSelectedItem().equals("SELECIONAR..."))) {
				JOptionPane.showMessageDialog(null, "Os campos n�o podem retornar vazios");
			} else {
				DAOBolsista dao = new DAOBolsista();
				dao.atualizar(bolsista);
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
