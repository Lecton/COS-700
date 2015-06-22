/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiGraph;

import GraphBuilder.GraphBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DiGraph {
    GraphBuilder g;
    String graphA, graphB;
    Integer [][] graph;
    List<String> vertices;

    public DiGraph(String fnameA, String fnameB) {
        graphA = fnameA;
        graphB = fnameB;
        g = new GraphBuilder();
    }
    
    public void build(){
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        try{
            String line;
            br = new BufferedReader(new FileReader(graphA));

            while ((line = br.readLine()) != null) {
                line = line.trim();
                list.add(line);
            }
            g.buildGraph(list);
            vertices = g.getVertices();
            graph = g.getGraph();

        }catch(IOException e){
        }finally{
            try {
                    if (br != null)br.close();
            } catch (IOException ex) {
            }
        }    
    }
 
    public String getVertices(){
        String result = "";
        for(int j = 0; j < vertices.size();j++){
            result += vertices.get(j) + " ";
        }
        return result;
    }
    
    @Override
    public String toString() {
        String result = "  " + getVertices() + "\n";

        for(int i = 0; i < graph.length;i++){
            result += vertices.get(i) + " ";
            for(int j = 0; j < graph[0].length;j++){
                result += graph[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
