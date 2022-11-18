package ifpb.testesw;

import java.text.DecimalFormat;

//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Interface {

	public static void main(String[] args) {

		FuncionalidadesIF metodos = new Sistema();

		String string1, string2, string3, string4;

		int escolheMetodo = 0;
		
		DecimalFormat saida = new DecimalFormat("0.00");

		while (true) {

			String nome = JOptionPane.showInputDialog("Digite o numero do metodo que deseja usar\n"
					+ "\n1.   Cadastrar Usuario" + "\n2.   Calcular Função de Segundo Grau" + "\n3.   É Triangulo"
					+ "\n4.   É Triangulo Retangulo" + "\n5.   Classifica Triangulo" + "\n6.   É Retangulo"
					+ "\n7.   Perimetro Retangulo" + "\n8.   Area Retangulo" + "\n9.   Calculadora"
					+ "\n10.  Area Circulo" + "\n11.  Perimetro Circulo" + "\n12.  Distancia Entre Dois Pontos");

			try {
				escolheMetodo = Integer.parseInt(nome);

				if (escolheMetodo < 1 || escolheMetodo > 12) {
					throw new Exception();
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor invalido! \nClique em OK e insira um valor valido");
			}

			switch (escolheMetodo) {
			case 1:
				string1 = JOptionPane.showInputDialog("Digite o nome do usuario");
				string2 = JOptionPane.showInputDialog("Digite o email do usuario");
				string3 = JOptionPane.showInputDialog("Digite a senha do usuario");
				Usuario usuario = metodos.cadastraUsuario(string1, string2, string3);
				if (usuario != null) {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Usuario não cadastrado. \nDigite informações validas");
				}
				break;

			case 2:
				string1 = JOptionPane.showInputDialog("Digite o valor de a");
				string2 = JOptionPane.showInputDialog("Digite o valor de b");
				string3 = JOptionPane.showInputDialog("Digite o valor de c");

				try {
					Raizes raizes = metodos.calculaFuncaoSegundoGrau(Double.parseDouble(string1),
							Double.parseDouble(string2), Double.parseDouble(string3));
					if (raizes == null) {
						JOptionPane.showMessageDialog(null, "o Delta é negativo ou o valor de a é zero");
						break;
					}
					JOptionPane.showMessageDialog(null, "o valor das raizes são: " + raizes.toString());

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 3:
				string1 = JOptionPane.showInputDialog("Digite o valor do angulo 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do angulo 2");
				string3 = JOptionPane.showInputDialog("Digite o valor do angulo 3");

				try {
					Boolean retorno = metodos.ehTriangulo(Double.parseDouble(string1), Double.parseDouble(string2),
							Double.parseDouble(string3));
					JOptionPane.showMessageDialog(null, retorno.toString());

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 4:
				string1 = JOptionPane.showInputDialog("Digite o valor do lado 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do lado 2");
				string3 = JOptionPane.showInputDialog("Digite o valor do lado 3");

				try {
					Boolean retorno = metodos.ehTrianguloRetangulo(Double.parseDouble(string1),
							Double.parseDouble(string2), Double.parseDouble(string3));
					JOptionPane.showMessageDialog(null, retorno.toString());

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 5:
				string1 = JOptionPane.showInputDialog("Digite o valor do angulo 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do angulo 2");
				string3 = JOptionPane.showInputDialog("Digite o valor do angulo 3");

				try {
					String retorno = metodos.classificaTriangulo(Double.parseDouble(string1),
							Double.parseDouble(string2), Double.parseDouble(string3));
					JOptionPane.showMessageDialog(null, retorno);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 6:
				string1 = JOptionPane.showInputDialog("Digite o valor do angulo 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do angulo 2");
				string3 = JOptionPane.showInputDialog("Digite o valor do angulo 3");
				string4 = JOptionPane.showInputDialog("Digite o valor do angulo 4");

				try {
					Boolean retorno = metodos.ehRetangulo(Double.parseDouble(string1), Double.parseDouble(string2),
							Double.parseDouble(string3), Double.parseDouble(string4));
					JOptionPane.showMessageDialog(null, retorno.toString());

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 7:
				string1 = JOptionPane.showInputDialog("Digite o valor do lado 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do lado 2");

				try {
					Double retorno = metodos.perimetroRetangulo(Double.parseDouble(string1),
							Double.parseDouble(string2));
					JOptionPane.showMessageDialog(null, "o perimetro é: " + saida.format(retorno));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 8:
				string1 = JOptionPane.showInputDialog("Digite o valor do lado 1");
				string2 = JOptionPane.showInputDialog("Digite o valor do lado 2");

				try {
					Double retorno = metodos.areaRetangulo(Double.parseDouble(string1), Double.parseDouble(string2));
					JOptionPane.showMessageDialog(null, "A area do retangulo é: " + saida.format(retorno));
					

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 9:
				string1 = JOptionPane.showInputDialog("Digite a expressão");

				try {
					
					String retorno = metodos.calculadora(string1);
					JOptionPane.showMessageDialog(null, retorno);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insira uma expressão válida");
				}

				break;

			case 10:
				string1 = JOptionPane.showInputDialog("Digite o valor do raio");

				try {
					Double retorno = metodos.areaCirculo(Double.parseDouble(string1));
					JOptionPane.showMessageDialog(null, "A area do circulo é: " + saida.format(retorno));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 11:
				string1 = JOptionPane.showInputDialog("Digite o valor do raio");

				try {
					Double retorno = metodos.perimetroCirculo(Double.parseDouble(string1));
					JOptionPane.showMessageDialog(null, "O perimetro do circulo é: " + saida.format(retorno));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;

			case 12:
				string1 = JOptionPane.showInputDialog("Digite o valor do ponto x1");
				string2 = JOptionPane.showInputDialog("Digite o valor do ponto x2");
				string3 = JOptionPane.showInputDialog("Digite o valor do ponto y1");
				string4 = JOptionPane.showInputDialog("Digite o valor do ponto y2");

				try {
					Double retorno = metodos.distanciaEntreDoisPontos(Double.parseDouble(string1),
							Double.parseDouble(string2), Double.parseDouble(string3), Double.parseDouble(string4));
					JOptionPane.showMessageDialog(null, "A distancia é: " + saida.format(retorno));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Valor(es) invalido(s)!, \n Clique em OK para selecionar uma nova função.");
				}
				break;
			}
		}
	}
}
