package colecoes;


import java.util.Random;

public class Exercicio {
	 public static void main(String[] args) {
	        int[] vetor1 = new int[10];
	        int[] vetor2 = new int[15];

	        vetor1[0] = 652;
	        vetor1[1] = 996;
	        vetor1[2] = 457;
	        vetor1[3] = -322;
	        vetor1[4] = 893;
	        vetor1[5] = 191;
	        vetor1[6] = 450;
	        vetor1[7] = -323;
	        vetor1[8] = 871;
	        vetor1[9] = 194;

	        int contador = 0;
	        for (int valor : vetor1) {
	            vetor2[contador] = valor;
	            contador++;
	        }
	        for (int x = 0; x < vetor2.length; x++) {
	            if (vetor2[x] == 0) {
	                vetor2[x] = new Random().nextInt(100);
	            }
	        }
	        for (int x : vetor2) {
	            System.out.println(x);
	        }
	        
	        
	        	
	        }
	 }
