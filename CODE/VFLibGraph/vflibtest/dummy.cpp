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