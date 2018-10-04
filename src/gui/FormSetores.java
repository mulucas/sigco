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

import dao.DAOSetores;
import modelo.Setores;

public class FormSetores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;
	public JTextField tfNome,tfQntdCotas;
	private JButton btAdiconar, btLimpar;

	// --------------------------------METODO-PARA-AS-AC�ES-DOS-BOT�ES---------------------------------------
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btAdiconar) {
			Setores setores = new Setores();
			setores.setNome(tfNome.getText());
			setores.setCotasDisponiveis(tfQntdCotas.getText());
			
			if (tfNome.getText().isEmpty())  {
				JOptionPane.showMessageDialog(null, "O campo nome nao pode retornar vazio");
			} else {
				DAOSetores dao = new DAOSetores();
				dao.adiciona(setores);
				JOptionPane.showMessageDialog(null, "Setor " + tfNome.getText() + " inserido com sucesso! ");
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

	public FormSetores() {
		// --------------------------------CONFIG-DA-JANELA---------------------------------------
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

		JLabel lbCadastrarBolsista = new JLabel("CADASTRAR SETOR");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 222, 14);
		contentPane.add(lbCadastrarBolsista);

		JLabel lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 29, 78, 29);
		pnForm.add(lbNome);
		
		JLabel lbQantCotas = new JLabel("Quant. Cotas:");
		lbQantCotas.setBounds(32, 85, 78, 29);
		pnForm.add(lbQantCotas);
		
		// --------------------------------JTextField---------------------------------------
		tfNome = new JTextField();
		tfNome.setBounds(120, 33, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);
		
		tfQntdCotas = new JTextField();
		tfQntdCotas.setBounds(120, 89, 170, 20);
		pnForm.add(tfQntdCotas);
		tfQntdCotas.setColumns(10);

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