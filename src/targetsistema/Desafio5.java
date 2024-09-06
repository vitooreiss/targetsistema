package targetsistema;

import java.util.Scanner;

public class Desafio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite uma palavra: ");
		String entrada = sc.next();
		String palavra = entrada;
		String saida = "";
		
		inverterPalavra(entrada, saida, palavra);

		sc.close();

	}

	private static void inverterPalavra(String entrada, String saida, String palavra) {

		for (int i = entrada.length() - 1; i >= 0; i--) {
			saida += entrada.charAt(i);
		}

		System.out.println("String invertida: " + saida);

		if (saida.equalsIgnoreCase(palavra)) {
			System.out.println("Essa palavra é um palíndromo !!!");
		}

	}

}
