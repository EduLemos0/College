import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        //create matrix
        int mat[][] = new int[lines][columns];

        //fill matrix
        for(int i = 0; i < lines; i++) {
            for(int j = 0; j < columns; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        //amount of test cases
        int amount = scanner.nextInt();

        for(int i = 0; i < amount; i++){
            //size of matrix that we`ll check
            int len = scanner.nextInt();


        }

    }

    static boolean checkMatrix(int len, int mat[][],int lines, int columns){
        boolean containsZero = false;

        for(int i = 0; i < (lines - len + 1); i++){
            for(int j = 0; j < (columns - len + 1); j++){

                for()

            }   
        }


        return containsZero;
    }


}