#ifndef ENVIROMENT_H
#define ENVIROMENT_H
#include <iostream>
#include <string>
#include <stdio.h>
#include <list>
#include <unistd.h>
#include <ios>
#include <sys/time.h>
#include <fstream>

using namespace std;
using namespace boost;

class Enviroment{ 
    private:
	long mtime, seconds, useconds; 
	struct timeval start, end;
        string fname;
    public:
        Enviroment(string alg_name){
	    gettimeofday(&start, NULL);
            fname = "./report/"+alg_name+std::string("_report.csv");
            ofstream fs(fname);
            fs.close();
        }
        
        ~Enviroment();
        
        void setEndTime(){
	  gettimeofday(&end, NULL);
	  seconds  = end.tv_sec  - start.tv_sec;
	  useconds = end.tv_usec - start.tv_usec;
	  mtime = ((seconds) * 1000 + useconds/1000.0);
	  printf("Elapsed time: %ld milliseconds  ", mtime);
	  cout << fname << endl;
        }
        
        double process_mem_usage(){
           using std::ios_base;
           using std::ifstream;
           using std::string;

           double vm_usage = 0.0;
           double resident_set = 0.0;

           // 'file' stat seems to give the most reliable results
           //
           ifstream stat_stream("/proc/self/stat",ios_base::in);

           // dummy vars for leading entries in stat that we don't care about
           //
           string pid, comm, state, ppid, pgrp, session, tty_nr;
           string tpgid, flags, minflt, cminflt, majflt, cmajflt;
           string utime, stime, cutime, cstime, priority, nice;
           string O, itrealvalue, starttime;

           // the two fields we want
           //
           unsigned long vsize;
           long rss;

           stat_stream >> pid >> comm >> state >> ppid >> pgrp >> session >> tty_nr
                       >> tpgid >> flags >> minflt >> cminflt >> majflt >> cmajflt
                       >> utime >> stime >> cutime >> cstime >> priority >> nice
                       >> O >> itrealvalue >> starttime >> vsize >> rss; // don't care about the rest

           stat_stream.close();

           long page_size_kb = sysconf(_SC_PAGE_SIZE) / 1024; // in case x86-64 is configured to use 2MB pages
           vm_usage     = vsize / 1024.0;
           resident_set = rss * page_size_kb;
           return resident_set;
        }
        
        void env_report(){
            ofstream fs;
            fs.open(fname, ios::app);
            fs << to_string(this->process_mem_usage()) + ",";
            fs << to_string(this->mtime) + std::string(",");;
            fs.close();
        }
};

#endif
