package targetsistema;

import java.util.Locale;

public class Desafio4 {

	public static void main(String[] args) {

		percentualRepresentacaoEstado();

	}

	private static void percentualRepresentacaoEstado() {

		Locale.setDefault(Locale.US);

		double faturamentoSP = 67836;
		double faturamentoRJ = 36678.66;
		double faturamentoMG = 29229.88;
		double faturamentoES = 27165.48;
		double faturamentoOutros = 19849.53;

		double faturamentoToltal = faturamentoSP + faturamentoRJ + faturamentoMG + faturamentoES + faturamentoOutros;

		double percentualSP = (faturamentoSP / faturamentoToltal) * 100.0;
		double percentualRJ = (faturamentoRJ / faturamentoToltal) * 100.0;
		double percentualMG = (faturamentoMG / faturamentoToltal) * 100.0;
		double percentualES = (faturamentoES / faturamentoToltal) * 100.0;
		double percentualOutros = (faturamentoOutros / faturamentoToltal) * 100.0;

		System.out.println("Percentual por estado: ");
		System.out.printf("SP: %.2f%%%n", percentualSP);
		System.out.printf("RJ: %.2f%%%n", percentualRJ);
		System.out.printf("MG: %.2f%%%n", percentualMG);
		System.out.printf("ES: %.2f%%%n", percentualES);
		System.out.printf("Outros: %.2f%%%n", percentualOutros);

	}

}
