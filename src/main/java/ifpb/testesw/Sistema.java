package ifpb.testesw;

import java.text.DecimalFormat;

public class Sistema implements FuncionalidadesIF {

	// RF1
	public Usuario cadastraUsuario(String nome, String email, String senha) {

		if (!nome.isBlank() && !email.isBlank() && senha.length() >= 8) {

			int digito = 0, maiuscula = 0, minuscula = 0, charEspecial = 0;

			for (int i = 0; i < senha.length(); i++) {

				if (Character.isDigit(senha.charAt(i))) {
					digito++;
				}
				if (Character.isLowerCase(senha.charAt(i))) {
					minuscula++;
				}
				if (Character.isUpperCase(senha.charAt(i))) {
					maiuscula++;
				}
				if (!Character.isLetterOrDigit(senha.charAt(i)) && !Character.isWhitespace(senha.charAt(i))) {
					charEspecial++;
				}
			}

			if (digito > 1 && charEspecial > 0 && maiuscula > 0 && minuscula > 0) {
				Usuario usuario = new Usuario(nome, email, senha);
				return usuario;
			}
		}
		return null;
	}

	// RF2
	public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {

		try {

			if (a == 0) {
				return null;
			}

			double delta = ((b * b) - 4 * a * c);

			if (delta < 0) {
				return null;
			}

			double x1 = ((-b + Math.sqrt(delta)) / (2 * a));
			double x2 = ((-b - Math.sqrt(delta)) / (2 * a));
			return new Raizes(x1, x2);

		} catch (Exception e) {
			return null;
		}
	}

	// RF3
	public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
		if (verificaAngulosTriangulo(angulo1, angulo2, angulo3)) {
			return true;
		}
		return false;
	}

	// RF4
	public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
		
		if (verificaAngulosTriangulo(angulo1, angulo2, angulo3)) {

			if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90) {
				return "triângulo retângulo";
			}
			if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90) {
				return "triângulo acutângulo";
			}
			if ((angulo1 > 90 || angulo2 > 90 || angulo3 > 90)) {
				if ((angulo1 < 90 && angulo2 < 90) || (angulo1 < 90 && angulo3 < 90)
						|| (angulo2 < 90 && angulo3 < 90)) {
					return "triângulo obtusângulo";
				}
			}
		}

		return "não tem classificação";
	}

	// RF5
	public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
		
		if (lado1 > 0 && lado2 > 0 && lado3 > 0) {
			if ((Math.hypot(lado1, lado2) == lado3) || (Math.hypot(lado1, lado3) == lado2)
					|| (Math.hypot(lado2, lado3) == lado1)) {
				return true;
			}
		}
		return false;
	}

	// RF6
	public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4) {
		if ((angulo1 == angulo2 && angulo1 == angulo3 && angulo1 == angulo4) && (angulo1 == 90)) {
			return true;
		}
		return false;
	}

	// RF7-a
	public double perimetroRetangulo(double lado1, double lado2) {
		return (2 * (lado1 + lado2));
	}

	// RF7-b
	public double areaRetangulo(double lado1, double lado2) {
		return lado1 * lado2;
	}

	// RF8
	public String calculadora(String expressao) {

		try {

			String[] valores = expressao.split(" ");

			if (valores.length > 3 || valores.length < 3) {
				return "Insira uma expressão válida";
			}

			if (valores[2] == "0") {
				return "Não pode ser dividido por zero";
			}

			DecimalFormat saida = new DecimalFormat("0.00");

			if (valores[1].equals("+")) {
				return String.valueOf(saida.format(Double.parseDouble(valores[0]) + Double.parseDouble(valores[2])));
			}
			if (valores[1].equals("-")) {
				return String.valueOf(saida.format(Double.parseDouble(valores[0]) - Double.parseDouble(valores[2])));
			}
			if (valores[1].equals("*")) {
				return String.valueOf(saida.format(Double.parseDouble(valores[0]) * Double.parseDouble(valores[2])));
			}
			if (valores[1].equals("/")) {
				return String.valueOf(saida.format(Double.parseDouble(valores[0]) / Double.parseDouble(valores[2])));
			}
			if (valores[1].equals("**")) {
				return String.valueOf(saida.format(Math.pow(Double.parseDouble(valores[0]), Integer.parseInt(valores[2]))));

			}

		} catch (Exception e) {
			return "Insira uma expressão válida";
		}

		return ("expressão invalida, insira uma expressão correta");
	}

	// RF9-a
	public double areaCirculo(double raio) {
		if (raio > 0) {
			double areaCirculo = (raio * raio) * Math.PI;
			return areaCirculo;
		}
		return 0;
	}

	// RF9-b
	public double perimetroCirculo(double raio) {
		if (raio > 0) {
			double perimetroCirculo = raio * 2 * Math.PI;
			return perimetroCirculo;
		}
		return 0;
	}

	// RF10
	public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
		double pontoA = x2 - x1;
		double pontoB = y2 - y1;
		return Math.hypot(pontoA, pontoB);
	}

	// metodo auxiliar
	private boolean verificaAngulosTriangulo(double a1, double a2, double a3) {
		if ((a1 > 0 && a1 < 180) && (a2 > 0 && a2 < 180) && (a3 > 0 && a3 < 180) && (a1 + a2 + a3 == 180)) {
			return true;
		}
		return false;
	}

}