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

void algorithm(string);
void buildGraphs();
int test();
char *time_stamp();
Enviroment* e;
string method = "";
int alg = -1;
string cfile = "./control/250.txt";
string file30 = "./data/30.txt";
string file56 = "./data/56.txt";
string file75 = "./data/75.txt";
string file92 = "./data/92.txt";
string file109 = "./data/109.txt";
string file121 = "./data/121.txt";
string file148 = "./data/148.txt";
string file166 = "./data/166.txt";
string file181 = "./data/181.txt";
string file197 = "./data/197.txt";
string file211 = "./data/211.txt";
string file222 = "./data/222.txt";

int main(int argc, char *argv[]){
    alg = atoi(argv[1]);
    if(alg == 1){
        method = "Ullman";
    }else{
        method = "VF2";
    }
    buildGraphs();
    return 0;
}

void buildGraphs(){
    DIR* dir;
    list<string> dfile;
    struct dirent *entry;
    if(dir=opendir("./data") ){
            while(entry = readdir(dir)){
                    if( strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0 )
                    dfile.push_back(entry->d_name);
            }
            closedir(dir);
    }
   
    for(std::list<string>::iterator i = dfile.begin(); i != dfile.end(); i++){
	algorithm(*i);
    }
}

void algorithm(string fn1){
    string filename = fn1;
    fn1 = "./data/" + fn1;
    GraphParser* gp[2];
    Comperer* comperer = new Comperer();
    ARGEdit aet[2];;
    gp[0] = new GraphParser(fn1);
    gp[1] = new GraphParser(cfile);
    
    /************************************** Graph 1 **************************************/
    gp[0]->parseGraph();
    gp[0]->createGraph(aet[0]);
    Graph graph0(&aet[0]);
    /************************************** Graph 2 **************************************/
    gp[1]->parseGraph();
    gp[1]->createGraph(aet[1]);
    Graph graph1(&aet[1]);
    /************************************** Comparison **************************************/    
    int lnodes = 0;
    if(graph0.NodeCount() < graph1.NodeCount()){        
        filename = string(method) + string(" ") + string(filename);
    }else{
        filename = string(method) + string(" ") + string(filename);
    }
    
    e = new Enviroment(filename);
    int n;
    
    node_id ni1[250], ni2[250];
    
    if(alg == 1){
        if(graph0.NodeCount() < graph1.NodeCount()){
            UllSubState s0(&graph0,&graph1);
            
            if(!match(&s0,&n,ni1,ni2)){
                //printf("No match found.\n");
                return ;
            }else{
                //printf("Found a matching with %d nodes:\n",n);
		/*for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}*/
            }
        }else{
            UllSubState s0(&graph1,&graph0);
            
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
    }else{
        if(graph0.NodeCount() < graph1.NodeCount()){
            VF2SubState s0(&graph0,&graph1);
            
            if(!match(&s0,&n,ni1,ni2)){
                //printf("No match found.\n");
                return ;
            }else{
                //printf("Found a matching with %d nodes:\n",n);
		/*for(int i = 0; i < n; i++){
		  printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n", ni1[i],ni2[i]);
		}*/
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

int  test(){
    ARGEdit small_ed,large_ed;
    int i,j;
    int SIZE = 4;
    int MAXNODES = 200;
    
    for(int i = 0; i < SIZE;i++){
        small_ed.InsertNode(NULL);
    }
    
    for(int i = 0; i < SIZE*2;i++){
        large_ed.InsertNode(NULL);
    }
    
    for(int i = 0; i < SIZE;i++){
        for(int j = 0; j < SIZE;j++){
            if(i != j){
                small_ed.InsertEdge(i,j,NULL);
            }
        }
    }
    
    for(int i = 0; i < SIZE;i++){
        for(int j = 0; j < SIZE;j++){
            if(i != j){
                large_ed.InsertEdge(i,j,NULL);
            }
        }
    }
    
    Graph gsmall(&small_ed);
    Graph glarge(&large_ed);
    
    VF2SubState s0(&gsmall,&glarge);
    
    int n;
    
    node_id ni1[MAXNODES], ni2[MAXNODES];
    
    if(!match(&s0,&n,ni1,ni2)){
        printf("No match found.");
        return 1;
    }
    
    printf("Found a matching with %d nodes:\n",n);

    for(int i = 0; i < SIZE;i++){
        printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n",ni1[i], ni2[i]);
    }
    
}
