
#ifndef COMPERER_H
#define COMPERER_H
#include <iostream>
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <list>

using namespace std;
using namespace boost;

class Comperer{ 
    private:
    public:
        Comperer(){}
        
        ~Comperer();
        
        bool comparison(Graph sg,Graph lg){
            //initialization state
            VF2SubState s0(&sg,&lg);

            int n;
            node_id ni1[500000];
            node_id ni2[500000];

            if(!match(&s0,&n,ni1,ni2)){
                return false;
            }else{
                cout << "n: " << n << endl;
                for(int i = 0; i < n;i++){
                    printf("\tNode %hd of graph 1 is paired with node %hd of graph 2\n",
                   ni1[i], ni2[i]);
                }
                return true;
            }
        }
};

#endif
