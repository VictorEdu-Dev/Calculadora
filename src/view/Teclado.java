package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controll.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel {
	private Display display;
	private List<Botao> listBotoes;
	private StringBuilder textoAcumulado;
	
	public Teclado(Display display) {
		this.setListBotoes(new ArrayList<>());
		this.setDisplay(display);
		this.textoAcumulado = new StringBuilder();

		setLayout(new GridLayout(4, 4));
		setBackground(Color.lightGray);

		add(criarBotao("7", Color.GRAY));
		add(criarBotao("8", Color.GRAY));
		add(criarBotao("9", Color.GRAY));
		add(criarBotao("+", Color.lightGray));

		add(criarBotao("4", Color.GRAY));
		add(criarBotao("5", Color.GRAY));
		add(criarBotao("6", Color.GRAY));
		add(criarBotao("-", Color.lightGray));

		add(criarBotao("1", Color.GRAY));
		add(criarBotao("2", Color.GRAY));
		add(criarBotao("3", Color.GRAY));
		add(criarBotao("*", Color.lightGray));

		add(criarBotao("0", Color.GRAY));
		add(criarBotao("/", Color.lightGray));
		add(criarBotao(".", Color.lightGray));
		add(criarBotao("=", Color.lightGray));


	}

	public Botao criarBotao(String texto, Color cor) {
		Botao b = new Botao(texto, cor);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textoBotao = b.getText();
				if(!"=".equals(textoBotao)) {
					textoAcumulado.append(textoBotao);
					display.getLabel().setText(textoAcumulado.toString());
					display.repaint();
					display.revalidate();
				} else {
		            float resultado = Memoria.calcularExpressao(textoAcumulado.toString());

		            display.getLabel().setText(String.valueOf(resultado));

		            textoAcumulado.setLength(0);
		            
		            display.repaint();
		            display.revalidate();
		        }
			}
		});
		listBotoes.add(b);
		return b;
	}

	// Getters e setters
	public Display getDisplay() {
		return display;
	}

	private void setDisplay(Display display) {
		this.display = display;
	}

	public List<Botao> getListBotoes() {
		return listBotoes;
	}

	private void setListBotoes(List<Botao> listBotoes) {
		this.listBotoes = listBotoes;
	}
}
