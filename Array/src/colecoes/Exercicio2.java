package colecoes;

import java.util.ArrayList;

public class Exercicio2 {
	public static void main(String[] args) {
	
		ArrayList<String> enderecos = new ArrayList<String>();
		enderecos.add("Rua Jose Pablo");
		enderecos.add("Rua Guapuã");
		enderecos.add("Av Morumbi");
		
		
		for(String endereco:enderecos) {
			System.out.println(endereco);
		}
		
	
		enderecos.remove(0);


		for(String endereco:enderecos) {
			System.out.println(endereco);
		}
		
		enderecos.get(1);
		
		for(String endereco:enderecos) {
			System.out.println(endereco);
		}
		
		
		enderecos.size();	
		

		for(String endereco:enderecos) {
			System.out.println(endereco);
		}
		
		enderecos.clear();
		

		for(String endereco:enderecos) {
			System.out.println(endereco);
		}
		
		

		
	}

}
