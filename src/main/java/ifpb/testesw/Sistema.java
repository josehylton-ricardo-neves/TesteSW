package ifpb.testesw;

//import java.math.*;

public class Sistema implements FuncionalidadesIF {

	public Usuario cadastraUsuario(String nome, String email, String senha) {
		return null;
	}

	public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
		return null;
	}

	public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
		if (verificaAngulosTriangulo(angulo1, angulo2, angulo3)) {
			return true;
		}
		return false;
	}
	
	public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
		if (verificaAngulosTriangulo(angulo1, angulo2, angulo3)) {
			
			if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90) {
				return "triângulo retângulo";
			}
			if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90) {
				return "triângulo acutângulo";
			}
			if ((angulo1 > 90 || angulo2 > 90 || angulo3 > 90)) {
				if ((angulo1 < 90 && angulo2 < 90) || (angulo1 < 90 && angulo3 < 90) || (angulo2 < 90 && angulo3 < 90)) {
					return "triângulo obtusângulo";
				}
			}
		}
		
		return "não tem classificação";
	}

	public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
		if (lado1 > 0 && lado2 > 0 && lado3 > 0) {
			if((Math.hypot(lado1, lado2) == lado3) || (Math.hypot(lado1, lado3) == lado2) || (Math.hypot(lado2, lado3) == lado1)) {
				return true;
			}	
		}
		return false;
	}

	public boolean ehRetangulo(double lado1, double lado2, double lado3, double lado4) {
		if ((lado1 == lado2 && lado1 == lado3 && lado1 == lado4) && (lado1 != 0)) {
			return true;
		}
		if ((lado1 == lado2 && lado3 == lado4) || (lado1 == lado3 && lado2 == lado4) || (lado1 == lado4 && lado2 == lado3)) {
			if (lado1 != 0 && lado2 != 0 && lado3 != 0 && lado4 != 0) {
				return true;
			}
		}
		return false;
	}

	public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) {
		double perimetro = lado1 + lado2 + lado3 + lado4;
		return perimetro;
	}

	public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) {
		return 0;
	}

	public double calculadora(String expressao) {
		return 0;
	}

	public double areaCirculo(double raio) {
		double areaCirculo = (raio*raio) * Math.PI;
		return areaCirculo;
	}

	public double areaPerimetro(double raio) {
		double perimetroCirculo = raio * 2 * Math.PI;
		return perimetroCirculo;
	}

	public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
		double pontoA = x2 - x1;
		double pontoB = y2 - y1;
		return Math.hypot(pontoA, pontoB);
	}
	
	
	
	private boolean verificaAngulosTriangulo(double a1, double a2, double a3) {
		if ((a1 > 0 && a1 < 180) && (a2 > 0 && a2 < 180) && (a3 > 0 && a3 < 180) && (a1 + a2 + a3 == 180)) {
			return true;
		}
		return false;
	}

}