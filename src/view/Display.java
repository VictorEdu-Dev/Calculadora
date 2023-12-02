package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Display extends JPanel{

	private JLabel label;

	public Display() {
		setPreferredSize(new Dimension(200,60));

		label = new JLabel();
		label.setBackground(Color.LIGHT_GRAY);
		label.setFont(new Font("arial", Font.BOLD, 40));
		setBackground(Color.GRAY);
		add(label);
	}

	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}


	public void setLabel(String texto) {
		label.setText(texto);
	}

}
