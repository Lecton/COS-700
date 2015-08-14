 /* 
 * File:   main.cpp
 * Author: lecton
 *
 * Created on 01 July 2015, 7:59 AM
 */
#include <iostream>
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <list>
#include<stdio.h>
#include<cstdlib>
#include<iostream>
#include<string.h>
#include<fstream>
#include<dirent.h>
#include <boost/tokenizer.hpp>
#include "./headers/argraph.h"
#include "./headers/argedit.h"
#include "./headers/vf2_sub_state.h"
#include "./headers/match.h"
#include "./headers/graph_parser.h"
#include "./headers/comperer.h"
#include "./headers/instance_env.h"

using namespace std;
using namespace boost;

/*
 * Degree of isomorphism.
 * Start writing my paper.
 * Calibrate the data.
 * Library and where the data is from.
 */

//void createGraphs(ARGEdit &s, ARGEdit &l);
//ARGEdit& createGraph(ARGEdit &g,list<int> &n,list<relation> &r);
void printGraph(Graph &);
void baseComparison(Graph,Graph);
void test();
void algorithm(string,string);
Enviroment* e;
int main(){
    
    
    DIR* dir;
    list<string> dfile;
    struct dirent *entry;
    e = new Enviroment("VF2");
    if(dir=opendir("./data") ){
            while(entry = readdir(dir)){
                    if( strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0 )
                    dfile.push_back(entry->d_name);
            }
            closedir(dir);
    }
    
    for(std::list<string>::iterator i = dfile.begin(); i != dfile.end(); i++){
        for(std::list<string>::iterator j = dfile.begin(); j != dfile.end(); j++){
            if((*i).compare(*j) != 0){
                
                algorithm(*i,*j);
                cout << "here" << endl;
            }
            
        }
    }
    e->env_report();   
    return 0;
}

void algorithm(string fn1,string fn2){
    GraphParser* gp[2];
    Comperer* comperer = new Comperer();
    ARGEdit aet[2];
    fn1 = "./data/" + fn1;
    fn2 = "./data/" + fn2;
    gp[0] = new GraphParser(fn1);
    gp[1] = new GraphParser(fn2);
    
    /************************************** Graph 1 **************************************/
    gp[0]->parseGraph();
    gp[0]->createGraph(aet[0]);
    Graph graph0(&aet[0]);        
    cout << "Graph one has so many nodes." << endl;
    cout << graph0.NodeCount() << endl;        
    /************************************** Graph 2 **************************************/
    gp[1]->parseGraph();
    gp[1]->createGraph(aet[1]);
    Graph graph1(&aet[1]);        
    cout << "Graph two has so many nodes." << endl;
    cout << graph1.NodeCount() << endl;
    

    /************************************** Comparison **************************************/    
    cout << "\n\nComparison" << endl;
    comperer->comparison(graph0,graph1);

//    if(graph0.NodeCount() < graph1.NodeCount()){
//        if(!comperer->comparison(graph0,graph1)){
//            cout << "Match was not found." << endl;
//        }
//    }else{
//        if(!comperer->comparison(graph1,graph0)){
//            cout << "Match was not found." << endl;
//        }
//    } 
    
//    gp[1] = NULL;
//    gp[2] = NULL;
//    graph0 = NULL;
//    graph1 = NULL;
}

void printGraph(Graph & g){
        cout << "Edges" << endl;
        for(int i = 0; i < g.NodeCount();i++){
            cout << i << " : "<< g.EdgeCount(i) << endl;
        }
        
        cout << "Out Edges" << endl;
        for(int i = 0; i < g.NodeCount();i++){
            cout << i << " : "<< g.OutEdgeCount(i) << endl;
        }
        
        cout << "In Edges" << endl;
        for(int i = 0; i < g.NodeCount();i++){
            cout << i << " : "<< g.InEdgeCount(i) << endl;
        }    
} 