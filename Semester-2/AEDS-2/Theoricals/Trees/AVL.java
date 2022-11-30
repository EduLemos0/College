/*in this code, we'll be creating an AVL tree, which is a binary search tree where the nodes cannot have a height difference greater 
than 1 and smaller than -1*/ 

    //create Node class\\
    //Node class contains a new atribute called level. it will calculate the height of our tree.
    class Node{
        int value;
        int level;
        Node left, right;

        //class constructor
        public Node(int x){
            this.value = x;
            this.level = 1;
            left = right = null;
        }

        //calculate the amount of levels
        public void setLevel() {this.level = Math.max(getLevel(left),getLevel(right));}

        //get level
        public int getLevel(Node curr) {return (curr == null) ? 0 : curr.level;}
    }


    //create AVLTree class\\
    class AVLTree{
        private Node root;

        //initialize tree
        public AVLTree(){root = null;}

        //insert element
        public void insert(int x) throws Exception {
            root = insert(root,x);
        }

        private Node insert(Node curr, int x) throws Exception {
            if(curr == null) {curr = new Node(x);
            }else if(x < curr.value) {curr.left = insert(curr.left,x);
            }else if(x > curr.value) {curr.right = insert(curr.right,x);
            }else{throw new Exception("Insertion error.");}
            return balance(curr);
        }

        //balance tree method
        private Node balance(Node curr) {
            if(curr != null) {
                //calculate height factor
                int factor = curr.getLevel(curr.right) - curr.getLevel(curr.left);
                //if tree is already balanced, when abs value of factor is 1 or 0.
                if(Math.abs(factor) <= 1) {curr.setLevel();
                }else if(factor == 2) {
                    //if factor is 2, it means our tree is unbalanced to the right.
                    int childFactor = curr.getLevel(curr.right.right) - curr.getLevel(curr.right.left);
                    //if childfactor == -1, it means that a Right-Left rotation is needed.
                    if(childFactor == -1) {curr.right = rotateRight(curr.right);}

                    curr = rotateLeft(curr);
                }else if(factor == -2) {
                    //if factor is -2, it means our tree is unbalanced to the left.
                    int childFactor = curr.getLevel(curr.left.right) - curr.getLevel(curr.left.left);
                    //if childFactor == 1, it means that a Left-Right rotation is needed
                    if(childFactor == 1) {curr.left = rotateLeft(curr.left);}

                    curr = rotateRight(curr);
                }
            }
            return curr;
        }


        private Node rotateRight(Node curr){
            Node leftNode = curr.left;
            Node rightLeftNode = leftNode.right;

            leftNode.right = curr;
            curr.left = rightLeftNode;
            
            curr.setLevel();
            leftNode.setLevel();

            return leftNode;
        }

        private Node rotateLeft(Node curr){
            Node rightNode= curr.right;
            Node leftRightNode = rightNode.left;

            rightNode.left = curr;
            curr.right = leftRightNode;

            curr.setLevel();
            rightNode.setLevel();

            return rightNode;
        }
        
        //get string, according to that, see what pathway will the tree take
        public void selectPathway(String s) throws Exception{
            switch(s){
                case "central": centralPathway(root);
                    break;
                
                case "pre": prePathway(root);
                    break;

                case "post": postPathway(root);
                    break;
                
                default: throw new Exception("Error : This pathway method does not exist.");
            }
        }

        //build tree pathway
        private void centralPathway(Node curr){
            if(curr != null){
                centralPathway(curr.left);
                System.out.print(curr.value + " ");
                centralPathway(curr.right);
            }
        }
        
        private void prePathway(Node curr){
            if(curr != null){
                System.out.print(curr.value + " ");
                prePathway(curr.left);
                prePathway(curr.right);
            }
        }

        private void postPathway(Node curr){
            if(curr != null){
                postPathway(curr.left);
                postPathway(curr.right);
                System.err.print(curr.value + " ");
            }
        }

    }

public class AVL{
    public static void main(String[] args) throws Exception{

        AVLTree tree = new AVLTree();
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(6);
        tree.insert(22);
        tree.insert(40);
        tree.insert(30);

        tree.selectPathway("central");
        System.out.println("\n");
        tree.selectPathway("pre");
        System.out.println("\n"); 

        tree.selectPathway("post");
    }
}