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
void printGraph(Graph &g);
void baseComparison();
bool is_number(const string& s);

int main(){
    GraphParser* gp = new GraphParser("./data/graph1.txt");
    gp->parseGraph();
//
        ARGEdit aet;
        gp->createGraph(aet);
        Graph graph(&aet);
//        printGraph(graph);
//    }else{
//        cout << "Could not open file" << endl;
//    }
    return 0;
}


void baseComparison(){
ARGEdit large, small;  // The object used to create the graph
    int i,j;
//    createGraphs(small,large);
          
    // Now the Graph can be constructed...
    Graph lg(&large);
    Graph sg(&small);

    //initialization state
    VF2SubState s0(&sg,&lg);

    int n;
    node_id ni1[MAXNODES];
    node_id ni2[MAXNODES];

    if(!match(&s0,&n,ni1,ni2)){
        printf("No matching found.\n");
        return;
    }else{
        cout << "n: " << n << endl;
        for(int i = 0; i < n;i++){
            printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n",
           ni1[i], ni2[i]);
        }
    }
            
}
//
//void createGraph(ARGEdit &g,list<int> &n,list<relation> &r){
//    for(std::list<int>::const_iterator iterator = n.begin(), end = n.end(); iterator != end; ++iterator) {
//        g.InsertNode(NULL);
//     } 
//    
//    for(std::list<relation>::const_iterator iterator = r.begin(), end = r.end(); iterator != end; ++iterator) {
//        g.InsertEdge(((*iterator).first)-1,((*iterator).second)-1,NULL);
//     }
//    
//}
//
//void createGraphs(ARGEdit &s, ARGEdit &l){
//    //Large graph
//    l.InsertNode(NULL);
//    l.InsertNode(NULL);
//    l.InsertNode(NULL);
//    l.InsertNode(NULL);
//    
//    l.InsertEdge(0,1,NULL);
//    l.InsertEdge(1,0,NULL);
//    l.InsertEdge(1,2,NULL);
//    l.InsertEdge(1,3,NULL);
//    l.InsertEdge(2,1,NULL);
//    l.InsertEdge(3,1,NULL);
////
////    //Small graph
//    s.InsertNode(NULL);
//    s.InsertNode(NULL);
//    s.InsertNode(NULL);
////    
//    s.InsertEdge(0,2,NULL);
//    s.InsertEdge(1,2,NULL);
//    s.InsertEdge(2,0,NULL);
//    s.InsertEdge(2,1,NULL);
//}

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