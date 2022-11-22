/*in this code, we'll be creating an AVL tree, which is a binary search tree where the nodes cannot have a height difference greater 
than 1 and smaller than -1*/ 

//create Node class\\
//Node class contains a new atribute called level. it will calculate the height of our tree.
class Node{
    public int element;
    public Node left,right;
    public int level;

    //class constructor always set level to 1
    public Node(int x){
        element = x;
        left = right = null;
        level = 1;
    }

    //setLevel will set the level according to a node. And then compare which level is higher
    public void setLevel(){
		this.level = 1 + Math.max(getLevel(left), getLevel(right));
    }

    //gets level of current element;
    public int getLevel(Node curr){
        return (curr == null) ? 0 : curr.level;
    }
}

//create AVL class\\
class AVLTree{
    public Node root;

    //initialize tree
    public AVLTree(){
        root = null;
    }

    //insertion
    public void insert(int x) throws Exception{
        root = insert(x, root);
        System.out.println(root.getLevel(root));
    }   

    private Node insert(int x, Node curr) throws Exception{
        if(curr == null){curr = new Node(x);
        }else if(x < curr.element){ curr.left = insert(x, curr.left);
        }else if(x > curr.element){ curr.right = insert(x, curr.right);
        }else{
            throw new Exception("Insertion error.");
        }
        return balance(curr);
    }


    //balance method will balance the current node, checking if it's height is between the accepted limits
    private Node balance(Node curr) throws Exception{ 
        if(curr != null){
            int factor = (curr.getLevel(curr.right) - curr.getLevel(curr.left));
            if(factor <= 1){curr.setLevel();
            }else if(factor == 2){
                int childFactor = curr.getLevel(curr.right.right) - curr.getLevel(curr.right.left);

                if(childFactor == - 1){curr.right = rotateRight(curr.right);}
                
                curr = rotateLeft(curr);
            }else if(factor == -2){
                int childFactor = curr.getLevel(curr.left.right) - curr.getLevel(curr.left.left);

                if(childFactor == 1){curr.left = rotateLeft(curr.left);}

                curr = rotateRight(curr);
            }else{
                throw new Exception("You doing something wrong bro");
            }
        }
        return curr;
    }


    //rotation methods
    private Node rotateRight(Node curr){
        Node leftNode = curr.left;
        Node leftRightNode = curr.left.right;

        leftNode.right = curr;
        curr.left = leftRightNode;

        return leftNode;
    }

    private Node rotateLeft(Node curr){
        Node rightNode = curr.right;
        Node rightLeftNode = rightNode.left;

        rightNode.left = curr;
        curr.right = rightLeftNode;

        return rightNode;
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
    }
}