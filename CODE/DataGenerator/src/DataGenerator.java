
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lecton
 */
public class DataGenerator {

    /**
     * @param args the command line arguments
     */
    public static List<Element> list;
    public static int SIZE = 1000;
    
    public static void main(String[] args){
        best();
        average();
        worst();
        System.out.println("Done");
    }
    
    public static void best(){
        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                list.add(new Element((i+1), (j+1)));
            }
        }        
        
        Element e;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).start == list.get(i).end){
                list.remove(i);
            }
        } 
                
        for(int i = 0; i < list.size(); i++){
            e = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if((e.start == list.get(j).end) && (e.end == list.get(j).start)){
                    list.remove(j);
                }
            }
        }        
               
        write("best.txt");
        System.out.println("Best is Done");
    }
    
    public static void average(){
        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE ; i++){
            for(int j = 0; j < SIZE ; j++){
                list.add(new Element((i+1), (j+1)));
            }
        }
        
        Element e;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).start == list.get(i).end){
                list.remove(i);
            }
        } 
        
        for(int i = 0; i < list.size(); i++){
            e = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if((e.start == list.get(j).end) && (e.end == list.get(j).start)){
                    list.remove(j);
                }
            }
        }        
                
        for(int i = 0; i < list.size(); i++){
            if(i%2 == 0){
                list.remove(i);
            }
        }            
        write("average.txt");
        System.out.println("Average is Done");
    }
    
    public static void worst(){
        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE ; i++){
            list.add(new Element((i+1), (-1)));
        }
        write("worst.txt");
        System.out.println("Worst is Done");
    }
    
    public static void write(String fname){
        try {
            File file = new File("../VFLibGraph/vflibtest/cases/" + fname);

            if (!file.exists()) {
                    file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            if(fname.equalsIgnoreCase("worst.txt")){
                for(int i = 0; i < list.size(); i++){
                   bw.write(list.get(i).start + "\n");
                } 
            }else{

                for(int i = 0; i < list.size(); i++){
                    bw.write(list.get(i).start + " " + list.get(i).end + "\n");
                } 
            }
            bw.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
 }
