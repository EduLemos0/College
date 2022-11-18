
/*
 * @file TP03Q01
 * @author Eduardo Lemos
 * @date 2022-10-13
 */
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
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.io.FileWriter;

public class TP03Q03 {
	
	public static HashMap<Integer, Game> map = new HashMap<>();
	
	
	static boolean ended(String s) {
		return (s.equals("FIM"));
	}
	
	public static void main(String[] args) throws Exception {
		cleanInfo();
		
        //create entry1 and entry2 to storage the given data
		String[] entry = new String[1000];
		Scanner scanner = new Scanner(System.in);
        int sz;
        int entryNum = 0;
        GameList list = new GameList(1000);

		//read default entry
        do {
        	entry[entryNum] = scanner.nextLine();
        }while(ended(entry[entryNum++]) == false);
        entryNum--; //deconsiderate main "FIM" line
        
        for(int i = 0; i < entryNum; i++) {
            Game game = map.get(Integer.valueOf(entry[i]));
            list.insertEnd(game);
        }
        
        //get start time
        long start = (new Date()).getTime(),time;
        list.insertionSort();
        time = (new Date()).getTime() - start; // get elapsed time of method
        
        //write information in file
        writeInFile(time,list.comparisons(),list.movements());
        
        
        //print sorted game list
        for(int i = 0; i < list.getCR(); i++) {
        	Game game = list.getGame(i);
        	System.out.println(game.getApp_ID() + " " + game.getName() + " " + toString(game.getData()) + " " + game.getOwners() + " " + 
            game.getAge() + " " + price(game.getPrice()) + " " + game.getDlcs() + " " + game.getLanguages() +  " " + game.getWebsite() + " " +
            game.getWindows() + " " + game.getMac() + " " + game.getLinux() + " " + game.getUpVotes() + " " + timeConvert(game.getAvg_Pt()) +
            " " + game.getDevelopers() + " " + game.getGenre());
        }
        
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

	
	static void writeInFile(long time, int comparisons, int movements) {
		//create fileWriter block
  		try {
  			FileWriter writer = new FileWriter("matricula_insercao.txt");
  			writer.write("761632\t" + time + "\t" + comparisons + "\t" + movements);
  			writer.close();
  		}catch (IOException e) {
  			e.printStackTrace();
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
  
//create class list
class GameList {
    private Game[] arr;
    private int currentSize,moves,compares;

    //create constructor
    GameList() { this(6);}
    GameList(int size) {
        arr = new Game[size];
        currentSize = moves = compares = 0;
    }

    
    //insert object in the tail of the stack
    void insertEnd (Game x) throws Exception {

        //array cannot be full
        if(currentSize >= arr.length) {
            throw new Exception("Error: array is full");
        }

        arr[currentSize] = x;
        currentSize++;
    }


    //remove bottom element
    Game removeTail() throws Exception {
        if(currentSize == 0) {
            throw new Exception("Error: array is empty");
        }

        return arr[--currentSize];
    }


    //print elements
    void print() {
        System.out.println("[");
        for(int i = 0; i < currentSize; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("]");
    }

    //get game in specified position
    Game getGame(int pos) {
        return arr[pos];
    }

    //get current size
    int getCR() {
        return currentSize;
    }
    
    
    void printFirstPosition() {
    	System.out.println(arr[0].getApp_ID());
    }
    
    
    void insertionSort() {
    	
    	for(int i = 1; i < currentSize; i++) {
			 Game temp = arr[i];
			 moves++;
			 //create j variable to compare wit i variable
			 int j = i - 1;
			 //create while structure | if it's more or equal to zero AND arr[j] > temp variable
			 while((j >= 0) && (arr[j].getApp_ID() > temp.getApp_ID())) {
				 compares++;
				 //set arr[j+1] to arr[j], he do be shifting doe
				 arr[j + 1] = arr[j];
				 moves++;
				 //decrement the j
				 j--;	
			 }compares++;
			 
			 //after the while loop, we swap the lower value to its place
			 arr[j+1] = temp;
			 moves++;
		 }
    }
    
    //get amount of movements
    int movements() {
    	return moves;
    }
    
    //get amount of comparisons
    int comparisons() {
    	return compares++;
    }
    

}
