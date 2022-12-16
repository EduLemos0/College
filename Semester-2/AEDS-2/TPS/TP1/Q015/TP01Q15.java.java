
import java.util.Scanner;

public class Questao15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String entrada ="";
		boolean stop = false;
		//temos 4 respostas: vogal,consoante,int e float
		int resposta[] = new int[4];
		
		
		do {
			entrada = scanner.nextLine();
			if(entrada.equals("FIM")) {
				stop = true;
			}else {
				if(checkVogal(entrada,0)) {
					System.out.println("SIM NAO NAO NAO");
				}else {
					if(checkConsoante(entrada,0)) {
						System.out.println("NAO SIM NAO NAO");
					}else {
						if(checkInt(entrada,0)) {
							System.out.println("NAO NAO SIM SIM");
						}else {
							if(checkNumero(entrada,0,0)) {
								System.out.println("NAO NAO NAO SIM");
							}else {
								System.out.println("NAO NAO NAO NAO");
							}
						}
					}
				}
			}
		}while(stop == false);
	}
	
	
	static boolean checkVogal(String entrada,int letra) {
		//colocamos tudo em toLowerCase para facilitar o processo de análise das vogais e consoantes
		entrada = entrada.toLowerCase();
		
		if(entrada.length() == letra) {
			return true;
		}else {
			if(entrada.charAt(letra)=='a' ||entrada.charAt(letra)=='e' ||entrada.charAt(letra)=='i' ||entrada.charAt(letra)=='o' ||entrada.charAt(letra)=='u') {
				return checkVogal(entrada,letra+1);
			}else {
				return false;
			}
		}
	}
	
	static boolean checkConsoante(String entrada,int letra) {
		//colocamos tudo em toLowerCase para facilitar o processo de análise das vogais e consoantes
		entrada = entrada.toLowerCase();
		
		if(entrada.length() == letra) {
			return true;
		}else {
			// vamos conferir se todos os caracteres são de fato LETRAS, e se são consoantes
			if((entrada.charAt(letra) != 'a' && entrada.charAt(letra) != 'e' && entrada.charAt(letra) != 'i' && entrada.charAt(letra) != 'o' && entrada.charAt(letra) != 'u' && (int)entrada.charAt(letra) >= 97 && (int)entrada.charAt(letra) <= 122  )) {
				return checkConsoante(entrada,letra+1);
			}else {
				return false;
			}
		}
	}
	
	static boolean checkInt(String entrada,int letra) {
		//verificaremos a seguir a existência de numeros inteiros, ou seja, sem o ponto
		// 48 ao 57 na tabela ASCII
		
		if(entrada.length() == letra) {
			return true;
		}else {
			if(((int)entrada.charAt(letra) >= 48 && (int)entrada.charAt(letra) <= 57 )) {
				return checkInt(entrada,letra+1);
			}else {
				return false;
			}
		}
	}
	
	
	static boolean checkNumero(String entrada, int letra, int qntPnt) {
		if(entrada.length() == letra) {
			return true;
		} else {
			if(((int)entrada.charAt(letra) >= 48 && (int)entrada.charAt(letra) <= 57)) {
				return checkNumero(entrada, letra + 1, qntPnt);
			} else if ((entrada.charAt(letra) == '.' || entrada.charAt(letra) == ',')) {
				if(qntPnt == 0) {
					return checkNumero(entrada,letra + 1, 1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
	}
	
}
