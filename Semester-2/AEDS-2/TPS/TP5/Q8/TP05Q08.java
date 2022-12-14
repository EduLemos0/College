// @author Eduardo Lemos Paschoalini
// more codes on https://github.com/EduLemos0
import java.util.Scanner;


//create Node class\\
class Node {
    int value;
    Node left,right;

    //class constructor
    public Node (int x) {
        value = x;
        left = right = null;
    }
}


//create Tree class\\
class Tree {
    Node root;

    //class constructor
    public Tree() {
        root = null;
    }


    //insert in tree
    public void insert (int x) {
        root = insert(x,root);
    }

    private Node insert (int x, Node curr) {
        if(curr == null) {curr = new Node(x);
        }else if(x < curr.value) {curr.left = insert(x,curr.left); 
        }else if(x > curr.value) { curr.right = insert(x,curr.right);}

        return curr;
    }

    //central Pathway
    public void central () {
        System.out.print("In..: ");
        central(root);
        System.out.println();
    }

    private void central (Node curr) {
        if(curr != null) {
            central(curr.left);
            System.out.print(curr.value + " ");
            central(curr.right);
        }
    }

    //Post pathway
    public void post () {
        System.out.print("Post: ");
        post(root);
        System.out.println();
    }

    private void post (Node curr) {
        if(curr != null) {
            post(curr.left);
            post(curr.right);
            System.out.print(curr.value + " ");
        }
    }

    //pre pathway
    public void pre () {
        System.out.print("Pre.: ");
        pre(root);
        System.out.println();
    }

    private void pre (Node curr) {
        if(curr != null) {
            System.out.print(curr.value + " ");
            pre(curr.left);
            pre(curr.right);
        }
    }

}

//main class\\
public class TP05Q08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        int amount = 0;

        for(int i = 0; i < cases; i++) {
            Tree tree = new Tree();

            System.out.println("Case " + (i+1) + ":");

            amount = scanner.nextInt();
            
            for(int j = 0; j < amount; j++) {
                tree.insert(scanner.nextInt());
            }

            tree.pre();
            tree.central();
            tree.post();
            System.out.println();
        }
        scanner.close();
    }
}
