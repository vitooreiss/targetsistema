package targetsistema;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.JSONArray;
import org.json.JSONObject;

public class Desafio3 {

	public static void main(String[] args) {

		String jsonFilePath = "faturamento.json";
		JSONArray faturamentoArray = readJsonArrayFromFile(jsonFilePath);

		if (faturamentoArray != null) {
			double menorValor = calcularMenorValor(faturamentoArray);
			double maiorValor = calcularMaiorValor(faturamentoArray);
			double mediaMensal = calcularMediaMensal(faturamentoArray);
			int diasAcimaDaMedia = contarDiasAcimaDaMedia(faturamentoArray, mediaMensal);

			exibirResultados(menorValor, maiorValor, diasAcimaDaMedia);
		}
	}

	private static JSONArray readJsonArrayFromFile(String filePath) {
		try (Reader reader = new FileReader(new File(filePath))) {
			StringBuilder jsonContent = new StringBuilder();
			int ch;
			while ((ch = reader.read()) != -1) {
				jsonContent.append((char) ch);
			}
			return new JSONArray(jsonContent.toString());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static double calcularMenorValor(JSONArray faturamentoArray) {
		double menorValor = Double.MAX_VALUE;
		for (int i = 0; i < faturamentoArray.length(); i++) {
			JSONObject dia = faturamentoArray.getJSONObject(i);
			double valor = dia.getDouble("valor");
			if (valor > 0 && valor < menorValor) {
				menorValor = valor;
			}
		}
		return menorValor;
	}

	private static double calcularMaiorValor(JSONArray faturamentoArray) {
		double maiorValor = Double.MIN_VALUE;
		for (int i = 0; i < faturamentoArray.length(); i++) {
			JSONObject dia = faturamentoArray.getJSONObject(i);
			double valor = dia.getDouble("valor");
			if (valor > maiorValor) {
				maiorValor = valor;
			}
		}
		return maiorValor;
	}

	private static double calcularMediaMensal(JSONArray faturamentoArray) {
		double somaFaturamento = 0;
		int diasComFaturamento = 0;
		for (int i = 0; i < faturamentoArray.length(); i++) {
			JSONObject dia = faturamentoArray.getJSONObject(i);
			double valor = dia.getDouble("valor");
			if (valor > 0) {
				somaFaturamento += valor;
				diasComFaturamento++;
			}
		}
		return somaFaturamento / diasComFaturamento;
	}

	private static int contarDiasAcimaDaMedia(JSONArray faturamentoArray, double mediaMensal) {
		int diasAcimaDaMedia = 0;
		for (int i = 0; i < faturamentoArray.length(); i++) {
			JSONObject dia = faturamentoArray.getJSONObject(i);
			double valor = dia.getDouble("valor");
			if (valor > mediaMensal) {
				diasAcimaDaMedia++;
			}
		}
		return diasAcimaDaMedia;
	}

	private static void exibirResultados(double menorValor, double maiorValor, int diasAcimaDaMedia) {
		System.out.println("Menor valor de faturamento: " + menorValor);
		System.out.println("Maior valor de faturamento: " + maiorValor);
		System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
	}
}