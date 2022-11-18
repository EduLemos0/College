package tp2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// @author Eduardo Lemos

public class Q4 {
	
	static boolean ended (String s) {
		return(s.equals("FIM"));
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] entry1 = new String[1000];
		int numEntry1 = 0;
		int numEntry2 = 0;
		String[] entry2 = new String[1000];
		
		do {
			entry1[numEntry1] = scanner.nextLine();
		}while(!(ended(entry1[numEntry1++])));
		numEntry1--;
		
		do {
			entry2[numEntry2] = scanner.nextLine();
		}while(!(ended(entry2[numEntry2++])));
		numEntry2--;
		
		scanner.close();
		
		
		String[] array = new String[numEntry1];
		
		 scanner = new Scanner(new File("/tmp/games.csv"));
		 
		 int j = 0;
		 
		 while(scanner.hasNext()) {
			 String s = scanner.nextLine();
			 String[] splitted = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			 
			 
			 for(int i = 0; i < numEntry1; i++) {
				 if(splitted[0].equals(entry1[i])) {
					 array[j] = splitted[1];
					 j++;
				 }
			 }
		 }
		 scanner.close();
		 
		 Arrays.sort(array);
		 
		 for(int i = 0; i < numEntry2; i++) {
			 
			 //see if outcome is true or not
			 if(binarySearch(array,entry2[i]) == -1) {
				 System.out.println("NAO");
			 } else {
				 System.out.println("SIM");
			 }
			 
		 }
		
	}
	
	static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = x.compareTo(arr[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return -1;
    }
	
}
