
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lecton
 */
public class SpellChecker {

    /**
     * @param args the command line arguments
     */
//    static File dir = new File("../Research Assignment/Draft/TEX/");
    static List<String> words;
    public static void main(String[] args) throws IOException {
        words = new ArrayList<>();
        File currentDir = new File("../Research Assignment/Draft/TEX/"); // current directory
        displayDirectoryContents(currentDir);
        
        // add elements to al, including duplicates
        Set<String> hs = new HashSet<>();
        hs.addAll(words);
        words.clear();
        words.addAll(hs);
        for(String w: words){
            System.out.println(w);
        }
    }
    

    public static void fileProcess(String dir){
        BufferedReader br = null;
        try {
            String line;

            br = new BufferedReader(new FileReader(dir));
            String [] array;
            while ((line = br.readLine()) != null) {
                    line = line.replaceAll("[\\.{},\"^]", "");
                    array = line.split(" ");
                    
                    for(int i = 0; i < array.length;i++){
                        array[i] = array[i].trim();
                        
                        if(!array[i].contains("\\")&&
                           !array[i].contains("(") &&
                           !array[i].contains(")") &&
                           !array[i].contains("[") &&
                           !array[i].contains("]") &&
                           !array[i].contains("$") &&
                           !array[i].contains("'")&&
                           !array[i].contains("=")&&
                           !array[i].contains(":")&&
                           !array[i].contains("<")&&
                           !array[i].equals("")&&
                           !array[i].equals("n")&&
                           !array[i].equals("m")&&
                           !array[i].equals("Rpred")&&
                           !array[i].equals("Rnew")&&
                           !array[i].equals("Rsucc")&&
                           !array[i].equals("Rin")&&
                           !array[i].equals("Rout")){
                            
                            words.add(array[i].toLowerCase());
                        }
                    }
//                    System.out.println(line);
            }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        } 
    }
            
    public static void displayDirectoryContents(File dir) {
        try{
            File[] files = dir.listFiles();
            for (File file : files) {
                    if (file.isDirectory()) {
                        if(!file.getCanonicalPath().contains("latex")){
                            displayDirectoryContents(file);
                        }
                    } else {
                        if(file.getCanonicalPath().endsWith(".tex")){
//                            System.out.println("     file:" + file.getCanonicalPath());
                            fileProcess(file.getCanonicalPath());
                        }
                    }
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }    
}
