import java.util.Scanner; 

class TP01Q03 {


    public static boolean ended(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    }

    public static String cesar(String s) {
        int chave = 3;
        char[] crypto = new char[s.length()];
        for (int i = 0; i < s.length(); i ++) {
        if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
        crypto[i] = (char)(((((int) s.charAt(i) - 'A') + chave) % 26) + 'A');
        }
        else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            crypto[i] = (char)(((((int) s.charAt(i) - 'a') + chave) % 26) + 'a');
        }
        else if (s.charAt(i) > 0 && s.charAt(i) < 127) {
            crypto[i] += (s.charAt(i) + chave);
        }
       else{
            crypto[i] = s.charAt(i);
        }
        }
        String str = String.valueOf(crypto);
        System.out.println(str);
        return str;
    }         

public static void main (String[] args) {
     // criar scanner
     Scanner scanner = new Scanner(System.in);
     String[] str = new String[1000];
     int y = 0; // numero de strings
     // ler palavras
     do {
         str[y] = scanner.nextLine(); 
     } while (ended(str[y++]));
     y--; //desconsiderar FIM

     for (int i = 0; i < y; i++) 
    cesar(str[i]);
}    
}