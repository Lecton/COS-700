/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class edge {
    public vertex start;
    public vertex end;

    public edge(int start, int end) {
        this.start = new vertex(start);
        this.end = new vertex(end);
    }

    public void setStart(vertex start) {
        this.start = start;
        this.start.change();
    }

    public void setEnd(vertex end) {
        this.end = end;
        this.start.change();
    }

    @Override
    public String toString() {
        return start.number + " " + end.number;
    }
    
}
