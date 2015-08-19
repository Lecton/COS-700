#ifndef ENVIROMENT_H
#define ENVIROMENT_H
#include <iostream>
#include <string>
#include <stdio.h>
#include <list>
#include <unistd.h>
#include <ios>
#include <fstream>

using namespace std;
using namespace boost;

class Enviroment{ 
    private:
        long double startTime;
        long double endTime;
        string fname;
    public:
        Enviroment(string alg_name){
            startTime = time(0) * 1000;
            fname = "./report/"+alg_name+std::string("_report.csv");
            ofstream fs(fname);
            fs.close();
        }
        
        ~Enviroment();
        
        void setEndTime(){
            endTime = time(0) * 1000;
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
            fs.open(fname, std::ios::out | std::ios::app);
            fs << to_string(this->process_mem_usage()) + ",";
            fs << to_string(this->startTime) + std::string(",");
            fs << to_string(this->endTime);
            fs.close();
             
        }
};

#endif
