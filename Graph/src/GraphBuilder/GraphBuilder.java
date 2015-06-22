package GraphBuilder;


import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

    Integer [][] graph;
    List<String> vertices;
    
    public GraphBuilder(){}
    
    public void buildGraph(List l){
        graph = new Integer[l.size()][l.size()];
        vertices = new ArrayList<>();
        String chil;
        String [] array;
        
        for(int i = 0; i < l.size();i++){
            for(int j = 0; j < l.size();j++){
                graph[i][j] = 0;
            }
        }
        
        
        for(int i = 0; i < l.size();i++){
            chil = (String)l.get(i);
            vertices.add(chil.substring(0,1));
        }
        
        for(int i = 0; i < l.size();i++){
            chil = (String)l.get(i);
            chil = chil.substring(chil.lastIndexOf(":")+1, chil.length());
            array = chil.split(",");
            for(int j = 0; j < array.length;j++){
                ++graph[i][vertices.indexOf(array[j])];
            }
        }
    }
        
    public List<String> getVertices(){
        return vertices;
    }

    public Integer[][] getGraph() {
        return graph;
    }
    
    public void drawGraph(){
        JFrame frame = new JFrame("Graph");
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);        
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
