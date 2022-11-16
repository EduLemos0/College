package TP4;

/*
 *@author Eduardo Lemos
 *02/11/2022
 *who comes up with these exercises??? 
*/

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class TP04Q01 {

    public static HashMap<Integer, Game> map = new HashMap<>();

    public static boolean ended(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        
    	Scanner scanner = new Scanner(System.in);
        lerArquivoCsv();
        String[] entry = new String[1000];
        int sz;
        int entryNum = 0;
        Doubly list = new Doubly();

		//read default entry
        do {
        	entry[entryNum] = scanner.nextLine();
        }while(ended(entry[entryNum++]) == false);
        entryNum--; //deconsiderate main "FIM" line
        
        for(int i = 0; i < entryNum; i++) {
            Game game = map.get(Integer.valueOf(entry[i]));
            list.insertEnd(game);
        }

    }

    public static void lerArquivoCsv() throws Exception {
    	//HOW THE FUCK DO I CHANGE THE CHARSET??
    	
    	Game[] game = new Game[6000];
        Scanner sc = new Scanner(new File("/tmp/games.csv"));
        sc.useDelimiter(",");
        int i = 0;
        while (sc.hasNextLine()) {
          String s = sc.nextLine();

          //Separa as linhas pelas , fora do ""
          String[] separado = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

          int id = Integer.valueOf(separado[0]);
          String name = separado[1];
          Date data;
          if (separado[2].contains(",")) {
            data = toDate(separado[2].replace("\"", ""), 1);
          } else {
            data = toDate(separado[2].replace("\"", ""), 0);
          }
          String owners = separado[3];
          int age = Integer.valueOf(separado[4]);
          float price;
          if (Float.valueOf(separado[5]) != 0) {
            price = Float.valueOf(separado[5]);
          } else {
            price = Float.valueOf("0.00");
          }
          int dlcs = Integer.valueOf(separado[6]);
          List<String> lan = new ArrayList<>();
          String language = separado[7].replace("\"", "").replace("'", "").replace("[", "").replace("]", "".replace("\r\n", ""));
          for (int j = 0; j < language.split(",").length; j++) {
            lan.add(language.split(",")[j]);
          }
          String[] languages = lan.toArray(new String[0]);
          String website;
          if (separado[8] != "") {
            website = separado[8];
          } else {
            website =null;
          }
          boolean windows = Boolean.valueOf(separado[9]);
          boolean mac = Boolean.valueOf(separado[10]);
          boolean linux = Boolean.valueOf(separado[11]);
          float primeiro = Integer.valueOf(separado[12]);
          float segundo = Integer.valueOf(separado[13]);
          float upvotes;
          if (primeiro != 0) {
            upvotes = primeiro/(primeiro + segundo);
            upvotes*=100;
            upvotes = Math.round(upvotes);
          } else {
            upvotes = 0;
          }
          int avg_pt;
          if (separado[14] != "") {
            avg_pt = Integer.valueOf(separado[14]);
          } else {
            avg_pt = Integer.valueOf(null);
          }
          String developers = separado[15].replace("\"", "");
          List<String> gen = new ArrayList<>();
           if (separado.length == 17) {
            String genre = separado[16].replace("\"", "");
            for (int j = 0; j < genre.split(",").length; j++) {
                gen.add(genre.split(",")[j]);
              }
          } else {
            gen.add(null);
          }
          String genres[] = gen.toArray(new String[0]);
          game[i] = new Game(id, age, dlcs, avg_pt, name, owners, website, developers, price, upvotes, languages, genres, windows, mac, linux, data);
          map.put(id, game[i]);
          i++;
        }
        sc.close(); 
    }


    public static Date toDate(String data, int type) throws Exception{
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

    public static String toString(Date date) throws Exception{
        String s = new SimpleDateFormat("MMM/yyyy").format(date);
        return s.replace("jan", "Jan").replace("fev", "Feb").replace("mar", "Mar")
        .replace("abr", "Apr").replace("mai", "May").replace("jun", "Jun")
        .replace("jul", "Jul").replace("ago", "Aug").replace("set", "Sep")
        .replace("out", "Oct").replace("nov", "Nov").replace("dez", "Dec");
    }

    public static String converterHora(float time) {
        if (time == 0) {
            return null;
        }
        int hora, minutos;
        hora = (int)time/60;
        minutos = (int)time%60;
        if (hora > 0 && minutos > 0) {
            return hora + "h" + " " + minutos + "m";
        } else if (hora > 0 && minutos == 0) {
            return hora + "h";
        } else if (hora == 0 && minutos > 0) {
            return minutos + "m";
        }
        return null;
    }

    public static String price(float price) {
        int p = (int)price;
        float dif = price - p;
        if (price == 0) {
            return "0.00";
        } else if (dif == 0) {
            return String.valueOf(price) + "0";
        } else {
            return String.valueOf(price);
        }
    }
}

class Game {

    private int app_id, age, dlcs, avg_pt;
    private String name, owners, website, developers;
    private Date release_date;
    private float price, upvotes;
    private String[] languages, genres;
    private boolean windows, mac, linux;

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
        setData(TP04Q01.toDate(d, 0));
        
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

//-------- create class Cell --------\\
class Cell {
	public Game game;
	public Cell next,prev;
	
	//constructors
	public Cell() {
		game = null;
		next = prev = null;
	}
	
	public Cell(Game x) {
		game = x;
		next =  prev = null;
	}
}

//-------- create class Doubly --------\\
 class Doubly{
    Cell first,last;

    //insert in end
    public void insertEnd(Game x){
        last.next = new Cell(x);
        last.next.prev = last;
        last = last.next;
    }


    //start quicksort
    public void quicksort()throws Exception{
        sort(0,size()); //we pass 0 and size of list
    }

    private void sort(int left, int right)throws Exception{
        int i = left, j = right;

        Date pivot = at((left + right)/2).game.getData();
        Cell leftCell = at(i);
        Cell rightCell = at(j);


        while(i <= j){

            while(leftCell.game.getData().before(pivot)){
                i++;
                leftCell = leftCell.next;
            }

            while(rightCell.game.getData().after(pivot)){
                j--;
                rightCell = rightCell.prev;
            }

            //swap
            if(i <= j){
                Game tmp = leftCell.game;
                leftCell.game = rightCell.game;
                rightCell.game= tmp;
                i++;
                j--;   
            }

            if(left < j){sort(left, j);}
            if(i < right){sort(i, right);}
        }
    }
    



    //get cell at wished position
    public Cell at(int pos) throws Exception {
        if(pos < 0 || pos > size()){throw new Exception("Error. Position is invalid.");
        }else if(pos == 0){return first.next;
        }else if(pos == size()){return last;
        }else{
            Cell tmp = first.next;
            for(int i = 0; i < pos; i++){tmp = tmp.next;}
            return tmp;
        }
    }


    //get size of array
    public int size(){
        Cell tmp = first.next;
        int i;
        for(i = 0; tmp != null; i++, tmp = tmp.next);
        return i;
    }

 }
