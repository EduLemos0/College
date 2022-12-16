

import java.util.Scanner;

public class Questao15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String palavra = "";
		boolean acabou = false;
		
		do {
			palavra = scanner.nextLine();
			if(isFim(palavra) == true) {
				//se a palavra digitada for "FIM", cabou o programa :)
				acabou = true;
			}else {
				//não acabou, faça a leitura da palavra
				isPalindromo(palavra,0);
				if(isPalindromo(palavra,0) == true) {
					System.out.println("SIM");
				}else {
					System.out.println("NAO");
				}
			}
			
		}while(acabou == false);
		
	}
	
	
	public static boolean isPalindromo(String palavra, int letra) 
	{ 
		boolean ehPalindromo = true;
		if (letra != (palavra.length() / 2) ) { 
			 
			//Ler ate a metade da string

			if (palavra.charAt(letra) != palavra.charAt((palavra.length() - 1 ) - letra)) {
				
				//Se as letras forem diferentes
			    ehPalindromo = false;
			}
			else { 
				//Se nao
			    ehPalindromo = isPalindromo(palavra,letra + 1);
			}	
		}
		
		return ehPalindromo;
		
	}
	
	 static boolean isFim(String str) {
		if(str.equals("FIM")) {
			return true;
		}else {
			return false;
		}
	}
	 
	
}
