import java.io.*;
import java.util.*;

public class TuningTrouble
{
  //static String filename = "input-sample.txt"; //for testing purposes 
  static String filename = "input.txt"; //the original input  
  static String []input;
  static HashSet<Character> windowChars = new HashSet<Character>(); 
 
    
   public static void solvePuzzle1() throws IOException
   {
     int windowsize = 14; 
     readInputIntoArray(); 
     for(int i=0; i<input[0].length()-windowsize;i++)
     {
         hasMakerInWindow(i,windowsize); 
     }
     
   }
  
   public static boolean hasMakerInWindow(int start, int windowSize)
   {
       windowChars.clear(); //clear hashset of chars
       String window = input[0].substring(start,start+windowSize); //get window 
       
       for(int i=0; i<window.length();i++)
       {
          if(windowChars.contains(window.charAt(i))) //if char is already found
          {
            return false; 
            }
          else windowChars.add(window.charAt(i));
       }
       System.out.println("packet found: "+window+" at marker "+(start+windowSize)); 
       
       return true; 
    }
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new String[arraySize]; //Erstelle leeres Array mit der Anzahl 
    
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
         input[i] = br.readLine();
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
