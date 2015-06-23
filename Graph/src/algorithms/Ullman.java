/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;
import Graph.Graph;

/**
 *
 * @author user
 */
public class Ullman {
    private Graph subject;
    private Graph object;
    private Graph M;
    
    public Ullman(Graph subject, Graph object) {
        this.subject = subject;
        this.object = object;
    }
    
    public void buildStart(){
        int colNum = subject.getVerticesCount();
        int rowNum = object.getVerticesCount();
        M = new Graph(rowNum, colNum);
        
        for(int i = 0; i < M.matrix.length;i++){
            for(int j = 0; j < M.matrix[0].length;j++){
                M.matrix[i][j] = 1;
            }
        }
    }
    
    public void generateRoot(){
        // j = col AND i = row
        int col = 0, row = 0;
        
        for(int i = 0; i < M.matrix.length;i++){
            for(int j = 0; j < M.matrix[0].length;j++){
                if(degree(j, 0) < degree(i, 1)){
                    M.matrix[i][j] = 0  ;
                }
            }
        }
    }
    
    private int degree(int index, Graph grid){
        int degree = 0;
        for(int i = 0; i < grid.matrix[index].length;i++){
            if(grid.matrix[index][i] == 1){
                ++degree;
            }
        }
        return degree;
    }
    
    private int degree(int index,int subOrobj){
        int degree = 0;
        if(subOrobj == 0){
            for(int j = 0; j < subject.matrix.length;j++){
                if(j == index){
                    for(int i = 0; i < subject.matrix[0].length;i++){
                        if(subject.matrix[i][j] == 1){
                            ++degree;
                        }
                    }
                }
            }
        }else{
            int[] row = object.matrix[index];
            for(int i = 0; i < row.length;i++){
                if(row[i] == 1){
                    ++degree;
                }
            }            
        }
        return degree;
    }
        
    public void pruning(){
        pruning(0,M);
    }
    
    public void pruning(int row, Graph _M){
        if(row == _M.getRowNumb()){
            //Check Isomorphism
            if(isvalid(_M.matrix)){
                if(isIsomorphic(_M)){
                    System.out.println("yes");
                }
                return;
            }else{
                return;
            }
        }
        
        Graph M_ = _M;
        
        for(int i = 0; i < M_.matrix[0].length;i++){
            for(int j = 0; j < M_.matrix[0].length;j++){
                if(i == j){
                    M_.matrix[row][j] = 1;
                    
                }else{
                    M_.matrix[row][j] = 0;
                }
            }
            pruning(row+1,M_);
        }
    }
    
    public boolean isIsomorphic(Graph P){        
        int [][] result = Graph.dotproduct(P.matrix, subject.matrix);
        result = P.transpose(result);
        result = Graph.dotproduct(P.matrix,result);        

        for(int i = 0; i < result.length;i++){
            for(int j = 0; j < result[0].length;j++){
                if(result[i][j] != object.matrix[i][j]) return false;
            }
        }
        return true;
    }
    
    public boolean isvalid(int [][] matrix){        
        int sum;
        //Colums
        for(int i = 0; i < matrix[0].length;i++){
            sum = 0;
            for(int j = 0; j < matrix.length;j++){
                sum += matrix[j][i];
            }
            if(sum > 1) return false;
        }
        //Rows
        for(int i = 0; i < matrix.length;i++){
            sum = 0;
            for(int j = 0; j < matrix[0].length;j++){
                sum += matrix[i][j];
            }
            if(sum != 1) return false;
        }
        
        return true;
    }
    
    public String matrixtoString(Graph G){
        String result = "";

        for(int i = 0; i < G.matrix.length;i++){
            for(int j = 0; j < G.matrix[0].length;j++){
                result += G.matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
    
    
    @Override
    public String toString(){
        return matrixtoString(M);
    }
}
