package dao;

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

import modelo.Professor;

public class EditarProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnForm;

	JLabel lbCadastrarBolsista, lbNome, lbMatricula, lbCurso,lbId;
	private JTextField tfId, tfNome, tfMatricula,tfNumerosAlunos;
	private JButton btAlterar, btLimpar;

	Professor professor;

	public EditarProfessor(int id) {
		DAOProfessor dao = new DAOProfessor();
		professor = dao.getProfessorById(id);
		
		criaJanela();
		setVisible(true);

		tfId.setText(Integer.toString(professor.getId()));
		tfNome.setText(professor.getNome());
		tfMatricula.setText(professor.getMatricula());
		tfNumerosAlunos.setText(professor.getQntdAlunos());

	}

	public void criaJanela() {
		setTitle("Formulário Professor");
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

		lbCadastrarBolsista = new JLabel("ALTERAR PROFESSOR");
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

		lbCurso = new JLabel("Qant. Alunos:");
		lbCurso.setBounds(32, 127, 78, 29);
		pnForm.add(lbCurso);

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
		
		tfNumerosAlunos = new JTextField();
		tfNumerosAlunos.setBounds(120, 131, 170, 20);
		pnForm.add(tfNumerosAlunos);
		tfNumerosAlunos.setColumns(10);

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
			Professor professor = new Professor();
			professor.setId(Integer.parseInt(tfId.getText()));
			professor.setNome(tfNome.getText());
			professor.setMatricula(tfMatricula.getText());
			professor.setQntdAlunos(tfNumerosAlunos.getText());

			if ((tfNome.getText().isEmpty()) || (tfMatricula.getText().isEmpty())||(tfNumerosAlunos.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
			} else {
				DAOProfessor dao = new DAOProfessor();
				dao.atualizar(professor);
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