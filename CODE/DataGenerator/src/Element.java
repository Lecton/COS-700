/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lecton
 */
public class Element {
    int start;
    int end;

    public Element(int i, int j) {
        this.start = i;
        this.end = j;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        if(end != -1){
            return start + " " + end;
        }else{
            return start+"";
        }
    }
    
    
}
