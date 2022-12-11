//create hash class\\
class Hash{
    int table[];
    int space, save, total, backup;
    final int NUL = -1;

    //class constructor
    public Hash(){
        space = 13;
        save = 7;
    }

    public Hash(int m1, int m2){
        this.space = m1;
        this.save = m2;
        this.total = m1+m2;
        this.backup = 0;
        table = new int[total];
        //fill table with NUL values
        for(int i = 0; i < total; i++) {table[i] = NUL;}
    }

    //create hash function
    public int h(int value) {return value % space;}

    //insert
    public boolean insert(int x){
        boolean ans = false;
        if(x != NUL){
            int pos = h(x);
            if(table[pos] == NUL){
                table[pos] = x;
                ans = true;
            }else if(backup < save){
                table[space + backup] = x;
                backup++;
                ans = true;
            }
        }                                   
        return ans;
    }


    //remove
    boolean remove(int x){
        boolean ans = false;
        if(x != NUL){
            //get hash position
            int pos = h(x);
            if(table[pos] == x){ //means that we've found our element
                table[pos] = NUL;
                //check shifting in backup space
                for(int i = 0; i < backup; i++){
                    if table[]
                }
                ans = true;
            }
        }

        return ans;
    }

}




public class Main{
    public static void main(String[] args){

    }
}