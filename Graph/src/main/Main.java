/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import DiGraph.DiGraph;
import GraphBuilder.GraphBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lecton Ramasila
 */
public class Main {

    final static String path = "./H.txt";
    
    public static void main(String[] args) {
        DiGraph dg = new DiGraph(path, path);
        dg.build();
        System.out.println(dg);
    }
}
