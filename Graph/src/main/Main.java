/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Algorithms.Ullman;
import Graph.Graph;
import GraphBuilder.GraphBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Lecton Ramasila
 * 
 * Subject graph is G.
 */
public class Main {

    final static String pathG = "./G.txt";
    final static String pathH = "./H.txt";
//    final static String pathG = "./subject.txt";
//    final static String pathH = "./object.txt";
    
    public static void main(String[] args){
        
//        int [][] matrix = new int[][]{
//            {1,0,0,0},
//            {0,1,0,0},
//            {0,0,0,1}
//        };
//        
//        for(int i = 0; i < matrix.length;i++){            
//            for(int j = 0; j < matrix[0].length;j++){
//                System.out.print(" " + matrix[i][j]);
//            }
//            System.out.println("");
//        }
//        
//        if(isvalid(matrix)){
//            System.out.println("yes");
//        }else{
//            System.out.println("no");
//        }
        
//        int[] row = matrix[2];
//        
//        for(int j = 0; j < row.length;j++){
//            System.out.print(" " + row[j]);
//        }
//        
//        System.out.println("");
//        
//        List<int[]> col = new ArrayList<>();
//        
//        for(int j = 0; j < matrix.length;j++){
//            if(j == 2){
//                for(int i = 0; i < matrix[0].length;i++){
//                    System.out.println(matrix[i][j]);
//                }
//            }
//        }
        
        GraphBuilder g = new GraphBuilder();
        Graph G = null;
        Graph H = null;
        
        g.readFile(pathG);
        g.buildGraph();        
        G = g.getGraph();
        
        g.readFile(pathH);
        g.buildGraph();        
        H = g.getGraph();
        
        Ullman u = new Ullman(G, H);
        u.buildStart();
        u.generateRoot();
        
        System.out.println("----------------------");
        System.out.println(u);
        System.out.println("----------------------");
//        
//        
        u.pruning();
    }
    
    
}
