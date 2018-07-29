package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gui.FormBolsista;
import modelo.Bolsista;

public class AtualizarBolsista extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	
	private JLabel lbNome;
	private JLabel lbMatricula;
	private JLabel lbCurso;
	private JLabel lbId;
	private JTextField txNome;
	private JTextField txId;
	
	private JTextField tfCurso;
	private JPanel contentPane, pnForm;
	public JTextField tfNome;
	public JTextField tfMatricula;
	private JButton btAdiconar, btLimpar;
	private JComboBox cbCurso;
	
	Bolsista bolsista;
	private int linhaSelecionada;

	public AtualizarBolsista(DefaultTableModel md, int id, int linha) {
		modelo = md;
		BolsistaDAO dao = new BolsistaDAO();
		bolsista = dao.getBolsistaById(id);
		criaJanela();
		FormBolsista fb = new FormBolsista();
		fb.tfNome.setText(bolsista.getNome());
		fb.setVisible(true);
		// txId.setText(Integer.toString(bolsista.getId()));
		
		  txNome.setText(bolsista.getNome());
		  tfMatricula.setText(bolsista.getMatricula());
		  tfCurso.setText(bolsista.getCurso());
		 
		linhaSelecionada = linha;

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
		//btAdiconar.addActionListener(this);
		pnForm.add(btAdiconar);

		btLimpar = new JButton("LIMPAR");
		btLimpar.setBounds(168, 194, 117, 23);
		//btLimpar.addActionListener(this);
		pnForm.add(btLimpar);
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Bolsista bolsista = new Bolsista();
			bolsista.setId(Integer.parseInt(txId.getText()));
			bolsista.setNome(txNome.getText());
			bolsista.setMatricula(tfMatricula.getText());
			bolsista.setCurso(tfCurso.getText());

			BolsistaDAO dao = new BolsistaDAO();
			dao.atualizar(bolsista);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[] { bolsista.getId(), bolsista.getNome(), bolsista.getMatricula(),
					bolsista.getCurso() });
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			tfMatricula.setText("");
			tfCurso.setText("");
		}
	}
}
