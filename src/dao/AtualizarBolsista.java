package dao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Bolsista;

public class AtualizarBolsista extends JPanel{

	private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbMatricula;
    private JLabel lbCurso;
    private JLabel lbId;
    private JTextField txNome;
    private JTextField txId;
    private JTextField tfMatricula;
    private JTextField tfCurso;
    Bolsista bolsista;
    private int linhaSelecionada;

    public AtualizarBolsista(DefaultTableModel md, int id, int linha) {
        modelo = md;
        BolsistaDAO dao = new BolsistaDAO();
        bolsista = dao.getBolsistaById(id);
        txId.setText(Integer.toString(bolsista.getId()));
        txNome.setText(bolsista.getNome());
        tfMatricula.setText(bolsista.getMatricula());
        tfCurso.setText(bolsista.getCurso());
        linhaSelecionada = linha;  
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("         Nome.:   ");
        lbMatricula = new JLabel("         Telefone.:   ");
        lbCurso = new JLabel("         Email.:   ");
        lbId = new JLabel("         Id.:   ");
        txNome = new JTextField();
        tfMatricula = new JTextField();
        tfCurso = new JTextField();
        txId = new JTextField();
        txId.setEditable(false);

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(5, 2, 2, 4));
        painelFundo.add(lbId);
        painelFundo.add(txId);
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(lbMatricula);
        painelFundo.add(tfMatricula);
        painelFundo.add(lbCurso);
        painelFundo.add(tfCurso);
        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);

        add(painelFundo);
        setSize(300, 150);
        setVisible(true);

        btSalvar.addActionListener(new AtualizarBolsista.BtSalvarListener());
        btLimpar.addActionListener(new AtualizarBolsista.BtLimparListener());
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
            modelo.addRow(new Object[]{bolsista.getId(), bolsista.getNome(), bolsista.getMatricula(), bolsista.getCurso()});
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
