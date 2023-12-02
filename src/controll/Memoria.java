package controll;

import view.Calculadora;

public class Memoria {
	private Calculadora calculadora;

	public Memoria() {
		calculadora = new Calculadora();
	}

	public static float calcularExpressao(String expressao) {
		expressao = expressao.replaceAll("\\s", "");

		String[] partes = expressao.split("([+\\-*/])");

		if (partes.length == 2) {
			try {
				int a = Integer.parseInt(partes[0]);
				char symbol = expressao.charAt(partes[0].length());
				int b = Integer.parseInt(partes[1]);

				switch (symbol) {
				case '+':
					return a + b;
				case '-':
					return a - b;
				case '*':
					return a * b;
				case '/':
					if (b != 0) {
						return (float) a / b;
					} else {
						System.out.println("Divisão por zero!");
						return 0;
					}
				default:
					System.out.println("Operador inválido: " + symbol);
					return 0;
				}
			} catch (NumberFormatException e) {
				System.out.println("Números inválidos na expressão: " + expressao);
			}
		}

		System.out.println("Expressão inválida: " + expressao);
		return 0;
	}



	public Calculadora getCalculadora() {
		return calculadora;
	}

}
