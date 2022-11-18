import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

*/
@author Eduardo Lemos Paschoalini
*/

public class Q3 {
	
	static boolean ended (String s) {
		return(s.equals("FIM"));
	}
	
	static ArrayList<String> array = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] entry1 = new String[1000];
		int numEntry1 = 0;
		int numEntry2 = 0;
		String[] entry2 = new String[1000];
		
		
		//preenche primeiro array com os IDS
		do {
			entry1[numEntry1] = scanner.nextLine();
		}while(!(ended(entry1[numEntry1++])));
		numEntry1--; // tira o "FIM" da length, mas nao removendo-o do array
		
		
		//preenche segundo array com os nomes
		do {
			entry2[numEntry2] = scanner.nextLine();
		}while(!(ended(entry2[numEntry2++])));
		numEntry2--; // tira o "FIM" da length, mas nao removendo-o do array
		
		scanner.close();
		
		 scanner = new Scanner(new File("/tmp/games.csv")); // ler games.csv
		 while(scanner.hasNext()) { // while hasnext pega linha por linha
			 String s = scanner.nextLine(); // pega linha
			 String[] splitted = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //regex para separar os diferentes elementos 
			 
			 for(int i = 0; i < numEntry1; i++) {
				 if(splitted[0].equals(entry1[i])) { // se o id apresentado na linha e igual ao id na entrada1, colocamos no arrayList de string 
					 array.add(splitted[1]);
				 }
			 }
		 }
		 scanner.close();
		 
		 for(int i = 0; i < numEntry2; i++) {
			 boolean found = false;
			 if(array.contains(entry2[i])) {
				 found = true;
			 }
			 
			 System.out.println(found?"SIM":"NAO");
		 }
		 
		
	}
}
