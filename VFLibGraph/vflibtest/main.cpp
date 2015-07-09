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
#include <boost/tokenizer.hpp>
#include "./headers/argraph.h"
#include "./headers/argedit.h"
#include "./headers/vf2_sub_state.h"
#include "./headers/match.h"
#include "./headers/graph_parser.h"
#define MAXNODES 3

using namespace std;
using namespace boost;

//void createGraphs(ARGEdit &s, ARGEdit &l);
//ARGEdit& createGraph(ARGEdit &g,list<int> &n,list<relation> &r);
void printGraph(Graph &);
void baseComparison(Graph,Graph);

int main(){
    GraphParser* gp[2];
    ARGEdit aet[2];
    gp[0] = new GraphParser("./data/graph1.txt");
    gp[1] = new GraphParser("./data/graph2.txt");
    
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
    if(graph0.NodeCount() < graph1.NodeCount()){
        baseComparison(graph0,graph1);
    }else{
        baseComparison(graph1,graph0);
    }
    
    return 0;
}


void baseComparison(Graph sg,Graph lg){
    //initialization state
    VF2SubState s0(&sg,&lg);

    int n;
    node_id ni1[sg.NodeCount()];
    node_id ni2[sg.NodeCount()];

    if(!match(&s0,&n,ni1,ni2)){
        printf("No matching found.\n");
    }else{
        cout << "n: " << n << endl;
        for(int i = 0; i < n;i++){
            printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n",
           ni1[i], ni2[i]);
        }
    }
            
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