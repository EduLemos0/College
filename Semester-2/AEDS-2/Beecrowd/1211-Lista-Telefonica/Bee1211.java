import java.util.Scanner;
import java.io.IOException;

public class Bee1211 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        if (size == 1) {
            scanner.close();
            throw new Exception("List must contain two or more phone numbers");
        }
        String phones[] = new String[size];

        int ans = 0;

        // fill array
        for (int i = 0; i < size; i++) {
            phones[i] = scanner.nextLine();
        }

        // compare 1 with two, two with three and so on...
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                int comp = checkSavedCharacters(phones[i], phones[i + 1]);
                ans = (ans < comp)
                        ? comp
                        : ans;
            }
        }

        System.out.println(ans);
        scanner.close();
    }

    static int checkSavedCharacters(String s1, String s2) {
        int amount = 0;
        // check to see if both phone numbers have the same amount of characters
        if (s1.length() != s2.length()) {
            return 0;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    amount++;
                }
            }
        }
        return amount;
    }

}