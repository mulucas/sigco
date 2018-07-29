package gui;

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

import dao.BolsistaDAO;
import modelo.Bolsista;

public class FormBolsista extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;
	public JTextField tfNome;
	public JTextField tfMatricula;
	private JButton btAdiconar, btLimpar;
	private JComboBox cbCurso;

	// --------------------------------METODO-PARA-AS-ACÕES-DOS-BOTÕES---------------------------------------
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btAdiconar) {
			Bolsista bolsista = new Bolsista();
			bolsista.setNome(tfNome.getText());
			bolsista.setMatricula(tfMatricula.getText());
			bolsista.setCurso(cbCurso.getSelectedItem().toString());

			if ((tfNome.getText().isEmpty()) || (tfMatricula.getText().isEmpty())
					|| (cbCurso.getSelectedItem().equals("SELECIONAR..."))) {
				JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
			} else {
				BolsistaDAO dao = new BolsistaDAO();
				dao.adiciona(bolsista);
				JOptionPane.showMessageDialog(null, "Usuário " + tfNome.getText() + " inserido com sucesso! ");
				limparCampos(pnForm);
			}
		} else if (o == btLimpar) {
			limparCampos(pnForm);
		}
	}

	// --------------------------------METODO-PARA-LIMPAR-OS-CAMPOS---------------------------------------
	private void limparCampos(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}

	public FormBolsista() {
		// --------------------------------CONFIG-DA-JANELA---------------------------------------
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

		JLabel lbCadastrarBolsista = new JLabel("CADASTRAR BOLSISTA");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 222, 14);
		contentPane.add(lbCadastrarBolsista);

		JLabel lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 29, 78, 29);
		pnForm.add(lbNome);

		JLabel lbMatricula = new JLabel("MATRICULA:");
		lbMatricula.setBounds(32, 79, 78, 29);
		pnForm.add(lbMatricula);

		JLabel lbCurso = new JLabel("CURSO:");
		lbCurso.setBounds(32, 127, 78, 29);
		pnForm.add(lbCurso);

		// --------------------------------JComboBox---------------------------------------
		cbCurso = new JComboBox();
		cbCurso.setModel(
				new DefaultComboBoxModel(new String[] { "SELECIONAR...", "INFORMATICA", "QUIMICA", "RP", "BIOLOGIA" }));
		cbCurso.setBounds(120, 131, 170, 20);
		pnForm.add(cbCurso);

		// --------------------------------JTextField---------------------------------------
		tfNome = new JTextField();
		tfNome.setBounds(120, 33, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(120, 83, 170, 20);
		pnForm.add(tfMatricula);
		tfMatricula.setColumns(10);

		// --------------------------------JButton---------------------------------------
		btAdiconar = new JButton("ADICIONAR");
		btAdiconar.setBounds(45, 194, 117, 23);
		btAdiconar.addActionListener(this);
		pnForm.add(btAdiconar);

		btLimpar = new JButton("LIMPAR");
		btLimpar.setBounds(168, 194, 117, 23);
		btLimpar.addActionListener(this);
		pnForm.add(btLimpar);
	}
}