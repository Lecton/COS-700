/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lecton Ramasila
 */
public class Graph {
    
    public int [][] matrix;
    List<String> vertices;

    public Graph(int row, int col){
        matrix = new int[row][col];
        vertices = new ArrayList<>();
        for(int i = 0; i < row*col;i++){
            vertices.add(""+i);
        }
    }
    
    public Graph(int[][] matrix, List<String> vertices) {
        this.matrix = matrix;
        this.vertices = vertices;
    }
    
    
    public static int [][] dotproduct(int[][] a, int[][] b){
  int rowsInA = a.length;
       int columnsInA = a[0].length; // same as rows in B
       int columnsInB = b[0].length;
       int[][] c = new int[rowsInA][columnsInB];
       for (int i = 0; i < rowsInA; i++) {
           for (int j = 0; j < columnsInB; j++) {
               for (int k = 0; k < columnsInA; k++) {
                   c[i][j] = c[i][j] + a[i][k] * b[k][j];
               }
           }
       }
       return c;
    }    
    
    public int getColNumb(){
        return matrix[0].length;
    }
    
    public int getRowNumb(){
        return matrix.length;
    }
    
    public String getVertices(){
        String result = "";
        for(int j = 0; j < vertices.size();j++){
            result += vertices.get(j) + " ";
        }
        return result;
    }
    
    public int getVerticesCount(){
        return (this.vertices.size());
    }
    
    public boolean isomorphic(Graph gb){
        
        if(this.getVerticesCount() == gb.getVerticesCount()){
            return true;
        }
        return false;
    }
    
    public int [][] transpose(){
        int [][] t_matrix = new int [matrix[0].length][matrix.length];
        
        for(int i = 0; i < t_matrix.length;i++){            
            for(int j = 0; j < t_matrix[0].length;j++){
                t_matrix[i][j] = matrix[j][i];
            }
        }
        
        return t_matrix;
    }    
    
    public int [][] transpose(int [][] m){
        int [][] t_matrix = new int [m[0].length][m.length];
        
        for(int i = 0; i < t_matrix.length;i++){            
            for(int j = 0; j < t_matrix[0].length;j++){
                t_matrix[i][j] = m[j][i];
            }
        }
        
        return t_matrix;
    }    
    
    @Override
    public String toString() {
        String result = "  " + getVertices() + "\n";

        for(int i = 0; i < matrix.length;i++){
            result += vertices.get(i) + " ";
            for(int j = 0; j < matrix[0].length;j++){
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
