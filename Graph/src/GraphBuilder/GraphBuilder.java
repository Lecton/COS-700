package GraphBuilder;


import java.util.ArrayList;
import java.util.List;
import Graph.Graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lecton Ramasila
 */
public class GraphBuilder {

    int [][] matrix;
    List<String> vertices;
    List<String> list;
    public GraphBuilder(){}
    
    public void readFile(String path){        
        BufferedReader br = null;
        list = new ArrayList<>();
        try{
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                line = line.trim();
                list.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                    if (br != null)br.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
    public void buildGraph(){
        if(list != null){
            matrix = new int[list.size()][list.size()];
            vertices = new ArrayList<>();
            String chil;
            String [] array;

            for(int i = 0; i < list.size();i++){
                for(int j = 0; j < list.size();j++){
                    matrix[i][j] = 0;
                }
            }

            for(int i = 0; i < list.size();i++){
                chil = (String)list.get(i);
                vertices.add(chil.substring(0,1));
            }
            
            for(int i = 0; i < list.size();i++){
                chil = (String)list.get(i);
                chil = chil.substring(chil.lastIndexOf(":")+1, chil.length());
                array = chil.split(",");
                for(int j = 0; j < array.length;j++){
                    ++matrix[i][vertices.indexOf(array[j])];
                }
            }
        }else{
            System.out.println("GraphBuilder-buildGraph: List is empty");
            System.exit(0);     
        }
    }
    
    public Graph getGraph(){
        return (new Graph(matrix, vertices));
    }
}
