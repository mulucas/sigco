package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import dao.BolsistaDAO;
import dao.ListarBolsista;
import dao.ListarProfessor;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuBar mnBarra;
	private JMenu mnInicio, mnCadastro, mnlistar, mnConfig;
	private JMenuItem miSair, miListaBolsista, miListaProfessor, miCadastrarProfessor, miCadastrarBolsista,
			miPainelPrincipal, miTrocarUsuario, miCadastrarUsuario;
	FormBolsista formBolsista = new FormBolsista();
	FormProfessor formProfessor = new FormProfessor();
	InicioPanel jpprincipal = new InicioPanel();
	ListarProfessor listaProfessor = new ListarProfessor();
	ListarBolsista listaBolsista = new ListarBolsista();

	public MenuPrincipal() {
		inicializarComponentes();
		// definirEventos();
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
		miPainelPrincipal = new JMenuItem("Painel Principal");
		miTrocarUsuario = new JMenuItem("Trocar Usuario");
		miCadastrarUsuario = new JMenuItem("Cadastrar Usuário");

		miPainelPrincipal.addActionListener(this);
		miCadastrarBolsista.addActionListener(this);
		miCadastrarProfessor.addActionListener(this);
		miListaBolsista.addActionListener(this);
		miListaProfessor.addActionListener(this);
		miTrocarUsuario.addActionListener(this);
		miSair.addActionListener(this);

		// -----------------------add os itens--------
		mnInicio.add(miPainelPrincipal);
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
		JPanel panelTrocar = null;
		Object o = e.getSource();
		if (o == miCadastrarBolsista) {
			formBolsista.setVisible(true);
		} else if (o == miCadastrarProfessor) {
			formProfessor.setVisible(true);
		} else if (o == miListaBolsista) {
			panelTrocar = listaBolsista;
			getContentPane().removeAll();
			getContentPane().add(panelTrocar);
			revalidate();
			repaint();
		} else if (o == miListaProfessor) {
			panelTrocar = listaProfessor;
			getContentPane().removeAll();
			getContentPane().add(panelTrocar);
			revalidate();
			repaint();
		} else if (o == miTrocarUsuario) {
			dispose();
			LoginFrame f = new LoginFrame();
			f.setVisible(true);
		} else if (o == miPainelPrincipal) {
			panelTrocar = jpprincipal;
			getContentPane().removeAll();
			getContentPane().add(panelTrocar);
			revalidate();
			repaint();
		} else if (o == miSair) {
			System.exit(0);
		}
	}

	public static void abrir() {
		MenuPrincipal frame = new MenuPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setLocation((tela.width - frame.getSize().width), (tela.height - frame.getSize().height));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}