package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {
	private Display display;
	private Teclado teclado;
	
	public Calculadora() {				
	
		organizador();
		setSize(300,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void organizador() {
		display = new Display();
		teclado = new Teclado(display);
		
		setLayout(new BorderLayout());		
	    add(display, BorderLayout.NORTH);		
		add(teclado, BorderLayout.CENTER);
		
	}

	public Display getDisplay() {
		return display;
	}

	public Teclado getTeclado() {
		return teclado;
	}
}
