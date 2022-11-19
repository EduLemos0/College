import java.util.*;

//------- create Node class -------\\
class Node{
    int value;
    Node right,left,up,down;

    //class constructors
    public Node(){
        value = -1; //applied only to head element
        right = left = up = down = null;
    }

    public Node(int x){
        value = x;
        right = left = down = up = null;
    }
}

//------- create Matrix class -------\\
class Matrix{
    Node flag;
    int line,column;
    public static Scanner scanner = new Scanner(System.in);
    
    //class constructor
    public Matrix(int l, int c){
        flag = new Node();
        this.line = l;
        this.column = c;

        flag.down = new Node();
        Node tmp = flag.down;
        //build first line
        for(int i = 0; i < column - 1; i++){
            tmp.right = new Node();
            tmp.right.left = tmp;
            tmp = tmp.right;
        }
        Node p;
        Node firstPosition = flag.down;

        for(int i = 0; i < line - 1; i++){
            tmp = firstPosition;
            tmp.down = new Node();
            p = tmp.down;
            p.up = tmp;
            
            for(int j = 0 ; j < column - 1; j++){
                p.right = new Node();
                p.right.left = p;
                p = p.right;
                tmp = tmp.right;
                p.up = tmp;
                tmp.down = p;
            }
            firstPosition = firstPosition.down;
        }
    }

    //insert elements into matrix
    public void insert(){
        Node firstPosition = flag.down;
        Node tmp;
        for(int i = 0; i < line; i++){
            tmp = firstPosition;
            for(int j = 0; j < column; j++){
                tmp.value = scanner.nextInt();
                tmp = tmp.right;
            }
            firstPosition = firstPosition.down;
        }
    }
    
    //show matrix
    public void show(){
        Node firstPosition = flag.down;
        Node tmp;
        for(int i = 0; i < line; i++){
            tmp = firstPosition;
            for(int j = 0; j < column; j++){
                System.out.print(tmp.value + " ");
                tmp = tmp.right;
            }
            System.out.println();
            firstPosition = firstPosition.down;
        }
    }

    //get main diagonal of matrix
    public void mainDiagonal(){
        for(Node tmp = flag.down; tmp != null; tmp = tmp.down){
            System.out.print(tmp.value + " ");
            if(tmp.right != null){tmp = tmp.right;};
        }
        System.out.println();
    }

    //get secondary diagonal of matrix
    public void secondaryDiagonal(){
        Node lastPos = flag.down;
        //move lastPos to the last position of the first line
        while(lastPos.right != null){lastPos = lastPos.right;}
        for(Node tmp = lastPos; tmp != null; tmp = tmp.down){
            System.out.print(tmp.value + " ");
            if(tmp.left != null){tmp = tmp.left;}
        }
        System.out.println();
    }

    //sum between two matrixes
    public void sum(Matrix m2){
        Node fp = flag.down;
        Node fp2 = m2.flag.down;
        for(int i = 0; i < line; i++){
            Node tmp = fp;
            Node tmp2 = fp2;
            for(int j = 0; j < column; j++){
                int sum = tmp.value + tmp2.value;
                System.out.print(sum + " ");
                tmp = tmp.right;
                tmp2 = tmp2.right;
            }
            fp = fp.down;
            fp2 = fp2.down;
            System.out.println();
        }
    }

    //multiplication between two matrixes
    public void product(Matrix m2){
        //in the first matrix, we'll only move lines, in the second, columns
        Node tmp = flag.down;
        Node tmp2 = m2.flag.down;
        int ans = 0;
        for(int i = 0 ; i < line; i++){
            Node fp = tmp;
            Node fp2 = tmp2;
            for(int j = 0; j < column; j++){ 
                for(int k = 0; k < column; k++){
                    ans += (tmp.value * tmp2.value);
                    tmp = tmp.right;
                    tmp2 = tmp2.down;
                }
                System.out.print(ans + " ");
                ans = 0;
                tmp2 = fp2.right;
                tmp = fp;
            }
            ans = 0;
            tmp = fp.down;
            tmp2 = fp2;
            System.out.println();
        }
    }


    public static void main(String[] args){
        
        int cases = scanner.nextInt();

        for(int i = 0; i < cases; i++){
            int lines = scanner.nextInt();
            int columns = scanner.nextInt();
            Matrix matrix = new Matrix(lines, columns);
            matrix.insert();
            matrix.mainDiagonal();
            matrix.secondaryDiagonal();
            //build matrix2
            lines = scanner.nextInt();
            columns = scanner.nextInt();
            Matrix matrix2 = new Matrix(lines, columns);
            matrix2.insert();
            // matrix2.mainDiagonal();
            // matrix2.secondaryDiagonal();
            matrix.sum(matrix2);
            matrix.product(matrix2);
        }
    }
}