
#ifndef GRAPH_PARSER_H
#define GRAPH_PARSER_H
#include <iostream>
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <list>

using namespace std;
using namespace boost;

class GraphParser{ 
    private:
        typedef std::pair<int,int> relation;
        string fname;
        list<relation> relationships;
        list<int> nodes;
    public:
        GraphParser(){
            fname = "";
        }
        
        GraphParser(string fn){
            fname = fn;
        }

        ~GraphParser();
        
        
        void parseGraph(){
            char_separator<char> sep(" ");
            string line;
            ifstream file(fname);
            if(file.is_open()){
                int i = 0;
                int first, second;
                while(getline(file,line)){
                    ++i;
                    tokenizer<> token(line);
                    tokenizer<>::iterator beg=token.begin();
                    first = std::stoi(*beg);
                    second = std::stoi(*(++beg));
                    nodes.push_back(first);
                    nodes.push_back(second);

                    relation rel;
                    rel.first = (first);
                    rel.second = (second);
                    relationships.push_back(rel);
                }
                nodes.sort();
                nodes.erase(unique(nodes.begin(), nodes.end()), nodes.end());
                file.close();
            }else{
                cout << "File could not be open." << endl;
            }
            
        }
        
        void createGraph(ARGEdit& g){
            for(std::list<int>::const_iterator iterator = nodes.begin(), end = nodes.end(); iterator != end; ++iterator) {
                g.InsertNode(NULL);
             } 

            for(std::list<relation>::const_iterator iterator = relationships.begin(), end = relationships.end(); iterator != end; ++iterator) {
                g.InsertEdge(((*iterator).first)-1,((*iterator).second)-1,NULL);
             }
        }
};

#endif
