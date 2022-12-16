// @author Eduardo Lemos

import java.util.Scanner;
import java.io.*;
import java.net.*;

class TP01Q08 {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
      String endereco, html;
      String nome = "";
      do {
      nome = scanner.nextLine();
      if(!nome.equals("FIM")) {
    	  endereco = scanner.nextLine();
          html = getHtml(endereco);
          String[] tags = {"<br>","<table>"}; 
          
          quantA(html);
          tags(html,tags);
          
          System.out.println(nome);  
      }
      
      }while(!nome.equals("FIM"));
   }
   
   static void quantA(String s) {
	   
	   //criaremos um array contendo vogais (acentuadas ou não)
	   int vogais[] = {97,101,105,111,117,225,233,237,243,250,224,232,236,242,249,227,245,226,234,238,244,251};

	   
	   //criar array com o respectivo numero de caracteres vogais possíveis, porém com o valor int para representar a quantidade
	   int[] qtdVogais = new int[vogais.length];
	   
	   int consoante=0;
	   
	   boolean vogal;
	   
	   for(int i = 0; i < s.length();i++) {
		   
		   vogal = false;
		   
		   for(int j=0; j <vogais.length;j++) {
			   if(s.charAt(i) == (char)vogais[j]) {
				   //por ex. caso o caractere em questão seja a, adicionará 1 unidade á primeira posição do array qtdVogais[]
				   qtdVogais[j]++;
				   vogal = true;
				   break;
			   }
		   }
		   
		   if(s.charAt(i) != ' ') {
			   consoante++;
		   }
		   
	   }
	   
	   //imprimir numero de vogais
	   for(int i = 0;i<vogais.length;i++) {
		   System.out.print((char)vogais[i] + "(" + qtdVogais[i] + ") ");
	   }
	   
	   System.out.print("consoante(" + consoante + ") ");
   }
   
   static void tags(String s, String[] tags) {
	   
	   int[] qntTags= new int[tags.length];
	   
	   //percorrer a string
	   for(int i = 0; i<s.length();i++) {
		   //percorrer array de tags
		   for(int j=0;j<tags.length;j++) {
			   if(s.charAt(i) == tags[j].charAt(0)) {
				   
				   boolean verificar=true;
				   
				   for(int k=0;k<tags[j].length();k++) {
					   if(s.charAt(i+k) != tags[j].charAt(k)) {
						   verificar = false;
						   break;
					   }
				   }
				   if(verificar == true) {
					   qntTags[j]++;
				   }
			   }
		   }
	   }
	   for(int i =0; i < tags.length; i++) {
		   System.out.print(tags[i] + "(" + qntTags[i] + ") ");
	   }
	   
	   
	   
   }
   
}