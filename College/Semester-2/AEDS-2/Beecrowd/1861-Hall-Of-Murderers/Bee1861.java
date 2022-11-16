import java.util.Scanner;

public class Bee1861{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        String murderers[] = new String[20];
        String killed[] = new String[20];
        int m = 0,k = 0;

        while(scanner.hasNext()){
            murderers[m++] = scanner.next();
            killed[k++] = scanner.next();
        }

        System.out.println("HALL OF MURDERERS");

        //create an array, and only let 


        for(int i = 0; i < m; i++){
            //check if murderer name hasn't appeared in killed list
            if(!isDead(murderers[i], killed, k)){
                // if it isn't dead, then we shall count how many kills he have
                int kills = victims(murderers[i], murderers, m);
                System.out.println(murderers[i] + " " + kills);
            }
        }
        scanner.close();
    }

    //count how many times the killer showed up
    static int victims(String name,String murderers[],int m){
        int counter = 0;
        for(int i = 0; i < m; i++){
            if(murderers[i].equals(name)){
                counter++;
            }
        }
        return counter;
    }

    static boolean isDead(String name, String killed[],int k){
        boolean ans = false;
        for (int i = 0; i < k; i++){
            if(killed[i].contains(name)){
                ans = true;
                break;
            }else{
                ans = false;
            }
        }
        return ans;
    }

}