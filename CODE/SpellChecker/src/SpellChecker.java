
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        
//        forPython();
//        forC();
        forTheLolz();
        List<Integer> list = new ArrayList<>();
       BufferedReader br = null;
        try {
            String file = "../VFLibGraph/vflibtest/data/250.txt";
            String line;

            br = new BufferedReader(new FileReader(file));
            String [] array;
            int count = 0;
            while ((line = br.readLine()) != null) {
                    ++count;
                    line = line.trim();
                    array = line.split(" ");
                    
                    array[0] = array[0].trim();                    
                    array[1] = array[1].trim();
                    
                    if(!list.contains(Integer.parseInt(array[0]))){
                        list.add(Integer.parseInt(array[0]));
                    }
                    if(!list.contains(Integer.parseInt(array[1]))){
                        list.add(Integer.parseInt(array[1]));
                    }
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

//                    if((Integer.parseInt(array[0]) <= 10) && (Integer.parseInt(array[1]) <= 10)){
//                               System.out.println(""+array[0]+" "+array[1]+"");
////                               System.out.println("("+array[0]+","+array[1]+"),");
//                    }  
                    
//                               System.out.println("("+array[0]+","+array[1]+"),");
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
    
    
    public static void forC(){
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        List<Integer> vertices = new ArrayList<>();
        List<edge> edges = new ArrayList<>();
        try {
            String file = "../VFLibGraph/vflibtest/data/250.txt";
            String line;
            //3O.txt
//            String in = "5, 2, 1, 123, 117, 112, 110, 103, 98, 97, 93, 90, 88, 87, 85, 81, 79, 78, 74, 70, 65, 61, 51, 48, 45, 44, 41, 34, 21, 17";
            //56.txt
//            String in = "6, 3, 7, 13, 14, 20, 21, 1, 34, 45, 48, 52, 59, 65, 66, 69, 70, 74, 79, 80, 85, 88, 90, 93, 94, 97, 103, 110, 112, 117, 118, 123, 128, 131, 132, 133, 134, 153, 158, 167, 168, 174, 177, 184, 189, 192, 195, 196, 198, 203, 221, 222, 231, 241, 242, 245";
            //75.txt
//            String in = "5, 2, 6, 3, 7, 13, 14, 17, 20, 21, 1, 34, 41, 44, 45, 48, 51, 52, 59, 61, 65, 66, 69, 70, 74, 78, 79, 80, 81, 85, 87, 88, 90, 93, 94, 97, 98, 103, 110, 112, 117, 118, 123, 128, 131, 132, 133, 134, 153, 158, 164, 167, 168, 174, 177, 184, 187, 189, 192, 195, 196, 197, 198, 200, 203, 206, 211, 218, 221, 222, 231, 241, 242, 245, 249";
            //92.txt
//            String in = "5, 2, 6, 3, 4, 7, 13, 14, 17, 19, 20, 21, 1, 34, 40, 41, 44, 45, 48, 51, 52, 57, 59, 61, 65, 66, 69, 70, 71, 74, 78, 79, 80, 81, 85, 87, 88, 90, 93, 94, 97, 98, 103, 109, 110, 112, 117, 118, 123, 128, 130, 131, 132, 133, 134, 141, 145, 153, 158, 164, 167, 168, 174, 177, 184, 186, 187, 189, 190, 191, 192, 195, 196, 197, 198, 200, 203, 206, 210, 211, 218, 220, 221, 222, 224, 231, 238, 241, 242, 243, 245, 249";
            //109.txt
//            String in = "5, 2, 6, 3, 4, 7, 13, 14, 17, 19, 20, 21, 1, 24, 34, 35, 38, 40, 41, 44, 45, 48, 50, 51, 52, 57, 58, 59, 61, 65, 66, 69, 70, 71, 74, 78, 79, 80, 81, 85, 87, 88, 90, 93, 94, 95, 97, 98, 103, 109, 110, 112, 113, 116, 117, 118, 123, 128, 130, 131, 132, 133, 134, 135, 138, 140, 141, 145, 147, 153, 158, 164, 167, 168, 169, 174, 177, 184, 186, 187, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 203, 206, 209, 210, 211, 218, 220, 221, 222, 224, 231, 238, 241, 242, 243, 245, 248, 249";
            //121.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 13, 14, 16, 17, 19, 20, 21, 1, 24, 28, 34, 35, 38, 39, 40, 41, 44, 45, 48, 49, 50, 51, 52, 53, 57, 58, 59, 61, 62, 63, 65, 66, 67, 69, 70, 71, 74, 78, 79, 80, 81, 84, 85, 87, 88, 90, 93, 94, 95, 97, 98, 99, 100, 103, 106, 107, 109, 110, 111, 112, 113, 116, 117, 118, 119, 123, 128, 130, 131, 132, 133, 134, 135, 138, 140, 141, 145, 147, 153, 154, 158, 160, 164, 165, 166, 167, 168, 169, 174, 177, 178, 184, 186, 187, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 203, 206, 209, 210, 211, 214, 218, 220, 221, 222, 224, 226, 229, 230, 231, 234, 238, 241, 242, 243, 244, 245, 246, 248, 249";
            //148.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 19, 20, 21, 1, 24, 28, 34, 35, 38, 39, 40, 41, 44, 45, 48, 49, 50, 51, 52, 53, 57, 58, 59, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 74, 78, 79, 80, 81, 84, 85, 87, 88, 90, 93, 94, 95, 97, 98, 99, 100, 101, 103, 106, 107, 109, 110, 111, 112, 113, 116, 117, 118, 119, 121, 123, 128, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 145, 147, 148, 150, 153, 154, 158, 160, 164, 165, 166, 167, 168, 169, 174, 175, 177, 178, 184, 186, 187, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 203, 206, 208, 209, 210, 211, 214, 218, 220, 221, 222, 224, 226, 229, 230, 231, 232, 234, 238, 241, 242, 243, 244, 245, 246, 248, 249";
            //166.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 24, 28, 33, 34, 35, 38, 39, 40, 41, 44, 45, 48, 49, 50, 51, 52, 53, 55, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 74, 76, 78, 79, 80, 81, 84, 85, 87, 88, 90, 91, 93, 94, 95, 97, 98, 99, 100, 101, 103, 106, 107, 108, 109, 110, 111, 112, 113, 116, 117, 118, 119, 121, 123, 124, 128, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 143, 145, 146, 147, 148, 150, 153, 154, 156, 158, 159, 160, 164, 165, 166, 167, 168, 169, 172, 174, 175, 177, 178, 184, 186, 187, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 201, 203, 205, 206, 208, 209, 210, 211, 214, 218, 219, 220, 221, 222, 223, 224, 226, 229, 230, 231, 232, 234, 238, 241, 242, 243, 244, 245, 246, 248, 249";
            //181.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 24, 12, 27, 28, 11, 29, 33, 34, 35, 38, 39, 40, 41, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72, 74, 76, 78, 79, 80, 81, 84, 85, 87, 88, 89, 90, 91, 93, 94, 95, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 121, 123, 124, 128, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 143, 144, 145, 146, 147, 148, 150, 153, 154, 156, 158, 159, 160, 164, 165, 166, 167, 168, 169, 172, 174, 175, 177, 178, 183, 184, 186, 187, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 201, 203, 204, 205, 206, 208, 209, 210, 211, 214, 218, 219, 220, 221, 222, 223, 224, 226, 229, 230, 231, 232, 234, 238, 240, 241, 242, 243, 244, 245, 246, 248, 249";
            //197.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 24, 12, 27, 28, 11, 29, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72, 74, 76, 78, 79, 80, 81, 82, 83, 84, 85, 87, 88, 89, 90, 91, 93, 94, 95, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 123, 124, 128, 129, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 143, 144, 145, 146, 147, 148, 150, 151, 153, 154, 156, 158, 159, 160, 164, 165, 166, 167, 168, 169, 172, 173, 174, 175, 177, 178, 179, 183, 184, 186, 187, 188, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 201, 203, 204, 205, 206, 208, 209, 210, 211, 213, 214, 215, 218, 219, 220, 221, 222, 223, 224, 226, 228, 229, 230, 231, 232, 234, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 248, 249";
            //211.txt
//            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 22, 24, 12, 26, 27, 28, 11, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 56, 57, 58, 59, 60, 61, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 76, 78, 79, 80, 81, 82, 83, 84, 85, 87, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 126, 128, 129, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 143, 144, 145, 146, 147, 148, 149, 150, 151, 153, 154, 156, 157, 158, 159, 160, 161, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 177, 178, 179, 183, 184, 186, 187, 188, 189, 190, 191, 192, 193, 195, 196, 197, 198, 199, 200, 201, 203, 204, 205, 206, 208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221, 222, 223, 224, 226, 228, 229, 230, 231, 232, 234, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 248, 249";
            //222.txt
            String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 22, 24, 12, 26, 27, 28, 11, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 76, 78, 79, 80, 81, 82, 83, 84, 85, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 129, 130, 131, 132, 133, 134, 135, 138, 139, 140, 141, 143, 144, 145, 146, 147, 148, 149, 150, 151, 153, 154, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 177, 178, 179, 182, 183, 184, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 203, 204, 205, 206, 208, 209, 210, 211, 212, 213, 214, 215, 217, 218, 219, 220, 221, 222, 223, 224, 226, 228, 229, 230, 231, 232, 234, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250";
            //250.txt
//              String in = "5, 2, 6, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 9, 22, 24, 12, 23, 26, 27, 28, 11, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 30, 41, 25, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250";
                
            
            br = new BufferedReader(new FileReader(file));
            String [] array;
            String [] inarray;
            System.out.println("");
            inarray = in.split(",");
            
            for(int i = 0; i < inarray.length;i++){
                inarray[i] = inarray[i].trim();
                list.add(Integer.parseInt(inarray[i]));
            }
            
            while ((line = br.readLine()) != null) {
                    line = line.trim();
                    array = line.split(" ");
                    
                    array[0] = array[0].trim();                    
                    array[1] = array[1].trim();
                         
                    
                    if(list.contains(Integer.parseInt(array[0])) && list.contains(Integer.parseInt(array[1]))){
//                        System.out.println(array[0] + " " + array[1]);
                        edges.add(new edge(Integer.parseInt(array[0]), Integer.parseInt(array[1])));
                        if(!vertices.contains(Integer.parseInt(array[0]))){
                            vertices.add(Integer.parseInt(array[0]));
                        }
                        if(!vertices.contains(Integer.parseInt(array[1]))){
                            vertices.add(Integer.parseInt(array[1]));
                        }
                    }       
            }
            
//            for(edge e: edges){
//                System.out.println(e);
//            }
//            System.out.println(vertices);
            Collections.sort(vertices);
//            System.out.println(vertices);

            int index = 1;
            
            for(Integer i:vertices){
                for(edge e: edges){
                    if(e.start.getNumber() == i && !e.start.isChanged()){
                        e.start.setNumber(index);
                        e.start.change();
                    }
                    
                    if(e.end.getNumber() == i && !e.end.isChanged()){
                        e.end.setNumber(index);
                        e.end.change();
                    }
                }
                ++index;
            }
            
            for(edge e: edges){
                System.out.println(e);
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
    

    public static void forTheLolz(){
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {
            String file = "../VFLibGraph/vflibtest/data/121.txt";
            String line;

            br = new BufferedReader(new FileReader(file));
            String [] array;
            int edges = 0;
            while ((line = br.readLine()) != null) {
                    line = line.trim();
                    array = line.split(" ");
                    
                    array[0] = array[0].trim();                    
                    array[1] = array[1].trim();
                    System.out.println("(" + array[0] + " ," + array[1] + "),");
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
    
    public static void forPython(){
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {
            String file = "../VFLibGraph/vflibtest/data/250.txt";
            String line;

            br = new BufferedReader(new FileReader(file));
            String [] array;
            int edges = 0;
            while ((line = br.readLine()) != null) {
                    line = line.trim();
                    array = line.split(" ");
                    
                    array[0] = array[0].trim();                    
                    array[1] = array[1].trim();
                    
                   /* if(Integer.parseInt(array[0]) == 1 || Integer.parseInt(array[1]) == 1 ||
                       Integer.parseInt(array[0]) == 2 || Integer.parseInt(array[1]) == 2 ||
                       Integer.parseInt(array[0]) == 3 || Integer.parseInt(array[1]) == 3 ||
                       Integer.parseInt(array[0]) == 4 || Integer.parseInt(array[1]) == 4 ||
                       Integer.parseInt(array[0]) == 5 || Integer.parseInt(array[1]) == 5 ||
                       Integer.parseInt(array[0]) == 6 || Integer.parseInt(array[1]) == 6 ||
                       Integer.parseInt(array[0]) == 7 || Integer.parseInt(array[1]) == 7 ||
                       Integer.parseInt(array[0]) == 8 || Integer.parseInt(array[1]) == 8 ||
                       Integer.parseInt(array[0]) == 9 || Integer.parseInt(array[1]) == 9 ||
                       Integer.parseInt(array[0]) == 10 || Integer.parseInt(array[1]) == 10||
                       Integer.parseInt(array[0]) == 11 || Integer.parseInt(array[1]) == 11||
                       Integer.parseInt(array[0]) == 12 || Integer.parseInt(array[1]) == 12||
                       Integer.parseInt(array[0]) == 13 || Integer.parseInt(array[1]) == 13||
                       Integer.parseInt(array[0]) == 14 || Integer.parseInt(array[1]) == 14||
                       Integer.parseInt(array[0]) == 15 || Integer.parseInt(array[1]) == 15||
                       Integer.parseInt(array[0]) == 16 || Integer.parseInt(array[1]) == 16||
                       Integer.parseInt(array[0]) == 17 || Integer.parseInt(array[1]) == 17||
                       Integer.parseInt(array[0]) == 18 || Integer.parseInt(array[1]) == 18||
                       Integer.parseInt(array[0]) == 19 || Integer.parseInt(array[1]) == 19||
                       Integer.parseInt(array[0]) == 20 || Integer.parseInt(array[1]) == 20||
                       Integer.parseInt(array[0]) == 21 || Integer.parseInt(array[1]) == 21){*/
                        ++edges;
                        if(!list.contains(Integer.parseInt(array[0]))){
                            list.add(Integer.parseInt(array[0]));
                        }
                        if(!list.contains(Integer.parseInt(array[1]))){
                            list.add(Integer.parseInt(array[1]));
                        }
//                    }
//                    System.out.println("(" + array[0] + "," + array[1] + "),");
                    
            }
            System.out.println(list);
            System.out.println("Size:\t" + list.size());
            System.out.println("Edges:\t" + edges);

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
