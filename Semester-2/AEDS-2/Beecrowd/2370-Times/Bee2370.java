import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.AEADBadTagException;

public class Bee2370{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int players = scanner.nextInt();
        int teams = scanner.nextInt();

        int skill[] = new int[players];
        String names[] = new String[players];
        
        //add values to both arrays
        for(int i = 0; i < players; i++){
            names[i] = scanner.next();
            skill[i] = scanner.nextInt();
        }

        //sort by skill level - when swapping the number, we'll also swap the name
        for(int i = 0; i < players - 1; i++){
            for(int j = i+1; j < players; j++){
                if(skill[i] < skill[j]){
                    int tmp = skill[i];
                    skill[i] = skill[j];
                    skill[j] = tmp;
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
 
        newTeam(names, teams);        

    }


    static void newTeam(String arr[],int teams){
        
        for(int i = 0; i < teams; i++){
            String currTeam[] = new String[(arr.length/teams) + 1];
            int size = 0;
            
            for(int j = i; j < arr.length; j+=teams){
                currTeam[size++] = arr[j];
            }
        
            sort(currTeam);
            System.out.println("Time " + (i+1));
            show(currTeam);
        }

        

    }

    static void show(String arr[]) {
        int n = arraySize(arr);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

        System.out.println();
    }


    static void sort(String arr[]){
        int n = arraySize(arr);

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i].compareTo(arr[j]) > 0){
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static int arraySize(String[] array) {
        int counter = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] != null) { counter++; } 
            else { i = array.length; }
        }

        return counter;
    }



}