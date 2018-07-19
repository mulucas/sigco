package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import dao.LoginDAO;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btEntrar;
	private JButton btSair;
	private JPanel pnPrincipal;
	private JLabel lbLogin;
	private JLabel lbNome;
	private JLabel lbSenha;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	LoginDAO logindao = new LoginDAO();

	public LoginFrame() {
		initComponents();
	}
	private void initComponents() {
		pnPrincipal = new JPanel();
		lbNome = new JLabel();
		txtNome = new JTextField();
		txtSenha = new JPasswordField();
		btEntrar = new JButton();
		btSair = new JButton();
		lbSenha = new JLabel();
		lbLogin = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("COAPAC");
		setResizable(false);
		setLocationRelativeTo(null);

		pnPrincipal.setBackground(new Color(0, 153, 0));
		pnPrincipal.setBorder(BorderFactory.createTitledBorder(null, "Sistema de controle de cotas", TitledBorder.RIGHT,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 12)));
		pnPrincipal.setToolTipText("");
		pnPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		lbNome.setFont(new Font("Tahoma", 1, 11)); 
		lbNome.setForeground(new Color(255, 255, 255));
		lbNome.setText("NOME:");

		txtNome.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {					
		        // seleciona todo o conteúdo
				txtNome.selectAll();
			}
		}); 
		txtSenha.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {						
		        // seleciona todo o conteúdo
				txtNome.selectAll();
			}
		}); 
		btEntrar.setFont(new Font("Arial", 1, 12)); 
		btEntrar.setText("Entrar");
		btEntrar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btEntrar.setMnemonic(KeyEvent.VK_S);
		btEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btEntrarActionPerformed(arg0);
			}
		});
		btEntrar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btEntrar.doClick();
				}
			}
		});
		btSair.setFont(new Font("Arial", 1, 12)); 
		btSair.setText("Sair");
		btSair.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btSairActionPerformed(arg0);
			}
		});
		btSair.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		lbSenha.setBackground(new Color(255, 255, 255));
		lbSenha.setFont(new Font("Tahoma", 1, 11)); 
		lbSenha.setForeground(new Color(255, 255, 255));
		lbSenha.setText("SENHA:");

		lbLogin.setFont(new Font("Arial Black", 1, 24)); 
		lbLogin.setForeground(new Color(255, 255, 255));
		lbLogin.setText("LOGIN");

		GroupLayout glLayout = new GroupLayout(pnPrincipal);
		pnPrincipal.setLayout(glLayout);
		glLayout.setHorizontalGroup(glLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(glLayout.createSequentialGroup().addGap(41, 41, 41)
						.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lbSenha, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbNome, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(glLayout.createSequentialGroup()
												.addComponent(btEntrar, GroupLayout.PREFERRED_SIZE, 75,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(btSair, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
										.addComponent(txtSenha)))
						.addGap(60, 60, 60))
				.addGroup(GroupLayout.Alignment.TRAILING,
						glLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbLogin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(110, 110, 110)));
		glLayout.setVerticalGroup(glLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(glLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(lbLogin)
						.addGap(50, 50, 50)
						.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbNome))
						.addGap(26, 26, 26)
						.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbSenha))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addGroup(glLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btEntrar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btSair, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(84, 84, 84)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pnPrincipal,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pnPrincipal,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pack();
	}

	private void btSairActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void btEntrarActionPerformed(ActionEvent evt) {
		logindao.acessarSistema(txtNome,txtSenha);
		dispose();
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().setVisible(true);
			}
		});
	}
}