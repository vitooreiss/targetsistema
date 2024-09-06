package targetsistema;

import java.util.Scanner;


public class Desafio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite um numero para verificar se pertence a sequencia Fibonacci:  ");
		int n = sc.nextInt();

		if (fibonacci(n)) {
			System.out.println("O numero " + n + " pertence a sequencia de Fibonacci. ");
		} else {
			System.out.println("O numero " + n + " nao pertence a sequencia de Fibonacci. ");
		}

		sc.close();

	}


	private static boolean fibonacci(int n) {
		if (n < 0)
			return false;

		int a = 0, b = 1;

		if (n == a || n == b)
			return true;

		while (b <= n) {
			int prox = a + b;
			a = b;
			b = prox;
			if (b == n)
				return true;
		}
		return false;
	}
}
