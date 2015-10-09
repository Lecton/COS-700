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
/*  Algorithms headers */
#include "./headers/vf2_sub_state.h"
#include "./headers/ull_sub_state.h"

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
    
    string con = "./cases/control/worst/worst.txt";
    string conTest = "./cases/data/worst/worstTest.txt";
    algorithm(con,conTest);   
    return 0;
}

void algorithm(string fn1,string fn2){  
    int alg = 2;
    string filename = "worst";
    string method = "VF2";
    
    GraphParser* gp[2];
    Comperer* comperer = new Comperer();
    ARGEdit aet[2];
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
    

    int lnodes = 0;
    
    if(graph0.NodeCount() < graph1.NodeCount()){        
        filename = string(method) + string(" ") + string(filename);
    }else{
        filename = string(method) + string(" ") + string(filename);
    }
    
    e = new Enviroment(filename);
    int n;
    
    node_id ni1[100], ni2[100];
    if(alg == 1){
        if(graph0.NodeCount() < graph1.NodeCount()){
            UllSubState s0(&graph0,&graph1);
            
            if(!match(&s0,&n,ni1,ni2)){
                printf("No match found.\n");
                return ;
            }else{
                printf("Found a matching with %d nodes:\n",n);
		for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}
            }
        }else{
            UllSubState s0(&graph1,&graph0);
            
            if(!match(&s0,&n,ni1,ni2)){
                printf("No match found.\n");
                return ;
            }else{
                printf("Found a matching with %d nodes:\n",n);
		for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}
            }
        }
    }else{
        if(graph0.NodeCount() < graph1.NodeCount()){
            VF2SubState s0(&graph0,&graph1);
            
            if(!match(&s0,&n,ni1,ni2)){
                printf("No match found.\n");
                return ;
            }else{
                printf("Found a matching with %d nodes:\n",n);
		for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}
            }
        }else{
            VF2SubState s0(&graph1,&graph0);
            
            if(!match(&s0,&n,ni1,ni2)){
                //printf("No match found.\n");
                return ;
            }else{
                //printf("Found a matching with %d nodes:\n",n);
		/*for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}*/
            }
        }
    }
    e->setEndTime();
    e->env_report();
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