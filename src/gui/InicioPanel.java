package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InicioPanel extends JPanel {

	JButton btnListagemprofessor,btnListagemBolsista,btnADDUprof,btnADDBolsista,btnADDUsuario,btnInformacoes,btnLogin,btnSair;
	LoginFrame login = new LoginFrame();
	FormBolsista formBolsista = new FormBolsista();
	FormProfessor formProfessor = new FormProfessor();
	FormUsuario formUsuario = new FormUsuario();
	private static final long serialVersionUID = 1L;
	MenuPrincipal menuPrincipal;
	
	public InicioPanel(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		inicializaComponentes();
		definirEventos();
	}
	private void inicializaComponentes() {
		setBounds(100, 100, 700, 600);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem vindo "+System.getProperty("nome"));
		lblBemVindo.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblBemVindo.setForeground(new Color(0,0,139));
		lblBemVindo.setBounds(218, 0, 300, 47);
		add(lblBemVindo);
		
		JLabel lblSigco = new JLabel("SIGCO");
		lblSigco.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblSigco.setBounds(285, 60, 87, 47);
		add(lblSigco);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE GERENCIAMENTO E CONTROLE DE COTAS");
		lblNewLabel.setBounds(102, 50, 460, 23);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel);

		btnListagemprofessor = new JButton("");
		btnListagemprofessor.setBounds(160, 145, 50, 50);
		btnListagemprofessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("professor.png")));
		add(btnListagemprofessor);

		btnListagemBolsista = new JButton("");
		btnListagemBolsista.setBounds(260, 145, 50, 50);
		btnListagemBolsista.setIcon(new javax.swing.ImageIcon(getClass().getResource("bolsista.png")));
		add(btnListagemBolsista);

		btnADDUprof = new JButton("");
		btnADDUprof.setBounds(360, 145, 50, 50);
		btnADDUprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("addprof.png")));
		add(btnADDUprof);

		btnADDBolsista = new JButton("");
		btnADDBolsista.setBounds(460, 145, 50, 50);
		btnADDBolsista.setIcon(new javax.swing.ImageIcon(getClass().getResource("addbolsista.png")));
		add(btnADDBolsista);

		btnADDUsuario = new JButton("");
		btnADDUsuario.setBounds(160, 245, 50, 50);
		btnADDUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("addUsuario.png")));
		add(btnADDUsuario);

		btnInformacoes = new JButton("");
		btnInformacoes.setBounds(260, 245, 50, 50);
		btnInformacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("saber.png")));
		add(btnInformacoes);

		btnLogin = new JButton("");
		btnLogin.setBounds(360, 245, 50, 50);
		btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("login.png")));
		add(btnLogin);

		btnSair = new JButton("");
		btnSair.setBounds(460, 245, 50, 50);
		btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("sair.png")));
		add(btnSair);

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

			JLabel lblSistemaDesenvolvidoPor = new JLabel(
					"Sistema Desenvolvido por LUCAS QUEIROZ - lukasqueiroz54@gmail.com");
			lblSistemaDesenvolvidoPor.setForeground(Color.GRAY);
			lblSistemaDesenvolvidoPor.setFont(new Font("Tahoma", Font.ITALIC, 11));
			lblSistemaDesenvolvidoPor.setBounds(23, 534, 350, 14);
			add(lblSistemaDesenvolvidoPor);

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
	private void definirEventos() {
		btnSair.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogin.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.trocarUsuario();
			}
		});
		btnADDBolsista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formBolsista.setVisible(true);		
			}
		});
		btnADDUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formUsuario.setVisible(true);
			}
		});
		btnADDUprof.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formProfessor.setVisible(true);		
			}
		});
		btnInformacoes.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				openURL("https://www.youtube.com/");				
			}
		});
		btnListagemBolsista.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.listarBolsistas();
			}
		});
		btnListagemprofessor.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.listarProfessores();				
			}
		});
	}
	 public static void openURL(String url) {
	        String osName = System.getProperty("os.name");
	        String browser = null;
	        try {
	            if (osName.startsWith("Mac OS")) {
	                Class fileMgr = Class.forName("com.apple.eio.FileManager");
	                Method openURL = fileMgr.getDeclaredMethod("openURL",
	                        new Class[]{String.class});
	                openURL.invoke(null, new Object[]{url});
	            } else if (osName.startsWith("Windows")) {
	                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
	            } else { //assume Unix or Linux   
	                String[] browsers = {
	                    "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"
	                };
	                for (int count = 0; count < browsers.length && browser == null; count++) {
	                    if (Runtime.getRuntime().exec(
	                            new String[]{"which", browsers[count]}).waitFor() == 0) {
	                        browser = browsers[count];
	                    }
	                }
	                JOptionPane.showMessageDialog(null,browser);
	                if (browser == null) {
	                    JOptionPane.showMessageDialog(null,"Navegador não encontrado!");
	                } else {
	                    Runtime.getRuntime().exec(new String[]{browser,url});
	                }
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, ":\n" + e.getLocalizedMessage());
	        }
	    }
}

