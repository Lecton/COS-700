
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class DataCaseGenerator {

    public static void main(String[] args){
        double [] percentages = {   
                                    0.0,0.05,0.1,0.15,0.20,0.25,
                                    0.30,0.35,0.40,0.45,0.50,0.55,
                                    0.60,0.65,0.70,0.75,0.80,0.85,
                                    0.90,0.95                                };
        List<String> flines = new ArrayList<>();
        ArrayList<String> pfile = new ArrayList<>();
        List<ArrayList> files = new ArrayList<>();
        BufferedReader br = null;
        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader("../VFLibGraph/vflibtest/cases/data/best.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                flines.add(sCurrentLine + "\n");
            }
            
            Collections.shuffle(flines);
            int len = flines.size();
            int fence = 0;
            for(int i = 0; i < percentages.length;i++){
                fence = (int)(len - (len * percentages[i]));
                pfile = new ArrayList<>();
                for(int j = 0; j < fence;j++){
                    pfile.add(flines.get(j));
                }
                files.add(pfile);
            }
            
            for(int i = 0; i < files.size();i++){
                pfile = files.get(i);
                write(files.get(i), ""+files.get(i).size());
            }
            
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }        
    }
    
    public static void write(ArrayList<String> content,String name){
        try {
            File file = new File("./"+name+".txt");
            
            if (!file.exists()) {
                    file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < content.size();i++){
                bw.write(content.get(i));
            }
            bw.close();
        } catch (IOException e) {
                e.printStackTrace();
        }        
    }
}
