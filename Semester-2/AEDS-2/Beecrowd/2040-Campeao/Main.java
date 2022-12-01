import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        //read amount of teams and their scores
        int qt = Integer.parseInt(scanner.nextLine());
        String names[] = new String[qt];
        int score[] = new int[qt];
        for(int i = 0; i < qt; i++){
            String s = scanner.nextLine();
            String splitted[] = s.split(" ");
            names[i] = splitted[0];
            score[i] = Integer.parseInt(splitted[1]);
        }

        for(int i = 0; i < qt/2; i++){
            String s = scanner.nextLine();
            //read and distribute scores
            String team1[] = s.split("-")[0].split(" ");
            String team2[] = s.split("-")[1].split(" ");
            
            //add values to each game, for that we shall get the position
            int p1 = getPosition(team1[0], names);
            int p2 = getPosition(team2[0], names);

            //get amount of goals
            int goals1 = Integer.parseInt(team1[1]);
            System.out.println(team2[1]);
            int goals2 = Integer.parseInt(team2[0]);

            //add goals
            score[p1] += goals1;
            score[p2] += goals2;

            if(goals1 == goals2){
                score[p1] += 1;
                score[p2] += 1;
            }else if(goals1 < goals2){
                score[p2] += 5;
            }else{
                score[p1] += 5;
            }
        }

        //after all that bullshit, let's see who's the winner
        int ans = getWinner(score);

        if(names[ans] == "Sport"){
            System.out.println("O Sport foi o campeao com " + score[ans] + " pontos : D");
        }else{
            System.out.println("O Sport nao foi o campeao. O time campeao foi o " + names[ans] + " com " + score[ans] + " pontos : (");
        }

        scanner.close();
    }

    static int getWinner(int score[]){
        //get position of highest element
        int num = 0; 
        for(int i = 0; i < score.length; i++) if(score[i] > num) num = score[i];

        int pos = 0;

        for(int i = 0; i < score.length; i++) if(score[i]  == num) pos = i;
        
        return pos;
    }


    static int getPosition(String name, String teams[]){
        int pos = 0;
        for(int i = 0; i < teams.length; i++){
            if(name == teams[i]){
                pos = i;
                break;          
            }
        }
        return pos;
    }
}