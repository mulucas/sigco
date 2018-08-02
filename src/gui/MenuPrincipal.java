package gui;

import java.awt.event.*;
import javax.swing.*;

import dao.ListarBolsista;
import dao.ListarProfessor;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuBar mnBarra;
	private JMenu mnInicio, mnCadastro, mnlistar, mnConfig;
	private JMenuItem miSair, miListaBolsista, miListaProfessor, miCadastrarProfessor, miCadastrarBolsista,
			miPainelInicial, miTrocarUsuario, miCadastrarUsuario;
	FormBolsista formBolsista = new FormBolsista();
	FormProfessor formProfessor = new FormProfessor();
	InicioPanel jpprincipal = new InicioPanel(this);
	ListarProfessor listaProfessor = new ListarProfessor();
	ListarBolsista listaBolsista = new ListarBolsista();
	JPanel panelTrocar = null;

	public MenuPrincipal() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setTitle("Controle de Cotas-COAPAC");
		setBounds(0, 0, 700, 620);

		this.getContentPane().add(jpprincipal);
		jpprincipal.setLocation(0, 0);
		this.getContentPane().repaint();
		mnBarra = new JMenuBar();

		// -----------nomeia os botoes na barra de menu----
		mnInicio = new JMenu("Inicio");
		mnInicio.setMnemonic('I');
		mnlistar = new JMenu("Listar");
		mnlistar.setMnemonic('L');
		mnCadastro = new JMenu("Adicionar");
		mnCadastro.setMnemonic('A');
		mnConfig = new JMenu("Configurações");
		mnConfig.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon("sair.jpg"));
		// miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
		// ActionEvent.ALT_MASK));

		// ---------nomeia os botoes dos itens--------------
		miListaBolsista = new JMenuItem("Bolsista");
		miListaProfessor = new JMenuItem("Professor");
		miCadastrarBolsista = new JMenuItem("Bolsista");
		miCadastrarProfessor = new JMenuItem("Professor");
		miPainelInicial = new JMenuItem("Painel Principal");
		miTrocarUsuario = new JMenuItem("Trocar Usuario");
		miCadastrarUsuario = new JMenuItem("Cadastrar Usuário");

		miPainelInicial.addActionListener(this);
		miCadastrarBolsista.addActionListener(this);
		miCadastrarProfessor.addActionListener(this);
		miListaBolsista.addActionListener(this);
		miListaProfessor.addActionListener(this);
		miTrocarUsuario.addActionListener(this);
		miSair.addActionListener(this);

		// -----------------------add os itens--------
		mnInicio.add(miPainelInicial);
		mnInicio.add(miTrocarUsuario);
		mnlistar.add(miListaBolsista);
		mnlistar.add(miListaProfessor);
		mnCadastro.add(miCadastrarBolsista);
		mnCadastro.add(miCadastrarProfessor);
		mnConfig.add(miCadastrarUsuario);
		mnConfig.add(miSair);

		// ------------------------add no BARRA---------
		mnBarra.add(mnInicio);
		mnBarra.add(mnlistar);
		mnBarra.add(mnCadastro);
		mnBarra.add(mnConfig);
		setJMenuBar(mnBarra);

	}
	 
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if (o == miCadastrarBolsista) {
			formBolsista.setVisible(true);
		} else if (o == miCadastrarProfessor) {
			formProfessor.setVisible(true);
		} else if (o == miListaBolsista) {
			listarBolsistas();
		} else if (o == miListaProfessor) {
			listarProfessores();
		} else if (o == miTrocarUsuario) {
			trocarUsuario();
		} else if (o == miPainelInicial) {
			panelInicial();
		} else if (o == miSair) {
			System.exit(0);
		}
	}
	
	public void panelInicial() {
		panelTrocar = jpprincipal;
		getContentPane().removeAll();
		getContentPane().add(panelTrocar);
		revalidate();
		repaint();
	}
	
	public void listarBolsistas() {
		panelTrocar = listaBolsista;
		getContentPane().removeAll();
		getContentPane().add(panelTrocar);
		revalidate();
		repaint();
	}
	public void listarProfessores() {
		panelTrocar = listaProfessor;
		getContentPane().removeAll();
		getContentPane().add(panelTrocar);
		revalidate();
		repaint();
	}
	
	public void trocarUsuario() {
		dispose();
		LoginFrame telaLogin = new LoginFrame();
		telaLogin.setVisible(true);
	}

	public static void abrir() {
		MenuPrincipal frame = new MenuPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}