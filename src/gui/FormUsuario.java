package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.LoginDAO;

public class FormUsuario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;
	public JTextField tfNome;
	public JTextField tfSenhaOne;
	public JTextField tfSenhaTwo;
	private JButton btAdiconar, btLimpar;

	// --------------------------------METODO-PARA-AS-ACÕES-DOS-BOTÕES---------------------------------------
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btAdiconar) {
			if (tfSenhaOne.getText().equals(tfSenhaTwo.getText())) {
				if ((tfNome.getText().isEmpty()) || (tfSenhaTwo.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				} else {
					LoginDAO loginDAO = new LoginDAO();
					loginDAO.adicionaUsuario(tfNome, tfSenhaTwo);
					JOptionPane.showMessageDialog(null, "Usuário " + tfNome.getText() + " inserido com sucesso! ");
					limparCampos(pnForm);
				}
			}else {
				JOptionPane.showMessageDialog(null, "as senhas não foram informada iguais");
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

	public FormUsuario() {
		// --------------------------------CONFIG-DA-JANELA---------------------------------------
		setTitle("Cadastrar Usuário");
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

		JLabel lbCadastrarBolsista = new JLabel("CADASTRAR USUÁRIO");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 222, 14);
		contentPane.add(lbCadastrarBolsista);

		JLabel lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 29, 78, 29);
		pnForm.add(lbNome);

		JLabel lbMatricula = new JLabel("SENHA:");
		lbMatricula.setBounds(32, 79, 78, 29);
		pnForm.add(lbMatricula);

		JLabel lbCurso = new JLabel("SENHA:");
		lbCurso.setBounds(32, 127, 78, 29);
		pnForm.add(lbCurso);

		// --------------------------------JTextField---------------------------------------
		tfNome = new JTextField();
		tfNome.setBounds(120, 33, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);

		tfSenhaTwo = new JTextField();
		tfSenhaTwo.setBounds(120, 83, 90, 20);
		pnForm.add(tfSenhaTwo);
		tfSenhaTwo.setColumns(10);
		
		tfSenhaOne = new JTextField();
		tfSenhaOne.setBounds(120, 130, 90, 20);
		pnForm.add(tfSenhaOne);
		tfSenhaOne.setColumns(10);

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
