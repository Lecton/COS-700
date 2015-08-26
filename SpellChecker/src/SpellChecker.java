
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
    static List<String> words;
    public static void main(String[] args) throws IOException {
        
       BufferedReader br = null;
        try {
            String file = "../VFLibGraph/vflibtest/data/10.txt";
            String line;

            br = new BufferedReader(new FileReader(file));
            String [] array;
            while ((line = br.readLine()) != null) {
                    line = line.trim();
                    array = line.split(" ");
//                    if(array[0].equals("1") || array[1].equals("1") || 
//                       array[0].equals("2") || array[1].equals("2") || 
//                       array[0].equals("3") || array[1].equals("3") || 
//                       array[0].equals("4") || array[1].equals("4") || 
//                       array[0].equals("5") || array[1].equals("5") || 
//                       array[0].equals("6") || array[1].equals("6") || 
//                       array[0].equals("7") || array[1].equals("7") || 
//                       array[0].equals("8") || array[1].equals("8") || 
//                       array[0].equals("9") || array[1].equals("9") || 
//                       array[0].equals("10") || array[1].equals("10") ){
//                       System.out.println(array[0]+" "+array[1]);
//                    }

                    if(((0 < Integer.parseInt(array[0])) && (Integer.parseInt(array[0]) < 10)) && 
                            (((0 < Integer.parseInt(array[1])) && (Integer.parseInt(array[1]) < 10)))){
                               System.out.println(""+array[0]+" "+array[1]+"");
//                               System.out.println("("+array[0]+","+array[1]+"),");
                    }                    
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
//        words = new ArrayList<>();
//        File currentDir = new File("../Research Assignment/Draft/TEX/"); // current directory
//        displayDirectoryContents(currentDir);
//        
//        // add elements to al, including duplicates
//        Set<String> hs = new HashSet<>();
//        hs.addAll(words);
//        words.clear();
//        words.addAll(hs);
//        for(String w: words){
//            System.out.println(w);
//        }
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
