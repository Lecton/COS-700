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

//    final static String pathG = "./G.txt";
//    final static String pathH = "./H.txt";
    final static String pathG = "./subject.txt";
    final static String pathH = "./object.txt";
    
    public static void main(String[] args){
//        test();
        GraphBuilder g = new GraphBuilder();
        Graph G = null;
        Graph H = null;
        
        g.readFile(pathG);
        g.buildGraph();        
        G = g.getGraph();
        
        g.readFile(pathH);
        g.buildGraph();        
        H = g.getGraph();
        
//        System.out.println(G);        
//        System.out.println(H);
        
        Ullman u = new Ullman(G, H);
        u.buildStart();
        u.generateRoot();
        
        System.out.println("----------------------");
        System.out.print(u);
        System.out.println("----------------------");
        
//        
        u.pruning();
    }
    
//    public static void test(){
//        int [][] matrix = new int[][]{
//            {4,-1},
//            {0,5}
//        };
//        
//        int [][] matrix2 = new int[][]{
//            {1,8,0},
//            {6,-2,3}
//        };
//        
//        for(int i = 0; i < matrix.length;i++){            
//            for(int j = 0; j < matrix[0].length;j++){
//                System.out.print(" " + matrix[i][j]);
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("");
//        
//        for(int i = 0; i < matrix2.length;i++){            
//            for(int j = 0; j < matrix2[0].length;j++){
//                System.out.print(" " + matrix2[i][j]);
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("");
//        Graph.dotproduct(matrix,matrix2);   
//    }
    

}
