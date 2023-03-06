package exerciciosalgoritmo;

import java.util.Scanner;

public class jogoLiGQuaTroOitoPorOito {

	public static void main(String[] args) {
		Scanner buffer = new Scanner(System.in);
		boolean ganhador = false;
		int contador = 1;
		int linha = 8;
		int coluna = 8;
		int[][] matriz = new int[linha][coluna];

		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {

			}
		}
		// Inicio da matriz

		System.out.println();

		int jogador = 1;
		int escolha;
		String nome1;
		String nome2;
		
		System.out.print("Escolha o nome do primeiro jogador: ");
		nome1 = buffer.next();
		
		System.out.print("Escolha o nome do segundo jogador: ");
		nome2 = buffer.next();
		
		while (ganhador == false && contador <= 64) {
			printamatint(matriz, linha, coluna);

			System.out.println();

			System.out.println(" jogador " + jogador + " escolha a coluna de 0 a 7");
			escolha = buffer.nextInt();

			// O jogador vai fazer as jogadas e enquanto nao houver um vencedor ele
			// continuara
			for (int i = matriz.length - 1; i >= 0; i--) {

				if (matriz[i][escolha] == 0) {
					matriz[i][escolha] = jogador;
					break;
				}
			}
			ganhador = vencedor(jogador, matriz);

			if (jogador == 2) {
				jogador = 1;
			} else {
				jogador = 2;
			}
			contador++;
		}

		printamatint(matriz, linha, coluna);

		if (ganhador) {
			if (jogador == 1) {
				System.out.println("jogador " + nome2 + " venceu");
			} else {
				System.out.println("jogador " + nome1 + " venceu");
			}
		} else {
			System.out.println("empate");
		}

	}

	public static void printamatint(int mat[][], int a, int b) {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.printf("%d \t", mat[i][j]);
			}
			System.out.println("");
		}

	}

	private static boolean vencedor(int jogador, int[][] matriz) {
		// checagem de vertical

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length - 3; j++) {
				if (matriz[i][j] == jogador && matriz[i][j + 1] == jogador && matriz[i][j + 2] == jogador
						&& matriz[i][j + 3] == jogador) {
					return true;
				}
			}
		}
		// checagem na horizontal

		for (int i = 0; i < matriz.length - 3; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == jogador && matriz[i + 1][j] == jogador && matriz[i + 2][j] == jogador
						&& matriz[i + 3][j] == jogador) {
					return true;
				}
			}
		}
		// checagem diagonal de baixo para cima

		for (int i = 3; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length - 3; j++) {
				if (matriz[i][j] == jogador && matriz[i - 1][j + 1] == jogador && matriz[i - 2][j + 2] == jogador
						&& matriz[i - 3][j + 3] == jogador) {
					return true;
				}
			}
		}
		// Checagem Diagonal de cima para baixo

		for (int i = 0; i < matriz.length - 3; i++) {
			for (int j = 0; j < matriz[0].length - 3; j++) {
				if (matriz[i][j] == jogador && matriz[i + 1][j + 1] == jogador && matriz[i + 2][j + 2] == jogador
						&& matriz[i + 3][j + 3] == jogador) {
					return true;
				}
			}
		}
		return false;
	}
}
