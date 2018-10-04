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

import dao.DAOBolsista;
import modelo.Bolsista;

public class FormBolsista extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;
	public JTextField tfNome;
	public JTextField tfMatricula, tfCotas;
	private JButton btAdiconar, btLimpar;
	private JComboBox cbCurso;

	// --------------------------------METODO-PARA-AS-AC�ES-DOS-BOT�ES---------------------------------------
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btAdiconar) {
			Bolsista bolsista = new Bolsista();
			bolsista.setNome(tfNome.getText());
			bolsista.setMatricula(tfMatricula.getText());
			int valor = Integer.parseInt(tfCotas.getText());
			bolsista.setCotasDisponiveis(valor);
			bolsista.setCurso(cbCurso.getSelectedItem().toString());

			if ((tfNome.getText().isEmpty()) || (tfCotas.getText().isEmpty()) || (tfMatricula.getText().isEmpty())
					|| (cbCurso.getSelectedItem().equals("SELECIONAR..."))) {
				JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
			} else {
				DAOBolsista dao = new DAOBolsista();
				dao.adiciona(bolsista);
				JOptionPane.showMessageDialog(null, "Bolsista " + tfNome.getText() + " inserido com sucesso! ");
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
		lbNome.setBounds(32, 10, 78, 29);
		pnForm.add(lbNome);

		JLabel lbMatricula = new JLabel("MATRICULA:");
		lbMatricula.setBounds(32, 50, 78, 29);
		pnForm.add(lbMatricula);
		
		JLabel qntdCotas = new JLabel("COTAS:");
		qntdCotas.setBounds(32, 90, 78, 29);
		pnForm.add(qntdCotas);

		JLabel lbCurso = new JLabel("CURSO:");
		lbCurso.setBounds(32, 130, 78, 29);
		pnForm.add(lbCurso);

		// --------------------------------JComboBox---------------------------------------
		cbCurso = new JComboBox();
		cbCurso.setModel(
				new DefaultComboBoxModel(new String[] { "SELECIONAR...", "INFORMATICA", "QUIMICA", "RP", "BIOLOGIA" }));
		cbCurso.setBounds(120, 131, 170, 20);
		pnForm.add(cbCurso);

		// --------------------------------JTextField---------------------------------------
		tfNome = new JTextField();
		tfNome.setBounds(120, 13, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(120, 54, 170, 20);
		pnForm.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		tfCotas = new JTextField();
		tfCotas.setBounds(120, 94, 170, 20);
		pnForm.add(tfCotas);
		tfCotas.setColumns(10);

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