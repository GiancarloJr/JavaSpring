package atividade3011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class testes {

	public static int fatorial(int x) {
		if (x == 1 || x == 0) {
			return 1;
		}
		return x * fatorial(x - 1);
	}

	public static List<String> duplicates(List<String> palavras) {

		List<String> result = new ArrayList<>();

		for (String palavra : palavras) {
			char[] teste = palavra.toCharArray();
			for (int i = 0; i < palavra.length() - 1; i++) {
				if (teste[i] == teste[i + 1]) {
					teste[i] = '*';
				}
			}
			palavra = String.copyValueOf(teste);
			palavra = palavra.replace("*", "");
			result.add(palavra);
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int num = 5;
		List<String> duplicates = Arrays.asList("abracadabra", "allottee", "assessee", "kelless", "keenness",
				"Alfaalggo");

		System.out.println("O fatorial do numero: " + fatorial(num));

		System.out.println(duplicates(duplicates));

	}
}
