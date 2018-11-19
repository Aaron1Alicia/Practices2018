package design;

import java.util.Iterator;
import java.util.List;

// 这一题是airbnb那一道题的子集
public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        this.i = vec2d.iterator();
        this.j = null;
    }

    @Override
    public boolean hasNext() {

        while((j==null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }


        return j!=null && j.hasNext();
    }

    @Override
    public Integer next() {
        if(!j.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return j.next();
    }
}
