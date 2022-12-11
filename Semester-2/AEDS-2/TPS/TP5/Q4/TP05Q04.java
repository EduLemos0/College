


//create Node class\\
class Node{
    public boolean color;
    public String name;
    public Node right,left;

    //class constructors
    public Node() {this.name = null;}

    public Node(String s){
        this.name = s;
        color = false;
        left = right = null;
    }

    public Node(String s, boolean color){
        name = s;
        this.color = color;
        left = right = null;
    }
}


//create Red-Black Tree class\\
class Tree{
    Node root;

    //class constructors
    public Tree() {root = null;}

    //insertion methods
    public void insert(String s) throws Exception {
        //
    } 

}




//create 