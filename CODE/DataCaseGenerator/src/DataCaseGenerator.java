
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        double [] percentages = {0.0,0.25,0.5,0.75,1.0};
        List<String> flines = new ArrayList<>();
        BufferedReader br = null;
        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader("../VFLibGraph/vflibtest/cases/control/control.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                flines.add(sCurrentLine);
            }
            
            
            int len = flines.size();
            int fence = 0;
            System.out.println("len " + len);
            for(int i = 0; i < percentages.length;i++){
                fence = (int)(len - (len * percentages[i]));
                System.out.println(fence);
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
}
