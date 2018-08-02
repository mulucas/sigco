package funcoes;

import java.awt.*;

import javax.swing.JTable;
import javax.swing.table.*;

public class ColorRender extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	private final int codTabela; // tabela que sofrerá a ação
	private final int columnAlter; // coluna que sofrerá as ações junto com as linhas (pintando uma unica célula)

	public ColorRender(int codTabela, int columnAlter) {
		this.codTabela = codTabela;
		this.columnAlter = columnAlter;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (isSelected) {
			// define cor e fonte caso a linha esteja selecionada
			setBackground(table.getSelectionBackground());
			setForeground(Color.BLACK);
		} else {// caso não esteja selecionado...
			setForeground(Color.BLACK); // Volta para cor fonte default
			// define cor zebrada da tabela
			if (row % 2 == 0) { // pinta a linha de branco quando a linha for par
				setBackground(Color.WHITE);
			} else { // pinta a linha de cinza quando for impar
				setBackground(new Color(235, 235, 235));
			}
			// Abaixo possui as regras, poderá ser adicionado varias regras diferentes para
			// varias tabelas,
			try {
				if (codTabela == 1) { // Regra da Tabela 1 ambas pintam colunas
					/*if (table.getValueAt(row, 5) == table.getValueAt(row, 4)) {
						// Mais um regra: quero que pinte apenas a coluna selecionada pelo
						// columnAlter
						setFont(new java.awt.Font("Tahoma", 1, 12)); // fonte
						setForeground(new java.awt.Color(102, 0, 0)); // cor da fonte

					}*/
					int a = (int) table.getValueAt(row, 4);
					int b = (int) table.getValueAt(row, 5);

					if (a <= b) { // Sempre que a coluna X não possuir valor, pinte:
						setFont(new java.awt.Font("Tahoma", 1, 12));
						setForeground(new Color(150, 0, 0));
					} else {
						setFont(new java.awt.Font("Tahoma", 1, 12));
						setForeground(new Color(0, 150, 0));
					}
				
				}
				if (codTabela == 2) {

					int a = (int) table.getValueAt(row, 4);
					int b = (int) table.getValueAt(row, 5);

					if (a <= b) { // Sempre que a coluna X não possuir valor, pinte:
						setFont(new java.awt.Font("Tahoma", 1, 12));
						setForeground(new Color(150, 0, 0));
					} else {
						setFont(new java.awt.Font("Tahoma", 1, 12));
						setForeground(new Color(0, 150, 0));
					}
				}
			} catch (java.lang.NullPointerException ex) {
			}
		}
		return this;
	}

}
