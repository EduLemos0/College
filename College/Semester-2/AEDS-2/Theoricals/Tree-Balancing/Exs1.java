/*method that reads three integer numbers and insert them in the tree. If this tree has 
3 levels, do one of the 4 rotations shown in this unit*/

class Node{
    int value;
    Node left,right;

    public Node(int x) {
         value = x;
         left = right = null;
    }
}


class tree{
    Node root;
    
    public tree(){
        root = null;
    }

    //insert nodes
    public void insert(int x){
        root = insert(root,x);
    }

    private Node insert(Node curr, int x){
        if(curr == null){curr = new Node(x);
        }else if(x < curr.value){curr.left = insert(curr.left,x);
        }else if(x > curr.value){curr.right = insert(curr.right,x);}
        return curr;
    }

    
    void balancing(){
        if(root.left != null && root.right != null){
            System.out.println("Is already balanced");

        }else if(root.right != null){
            if(root.right.right != null){
                System.out.println("left balance");
                root = rotateLeft(root);
            }else{
                System.out.println("right-left balance");
                root = rotateRightToLeft(root);
            }
        }else{
            if(root.left.right != null){
                System.out.println("left-right balance");
                root = rotateLeftToRight(root);
            }else{
                System.out.println("right balance");
                root = rotateRight(root);
            }
        }
    }


    private Node rotateLeft(Node node){
        Node rigthNode = node.right;
        Node nodeRightLeft = rigthNode.left;

        rigthNode.left = node;
        node.right = nodeRightLeft;

        return rigthNode;
    }


    private Node rotateRight(Node node){
        Node nodeLeft = node.left;
        Node nodeLeftRight = nodeLeft.right;

        nodeLeft.right = node;
        node.left = nodeLeftRight;

        return nodeLeft;
    }

    private Node rotateRightToLeft(Node node){
        node.right = rotateRight(node.right);
        return rotateRight(node);
    }

    private Node rotateLeftToRight(Node node){
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }


    //walk tree
    public void walk(){
        walk(root);
    }


    private void walk(Node curr){
        if(curr != null){
            System.err.print(curr.value + " ");
            walk(curr.left);
            walk(curr.right);
        }
    }

}



public class Exs1{
    public static void main(String[] args){

        tree tree = new tree();

        int arr[] = {3,1,2};

        for(int i = 0; i < arr.length; i++){
            tree.insert(arr[i]);
        }

        tree.walk();
        System.out.println();
        tree.balancing();
        tree.walk();
    }

}


