package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import dao.ListarBolsista;
import dao.ListarProfessor;
import dao.ListarSetores;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	public Inicio() {
		initComponents();
	}

	private void initComponents() {

		pnPrincipal = new JPanel();
		lbComult = new JLabel();
		lbEmail = new JLabel();
		btnCADASBOLSISTA = new JButton();
		btnCadasProfessor = new JButton();
		btnListarBolsista = new JButton();
		btnListarProfessor = new JButton();
		lbSIGCO = new JLabel();
		btnSair = new JButton();
		lbSigcoPalavras = new JLabel();
		btnCadasSetor = new JButton();
		btnListarSetores = new JButton();
		jMenuBarPrincipal = new JMenuBar();
		jMenuItemTrocarUsuario = new JMenuItem();
		jMenuListar = new JMenu();
		jMenuItemListarBolsista = new JMenuItem();
		jMenuItemListarProfessor = new JMenuItem();
		jMenuItemListarSetor = new JMenuItem();
		jMenuCadastrar = new JMenu();
		jMenuItemCadastrarBolsista = new JMenuItem();
		jMenuItemCadastrarProfessor = new JMenuItem();
		jMenuItemCadastrarSetor = new JMenuItem();
		jMenuConfig = new JMenu();
		jMenuItemSair = new JMenuItem();
		jMenuItemAddUsuario = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		pnPrincipal.setBackground(new Color(0, 153, 0));

		lbComult.setFont(new Font("Calisto MT", 3, 48)); // NOI18N
		lbComult.setForeground(new Color(0, 0, 0));
		lbComult.setHorizontalAlignment(SwingConstants.CENTER);
		lbComult.setText("COMULT-mc");

		lbEmail.setForeground(new Color(255, 255, 255));
		lbEmail.setText("Sistema desenvolvido por Lucas Queiroz - lukasqueiroz54@gmail.com");

		btnCADASBOLSISTA.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnCADASBOLSISTA.setText("Cadastrar Bolsista");
		btnCADASBOLSISTA.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (formBolsista == null) {
					btnCadastraBolsistaAction();
				} else {
					formBolsista.show();
				}
			}
		});

		btnCadasProfessor.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnCadasProfessor.setText("Cadastrar Professor");
		btnCadasProfessor.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				if (formProfessor == null) {
					btnCadastraProfessorAction();
				} else {
					formProfessor.show();
				}
			}
		});

		btnListarBolsista.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnListarBolsista.setText("Listar Bolsistas");
		btnListarBolsista.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				if (listarBolsista == null) {
					btnListarBolsistaAction(evt);					
				} else {
					listarBolsista.show();
				}
			}
		});

		btnListarProfessor.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnListarProfessor.setText("Listar Professores");
		btnListarProfessor.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				if (listarProfessor == null) {
					btnListarProfessorAction(evt);					
				} else {
					listarProfessor.show();
				}
			}
		});

		lbSIGCO.setFont(new Font("MS Reference Sans Serif", 1, 46)); // NOI18N
		lbSIGCO.setForeground(new Color(255, 255, 255));
		lbSIGCO.setHorizontalAlignment(SwingConstants.CENTER);
		lbSIGCO.setText("SIGCO");

		btnSair.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setText("SAIR");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		lbSigcoPalavras.setFont(new Font("MS Reference Sans Serif", 1, 10)); // NOI18N
		lbSigcoPalavras.setForeground(new Color(255, 255, 255));
		lbSigcoPalavras.setHorizontalAlignment(SwingConstants.CENTER);
		lbSigcoPalavras.setText("SISTEMA DE GERENCIAMENTO E CONTROLE DE COTAS");

		btnCadasSetor.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnCadasSetor.setText("Cadastrar Setor");
		btnCadasSetor.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				if (formSetores == null) {
					btnCadastraSetorAction();
				} else {
					formSetores.show();
				}
			}
		});

		btnListarSetores.setFont(new Font("Dialog", 1, 14)); // NOI18N
		btnListarSetores.setText("Listar Setores");
		btnListarSetores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (listarSetores == null) {
					btnListarSetoresAction(arg0);					
				} else {
					listarSetores.show();
				}
			}
		});

		jMenuBarPrincipal.setBackground(new Color(204, 204, 204));

		jMenuItemTrocarUsuario.setText("Trocar Usuário");
		jMenuItemTrocarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trocarUsuario();
			}
		});

		jMenuListar.setBackground(new Color(204, 204, 204));
		jMenuListar.setForeground(new Color(0, 0, 0));
		jMenuListar.setText("Listar");

		jMenuItemListarBolsista.setText("Bolsista");
		jMenuItemListarBolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (listarBolsista == null) {
					btnListarBolsistaAction(evt);					
				} else {
					listarBolsista.show();
				}
			}
		});
		jMenuListar.add(jMenuItemListarBolsista);
		
		jMenuItemListarSetor.setText("Setores");
		jMenuItemListarSetor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent even) {
				if (listarSetores == null) {
					btnListarSetoresAction(even);					
				} else {
					listarSetores.show();
				}
			}
		});
		jMenuListar.add(jMenuItemListarSetor);

		jMenuItemListarProfessor.setText("Professor");
		jMenuItemListarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (listarProfessor == null) {
					btnListarProfessorAction(evt);					
				} else {
					listarProfessor.show();
				}
			}
		});
		jMenuListar.add(jMenuItemListarProfessor);

		jMenuBarPrincipal.add(jMenuListar);

		jMenuCadastrar.setBackground(new Color(204, 204, 204));
		jMenuCadastrar.setForeground(new Color(0, 0, 0));
		jMenuCadastrar.setText("Cadastrar");

		jMenuItemCadastrarBolsista.setText("Bolsista");
		jMenuItemCadastrarBolsista.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (formBolsista == null) {
					btnCadastraBolsistaAction();
				} else {
					formBolsista.show();
				}
			}
		});
		jMenuCadastrar.add(jMenuItemCadastrarBolsista);

		jMenuItemCadastrarSetor.setText("Setor");
		jMenuItemCadastrarSetor.addActionListener(new ActionListener() {		
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (formSetores == null) {
					btnCadastraSetorAction();
				} else {
					formSetores.show();
				}
			}
		});
		jMenuCadastrar.add(jMenuItemCadastrarSetor);
		
		jMenuItemCadastrarProfessor.setText("Professor");
		jMenuItemCadastrarProfessor.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (formProfessor == null) {
					btnCadastraProfessorAction();
				} else {
					formProfessor.show();
				}
			}
		});
		jMenuCadastrar.add(jMenuItemCadastrarProfessor);

		jMenuBarPrincipal.add(jMenuCadastrar);

		jMenuConfig.setBackground(new Color(204, 204, 204));
		jMenuConfig.setForeground(new Color(0, 0, 0));
		jMenuConfig.setText("Configurações");

		jMenuItemSair.setText("Sair");
		jMenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		jMenuConfig.add(jMenuItemAddUsuario);
		jMenuConfig.add(jMenuItemTrocarUsuario);
		jMenuItemAddUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddUsuarioAction(e);
			}
		});
		jMenuConfig.add(jMenuItemSair);

		jMenuItemAddUsuario.setText("Adicionar Usuário");

		jMenuBarPrincipal.add(jMenuConfig);

		setJMenuBar(jMenuBarPrincipal);

		GroupLayout jPanel1Layout = new GroupLayout(pnPrincipal);
		pnPrincipal.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lbSIGCO, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lbSigcoPalavras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(228, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btnCADASBOLSISTA, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCadasProfessor, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCadasSetor, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(240, 240, 240)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btnListarProfessor, GroupLayout.DEFAULT_SIZE, 164,
										Short.MAX_VALUE)
								.addComponent(btnListarSetores, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnListarBolsista, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(238, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(lbEmail, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbComult, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 175,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap().addComponent(lbSIGCO)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lbSigcoPalavras)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnListarBolsista, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCADASBOLSISTA, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(btnCadasSetor, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnCadasProfessor, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(btnListarProfessor, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnListarSetores, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
						.addComponent(btnSair,GroupLayout.PREFERRED_SIZE, 39,
								GroupLayout.PREFERRED_SIZE)
						.addGap(65, 65, 65).addComponent(lbComult)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lbEmail)
						.addGap(21, 21, 21)));

		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnPrincipal,
						GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				pnPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
	private void btnCadastraSetorAction() {
		formSetores = new FormSetores();
		formSetores.setVisible(true);
	}
	private void btnCadastraProfessorAction() {
		formProfessor = new FormProfessor();
		formProfessor.setVisible(true);
	}
	private void btnCadastraBolsistaAction() {
		formBolsista = new FormBolsista();
		formBolsista.setVisible(true);
	}

	private void btnListarBolsistaAction(ActionEvent evt) {
		listarBolsista = new ListarBolsista();
		listarBolsista.setVisible(true);
	}
	private void btnListarProfessorAction(ActionEvent evt) {
		listarProfessor = new ListarProfessor();
		listarProfessor.setVisible(true);
	}
	private void btnListarSetoresAction(ActionEvent evt) {
		listarSetores = new ListarSetores();
		listarSetores.setVisible(true);
	}
	private void btnAddUsuarioAction(ActionEvent evt) {
		formUsuario = new FormUsuario();
		formUsuario.setVisible(true);
	}

	public static void abrir() {
		Inicio frame = new Inicio();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void trocarUsuario() {
		dispose();
		LoginFrame telaLogin = new LoginFrame();
		telaLogin.setVisible(true);
	}
	
	ListarBolsista listarBolsista;
	ListarProfessor listarProfessor;
	ListarSetores listarSetores;
	FormBolsista formBolsista;
	FormProfessor formProfessor;
	FormUsuario formUsuario;
	FormSetores formSetores;
	private JButton btnCADASBOLSISTA;
	private JButton btnCadasProfessor;
	private JButton btnCadasSetor;
	private JButton btnListarBolsista;
	private JButton btnListarProfessor;
	private JButton btnListarSetores;
	private JButton btnSair;
	private JLabel lbComult;
	private JLabel lbEmail;
	private JLabel lbSIGCO;
	private JLabel lbSigcoPalavras;
	private JMenu jMenuListar;
	private JMenu jMenuCadastrar;
	private JMenu jMenuConfig;
	private JMenuBar jMenuBarPrincipal;
	private JMenuItem jMenuItemListarBolsista, jMenuItemListarSetor, jMenuItemListarProfessor;
	private JMenuItem jMenuItemCadastrarProfessor,jMenuItemCadastrarBolsista,jMenuItemCadastrarSetor;
	private JMenuItem jMenuItemAddUsuario, jMenuItemSair, jMenuItemTrocarUsuario;
	private JPanel pnPrincipal;
}
