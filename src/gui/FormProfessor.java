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

import dao.ProfessorDAO;
import modelo.Professor;

public class FormProfessor extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lbCadastrarBolsista,lbNome,lbMatricula, lbqntdAlunos;
	private JTextField tfNome, tfMatricula, tfqntdAlunos;
	private JButton btAdiconar, btLimpar;
	private JPanel pnForm = new JPanel();

	private void limparCampos(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}

	public void actionPerformed(ActionEvent e){                    
        Object o = e.getSource(); 
        if (o == btAdiconar) {  
        	Professor professor = new Professor();
			professor.setNome(tfNome.getText());
			professor.setMatricula(tfMatricula.getText());
			professor.setQntdAlunos(tfqntdAlunos.getText());

			if ((tfNome.getText().isEmpty()) || (tfMatricula.getText().isEmpty())||(tfqntdAlunos.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
			} else {
				ProfessorDAO dao = new ProfessorDAO();
				dao.adiciona(professor);
				JOptionPane.showMessageDialog(null, "Professor " + tfNome.getText() + " inserido com sucesso! ");		
				limparCampos(pnForm);
				
			}
        } else if (o == btLimpar) {
        	limparCampos(pnForm);      			
		}          
    } 
	public FormProfessor() {
		//--------------------------------CONFIG-DA-JANELA---------------------------------------
		setTitle("Formulário Professor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// --------------------------------JPANEL-----------------------------
		pnForm.setBackground(Color.WHITE);
		pnForm.setBounds(0, 61, 320, 241);
		contentPane.add(pnForm);
		pnForm.setLayout(null);
		
		lbCadastrarBolsista = new JLabel("CADASTRAR PROFESSOR");
		lbCadastrarBolsista.setFont(new Font("Bell MT", Font.BOLD, 18));
		lbCadastrarBolsista.setBounds(55, 25, 272, 14);
		contentPane.add(lbCadastrarBolsista);
		
		lbNome = new JLabel("NOME:");
		lbNome.setBounds(32, 29, 78, 29);
		pnForm.add(lbNome);
		
		lbMatricula = new JLabel("MATRICULA:");
		lbMatricula.setBounds(32, 79, 78, 29);
		pnForm.add(lbMatricula);
		
		lbqntdAlunos = new JLabel("QUANTIDADE DE ALUNOS:");
		lbqntdAlunos.setBounds(32, 129, 150, 29);
		pnForm.add(lbqntdAlunos);
		
		// --------------------------------JTextField------------------------
		tfNome = new JTextField();
		tfNome.setBounds(130, 33, 147, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(130, 83, 147, 20);
		pnForm.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		tfqntdAlunos = new JTextField();
		tfqntdAlunos.setBounds(215, 133, 60, 20);
		pnForm.add(tfqntdAlunos);
		tfqntdAlunos.setColumns(10);
		
		// --------------------------------JButton----------------------------
		btAdiconar = new JButton("ADICIONAR");
		btAdiconar.setBounds(45, 194, 117, 23);
		btAdiconar.addActionListener(this);
		pnForm.add(btAdiconar);
		
		btLimpar = new JButton("LIMPAR");
		btLimpar.setBounds(188, 194, 89, 23);
		btLimpar.addActionListener(this);
		pnForm.add(btLimpar);
	}
}
