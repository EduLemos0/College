//@author Eduardo Lemos Paschoalini

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.xml.stream.EventFilter;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class TP05Q03 {
	
	public static HashMap<Integer, Game> map = new HashMap<>();
	
	
	static boolean ended(String s) {
		return (s.equals("FIM"));
	}
	
	public static void main(String[] args) throws Exception {
		cleanInfo();
        //create entry1 and entry2 to storage the given data
		String[] entry1 = new String[1000];
		String[] entry2 = new String[1000];
        String[] searchEntry = new String[1000];
		Scanner scanner = new Scanner(System.in);
		AVL tree = new AVL(); // create list of objects
        int sz;

		int entryNumber1 = 0;
        int entryNumber2 = 0;
        int entryNumber3 = 0;
		
		//fill entry1 variable with the IDs
		do {
			entry1[entryNumber1] = scanner.nextLine();
		} while(ended(entry1[entryNumber1++]) != true);
		entryNumber1--;
		
		//fill entry 2
        sz = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < sz; i++) {
            entry2[entryNumber2++] = scanner.nextLine();
        }

        //assign game objects from hashMap to GameStack
        for(int i = 0; i < entryNumber1; i++) {
            Game game = map.get(Integer.valueOf(entry1[i]));
            tree.insert(game.getName());
        }
        
        //treat insertion and removal conditions
        for(int i = 0; i < sz; i++) {
        	if(entry2[i].startsWith("I")) {
        		String[] spl = entry2[i].split(" ");
        		int value = Integer.valueOf(spl[1]);
                Game game = map.get(value);
        		tree.insert(game.getName());
        	}
        	if(entry2[i].startsWith("R")) {
                String[] spl = entry2[i].split(" ",2);
        		tree.remove(spl[1]);
        	}
        }   

        tree.walkPre();

        // //fill third entry
        // do{
        //     searchEntry[entryNumber3] = scanner.nextLine();
        // } while(ended(searchEntry[entryNumber3++]) != true);
        // entryNumber3--;

        // //search names
        // for(int i = 0; i < entryNumber3; i++){
        //     System.out.println(searchEntry[i]);
        //     tree.search(searchEntry[i]);
        // }
        
	}
	
	
	//clean information provided
	static void cleanInfo() throws Exception {
		Game[] game = new Game[6000];
		
		//create scanner
		Scanner scanner = new Scanner(new File("games.csv"));
		 scanner.useDelimiter(",");
		 
		 int i = 0;
		 
		 //create while method
		 while(scanner.hasNextLine()) {
			
			 String s = scanner.nextLine();
			 
			//add regex
			 String[] splitted = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			 
			 //we get the id
			 int id  = Integer.valueOf(splitted[0]);
			 
			 //the name
			 String name = splitted[1];
			 
			 //set the date
			 Date data;
			 //create conditions
			 if(splitted[2].contains(",")) {
				 data = toDate(splitted[2].replace("\"", ""),1);
			 }else {
				 data = toDate(splitted[2].replace("\"", ""),0);
			 }
			 
			 //owners
			 String owners = splitted[3];
			 
			 //age
			 int age = Integer.valueOf(splitted[4]);
			 
			 //price value
			 float price;
			 //create conditions
			 if(Float.valueOf(splitted[5]) != 0) {
				 price = Float.valueOf(splitted[5]);
			 }else {
				 price = Float.valueOf("0.00");
			 }
			 
			 //dlcs
			 int dlcs = Integer.valueOf(splitted[6]);
			 
			 //create languages list!!!
			 List<String> lan = new ArrayList<>();
			 String language = splitted[7].replace("\"", "").replace("'", "").replace("[", "").replace("]", "".replace("\r\n", ""));
			 
			 for(int j = 0; j < language.split(",").length;j++) {
				 //add string in its current position
				 lan.add(language.split(",")[j]);
			 }
			 //add arraylist to array of strings
			 String[] languages = lan.toArray(new String[0]);
			 
			 //website
			 String website;
			 //create conditions
			 if(splitted[8] != "") {
				 website = splitted[8];
			 }else {
				 website = null;
			 }
			 
			 //windows, mac & linux
			 boolean windows = Boolean.valueOf(splitted[9]);
			 boolean mac = Boolean.valueOf(splitted[10]);
			 boolean linux = Boolean.valueOf(splitted[11]);
			 
			 //upvotes - for that, we need first and second values
			 float upvotes;
			 float first = Integer.valueOf(splitted[12]);
			 float second = Integer.valueOf(splitted[13]);
			 
			 //create conditions for upvotes
			 if(first != 0) {
				 upvotes = first/(first+second);
				 upvotes *= 100;
				 upvotes = Math.round(upvotes);
			 }else {
				 upvotes = 0;
			 }
			 
			 //average playtime
			 int avg_pt;
			 //create conditions
			 if(splitted[14] != "") {
				 avg_pt = Integer.valueOf(splitted[14]);
			 }else {
				 avg_pt = Integer.valueOf(null);
			 }
			 
			 //devs
			 String developers = splitted[15].replace("\"", "");
			 
			 //genres
			 //first off, we create a list
			 List<String> gen = new ArrayList<>();
			 if(splitted.length == 17) {
				 String genre = splitted[16].replace("\"", "");
				 for(int j = 0; j < genre.split(",").length; j++) {
					 gen.add(genre.split(",")[j]);
				 }
			 }else {
				 gen.add(null);
			 }
			 String genres[] = gen.toArray(new String[0]);
			 
			 //create game objects
			 game[i] = new Game(id, age, dlcs, avg_pt, name, owners, website, developers, price, upvotes, languages, genres, windows, mac, linux, data);
			 map.put(id,game[i]);
			 i++;
		 }
		 scanner.close();
	}

	private static Date toDate(String data, int type) throws Exception {
		Date date;
        if (type == 0) {
            date = new SimpleDateFormat("MM yyyy", Locale.ENGLISH).parse(data.replace("Jan", "01").replace("Feb", "02").replace("Mar", "03")
            .replace("Apr", "04").replace("May", "05").replace("Jun", "06")
            .replace("Jul", "07").replace("Aug", "08").replace("Sep", "09")
            .replace("Oct", "10").replace("Nov", "11").replace("Dec", "12"));
        } else {
            date = new SimpleDateFormat("MM dd, yyyy", Locale.ENGLISH).parse(data.replace("Jan", "01").replace("Feb", "02").replace("Mar", "03")
            .replace("Apr", "04").replace("May", "05").replace("Jun", "06")
            .replace("Jul", "07").replace("Aug", "08").replace("Sep", "09")
            .replace("Oct", "10").replace("Nov", "11").replace("Dec", "12"));
        }
        return date;
		
	}
	
	static String toString(Date date) throws Exception {
		String s = new SimpleDateFormat("MMM/yyyy").format(date);
		return s.replace("abr.", "Apr").replace("mai.", "May").replace("jun.", "Jun")
        .replace("jul.", "Jul").replace("ago.", "Aug").replace("set.", "Sep")
        .replace("out.", "Oct").replace("nov.", "Nov").replace("dez.", "Dec");
	}
	
	static String timeConvert(float time) {
		if(time == 0) {
			return null;
		}
		int hours, minutes;
		
		hours  = (int) time/60;
		minutes = (int)time%60;
		
		if(hours > 0 && minutes > 0) {
			return hours + "h" + " " + minutes + "m";
		}else if(hours > 0 && minutes == 0) {
			return hours + "h";
		}else if(hours == 0 && minutes > 0) {
			return minutes + "m";
		}
		return null;
	}
	
	static String price(float price) {
		int p = (int) price;
		float dif = price - p;
		if(price == 0) {
			return "0.00";
		}else if(dif == 0) {
			return String.valueOf(price) + "0";
		}else {
			return String.valueOf(price);
		}
	}

}

  class Game{
	private int app_id, age, dlcs, avg_pt;
    private String name, owners, website, developers;
    private Date release_date;
    private float price, upvotes;
    private String[] languages, genres;
    private boolean windows, mac, linux;
	
	//constructors
    public Game() throws Exception {
        String[] lan = {"English"};
        String[] gen = {"TBD"};
        String d = "Jan, 01 1";
        setApp_ID(0);
        setAge(0);
        setDlcs(0);
        setAvg_Pt(0);
        setName("Game");
        setOwners("TBA");
        setWebsite("www.game.com");
        setDevelopers("TBA");
        setPrice(0);
        setUpvotes(0);
        setLanguages(lan);
        setGenre(gen);
        setWindows(false);
        setMac(false);
        setLinux(false);
        
    }
    
    public Game(int id, int age, int dlcs, int avg_pt, String name, String owners, String website, String developers, float price, float upvotes, String[] language, String[] genres, boolean windows, boolean mac, boolean linux, Date data) throws Exception {
        setApp_ID(id);
        setAge(age);
        setDlcs(dlcs);
        setAvg_Pt(avg_pt);
        setName(name);
        setOwners(owners);
        setWebsite(website);
        setDevelopers(developers);
        setPrice(price);
        setUpvotes(upvotes);
        setLanguages(language);
        setGenre(genres);
        setWindows(windows);
        setMac(mac);
        setLinux(linux);
        setData(data);
        
    }
    

    public void setApp_ID(int id) {
        if (id >= 0) {
            app_id = id;
        }
    }

    public int getApp_ID() {
        return app_id;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setDlcs(int dlcs) {
        if (dlcs >= 0) {
            this.dlcs = dlcs;
        }
    }

    public int getDlcs() {
        return dlcs;
    }

    public void setAvg_Pt(int avg_pt) {
        if (avg_pt >= 0) {
            this.avg_pt = avg_pt;
        }
    }

    public int getAvg_Pt() {
        return avg_pt;
    }

    public void setName(String name) {
        if (name.length() >= 1) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setOwners(String owners) {
        if (name.length() >= 1) {
            this.owners = owners;
        }
    }

    public String getOwners() {
        return owners;
    }

    public void setWebsite(String website) {
        if (website != null) {
            this.website = website;
        }
    }

    public String getWebsite() {
        if (website != null) {
            return website;
        } else {
            return "null";
        }
    }

    public void setDevelopers(String developers) {
        if (name.length() >= 1) {
            this.developers = developers;
        }
    }

    public String getDevelopers() {
        return developers;
    }

    public void setData(Date data) {
        release_date = data;
    }

    public Date getData() {
        return release_date;
    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setUpvotes(float upvotes) {
        if (upvotes >= 0) {
            this.upvotes = upvotes;
        }
    }

    public float getUpvotes() {
        return upvotes;
    }

    public String getUpVotes() {
        int num = (int)getUpvotes();
        return num+"%";
    }

    public void setLanguages(String[] languages) {
        if (languages.length >= 0) {
            this.languages = languages;
        }
    }

    public String getLanguages() {
        String s = "[";
        String s2 = "";
        for (int i = 0; i < languages.length; i++) {
            s+=languages[i] + ",";
        }
        for (int i = 0; i < s.length() - 1; i++) {
            s2+=s.charAt(i);
        }
        s2+="]";
        return s2;
    }

    public void setGenre(String[] genres) {
        if (genres.length >= 0) {
            this.genres = genres;
        }
    }

    public String getGenre() {
        String s = "[";
        String s2 = "";
        for (int i = 0; i < genres.length; i++) {
            s+=genres[i] + ", ";
        }
        for (int i = 0; i < s.length() - 2; i++) {
            s2+=s.charAt(i);
        }
        s2+="]";
        return s2;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public boolean getWindows() {
        return windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public boolean getMac() {
        return mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public boolean getLinux() {
        return linux;
    }	
}

//create node class\\
class Node{
    String name;
    int level;
    Node left,right;

    //class constructor
    public Node(String s){
        this.name = s;
        level = 0; 
        left = right = null;
    }

    //calculate amount of levels
    public void setLevel() {this.level = 1 + Math.max(getLevel(left), getLevel(right));}

    //get level
    public static int getLevel(Node curr) {return (curr == null) ? 0 : curr.level;}
}

//create class AVL\\
class AVL{
    private Node root;

    //initialize tree
    public AVL(){root = null;}

    //insert element
    public void insert(String s) throws Exception {
        root = insert(s,root);
    }

    //actual insertion
    private Node insert(String s, Node curr) throws Exception {
        if(curr == null){curr = new Node(s);
        }else if(s.compareTo(curr.name) < 0) {curr.left = insert(s,curr.left);
        }else if(s.compareTo(curr.name) > 0) {curr.right = insert(s,curr.right);
        }else {throw new Exception("Insertion error.");}
        //return balanced node
        return balance(curr);
    }


    //balance tree
    private Node balance(Node curr)throws Exception{
        if(curr != null){
            //get height factor
            int factor = Node.getLevel(curr.right) - Node.getLevel(curr.left);
            //if tree is already balanced, nothing will happen, when factor == 0 or 1
            if(Math.abs(factor) <= 1){curr.setLevel();
            }else if(factor == 2){ //if factor is 2, means that our tree is unbalanced to the right, so we gotta rotate left
                int childFactor = Node.getLevel(curr.right.right) - Node.getLevel(curr.right.left);
                //if childFactor = -1, it means that a right-left rotation is needed
                if(childFactor == -1) {curr.right = rotateRight(curr.right);}
                //now do left rotation
                curr = rotateLeft(curr);
            }else if(factor == -2){ //if factor is -2, means that our tree is unbalanced to the left, so we gotta rotate right
                int childFactor = Node.getLevel(curr.left.right) - Node.getLevel(curr.left.left);
                //if childFactor = 1, it means that a left-right rotation is needed
                if(childFactor == 1) {curr.left = rotateLeft(curr.left);}
                //now do right rotation
                curr = rotateRight(curr);
            } else {
				throw new Exception("Erro no No(" + curr.name + ") com fator de balanceamento (" + factor + ") invalido!");
			}
        }
        return curr;
    }

    private Node rotateRight(Node node){
        Node leftNode = node.left;
        Node rightLeftNode = leftNode.right;

        leftNode.right = node;
        node.left = rightLeftNode;

        node.setLevel();
        leftNode.setLevel();

        return leftNode;
    }


    private Node rotateLeft(Node node){
       Node rightNode = node.right;
       Node leftRightNode = rightNode.left;

       rightNode.left = node;
       node.right = leftRightNode;

       node.setLevel(); 
       rightNode.setLevel();

       return rightNode;
    }


    //remove element
    public void remove(String s)throws Exception{
        root = remove(s,root);       
    }
    //actual removal
    private Node remove(String s, Node curr) throws Exception {
        if(curr == null){ throw new Exception("Removal error.");
        }else if(s.compareTo(curr.name) < 0) {curr.left = remove(s,curr.left);
        }else if(s.compareTo(curr.name) > 0) {curr.right = remove(s,curr.right);
        }else if(curr.right == null) {curr = curr.left;
        }else if(curr.left == null) {curr = curr.right;
        }else {curr.left = getHighestLeft(curr,curr.left);}

        return balance(curr);
    }



    //get largest element from root's left child
    private Node getHighestLeft(Node i, Node j){
        if(j.right == null){
            i.name = j.name;
            j = j.left;
        }else {j.right = getHighestLeft(i,j.right);}
        return j;
    }


    public void search(String s){
        System.out.print("raiz ");
        boolean ans = search(root,s);
        if(ans){System.out.print("SIM");
        }else {System.out.print("NAO");}
        System.out.println();
    }

    private boolean search(Node curr, String s){
        boolean ans = false;
        if(curr == null) {ans = false;
        }else if(s.compareTo(curr.name) < 0) {
            System.out.print("esq" + " ");
            ans = search(curr.left, s);
        }else if(s.compareTo(curr.name) > 0) {
            System.out.print("dir" + " ");
            ans = search(curr.right, s);
        }else if(s.equals(curr.name)){ans = true;}
        
        return ans;
    }

    public void walkPre(){
        walkPre(root);
    }

    public int ct = 0;

    private void walkPre(Node curr){
        if(curr != null){
            System.out.println(curr.name);
            walkPre(curr.left);
            walkPre(curr.right);
        }
    }


}