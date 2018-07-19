package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InicioPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public InicioPanel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" SISTEMA DE GERENCIAMENTO E CONTROLE DE COTAS");
		lblNewLabel.setBounds(102, 41, 460, 23);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel);
		
		JButton btnprofessor = new JButton("");
		btnprofessor.setBounds(160, 145, 50, 50);
		btnprofessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("professor.png")));
		add(btnprofessor);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(260, 145, 50, 50);
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("bolsista.png")));
		add(btnNewButton);
		
		JButton btnNewButt = new JButton("");
		btnNewButt.setBounds(360, 145, 50, 50);
		btnNewButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("addusuario.png")));
		add(btnNewButt);
		
		JButton btnNwButt = new JButton("");
		btnNwButt.setBounds(460, 145, 50, 50);
		btnNwButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("addbolsista.png")));
		add(btnNwButt);
		
		JButton btnproessor = new JButton("");
		btnproessor.setBounds(160, 245, 50, 50);
		btnproessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("addprofessor.png")));
		add(btnproessor);
		
		JButton btnNtton = new JButton("");
		btnNtton.setBounds(260, 245, 50, 50);
		btnNtton.setIcon(new javax.swing.ImageIcon(getClass().getResource("saber.png")));
		add(btnNtton);
		
		JButton bwButt = new JButton("");
		bwButt.setBounds(360, 245, 50, 50);
		bwButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("login.png")));
		add(bwButt);
		
		JButton btnNwsssButt = new JButton("");
		btnNwsssButt.setBounds(460, 245, 50, 50);
		btnNwsssButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("sair.png")));
		add(btnNwsssButt);
		
		JPanel logoIF = new JPanel();
		logoIF.setBounds(380, 450, 300, 129);
		add(logoIF);
		logoIF.setBackground(Color.WHITE);
		logoIF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		
		String diretorioIMD = "logoif.png";
		java.net.URL resource = getClass().getResource(diretorioIMD);
        File file;
		try {
			file = new File(resource.toURI());
			ImageIcon logo = new ImageIcon(file.getPath());
			JLabel lblNewLabel_4 = new JLabel(logo);
			logoIF.add(lblNewLabel_4);
			
			JLabel lblSistemaDesenvolvidoPor = new JLabel("Sistema Desenvolvido por LUCAS QUEIROZ - lukasqueiroz54@gmail.com");
			lblSistemaDesenvolvidoPor.setForeground(Color.GRAY);
			lblSistemaDesenvolvidoPor.setFont(new Font("Tahoma", Font.ITALIC, 11));
			lblSistemaDesenvolvidoPor.setBounds(23, 534, 350, 14);
			add(lblSistemaDesenvolvidoPor);
			
			JLabel lblSigco = new JLabel("SIGCO");
			lblSigco.setFont(new Font("Arial Black", Font.PLAIN, 24));
			lblSigco.setBounds(286, 0, 87, 47);
			add(lblSigco);
			
			JLabel lblNewLabel_1 = new JLabel("Listagem");
			lblNewLabel_1.setBounds(205, 120, 56, 14);
			add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Cadastramento");
			lblNewLabel_2.setBounds(404, 120, 97, 14);
			add(lblNewLabel_2);
			
			JLabel lblConfiguraes = new JLabel("Configurações");
			lblConfiguraes.setBounds(301, 220, 87, 14);
			add(lblConfiguraes);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 110, 684, 207);
			add(panel);
			
			JLabel lblComult = new JLabel("COMULT-MC");
			lblComult.setFont(new Font("SimSun-ExtB", Font.ITALIC, 45));
			lblComult.setBounds(23, 450, 347, 77);
			add(lblComult);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}	
	}
}
