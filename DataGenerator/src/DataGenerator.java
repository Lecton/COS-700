
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
    
    public static void main(String[] args) {
        best();
        average();
        worst();
        System.out.println("Done");
    }
    
    public static void best(){
        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE ; i++){
            list.add(new Element((i+1), (-1)));
        }
        
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }            
        write("best.txt");
    }
    
    public static void average(){

        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE ; i++){
            for(int j = 0; j < SIZE ; j++){
                list.add(new Element((i+1), (j+1)));
            }
        }
        
        System.out.println("Size: " + list.size());
        
        
        Element e;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).start == list.get(i).end){
                list.remove(i);
            }
        } 
        
        System.out.println("Size: " + list.size());
        
        for(int i = 0; i < list.size(); i++){
            e = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if((e.start == list.get(j).end) && (e.end == list.get(j).start)){
                    list.remove(j);
                }
            }
        }        
        
        System.out.println("Size: " + list.size());
        
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        
        System.out.println("------------------------------");
        for(int i = 0; i < list.size(); i++){
            if(i%2 == 0){
                list.remove(i);
            }
        }
        
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }        
        write("average.txt");
    }
    
    public static void worst(){
        list = new ArrayList<>();
        
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                list.add(new Element((i+1), (j+1)));
            }
        }
        
        System.out.println("Size: " + list.size());
        
        System.out.println("Size: " + list.size());
        
        Element e;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).start == list.get(i).end){
                list.remove(i);
            }
        } 
        
        System.out.println("Size: " + list.size());
        
        for(int i = 0; i < list.size(); i++){
            e = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if((e.start == list.get(j).end) && (e.end == list.get(j).start)){
                    list.remove(j);
                }
            }
        }        
        
        System.out.println("Size: " + list.size()); 
        write("worst.txt");
    }
    
    public static void write(String fname){        
        try {


                File file = new File("../VFLibGraph/vflibtest/cases/" + fname);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                if(fname.equalsIgnoreCase("best.txt")){
                    for(int i = 0; i < list.size(); i++){
                        bw.write(list.get(i).start + "\n");
    //                    System.out.println(list.get(i).start + " " + list.get(i).end);
                    } 
                }else{
                    
                    for(int i = 0; i < list.size(); i++){
                        bw.write(list.get(i).start + " " + list.get(i).end + "\n");
    //                    System.out.println(list.get(i).start + " " + list.get(i).end);
                    } 
                }
                
                bw.close();


        } catch (IOException e) {
                e.printStackTrace();
        }
    }
 }
