package com.gweezlebur.mazes.grid;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cell {
    @Getter private int x;
    @Getter private int y;

    @Getter @Setter private Cell n;
    @Getter @Setter private Cell s;
    @Getter @Setter private Cell e;
    @Getter @Setter private Cell w;

    private Map<Cell,Boolean> links;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        links = new HashMap<>();
    }

    public Cell link(Cell c) {
        return link(c, true);
    }

    public Cell link(Cell c, boolean bidirectional) {
        links.put(c,true);
        if (bidirectional) {
            c.link(this, false);
        }
        return this;
    }

    public Cell unlink(Cell c) {
        return unlink(c, true);
    }

    public Cell unlink(Cell c, boolean bidirectional) {
        links.remove(c);
        if (bidirectional) {
            c.unlink(this, false);
        }
        return this;
    }

    public Set<Cell> links() {
        return links.keySet();
    }

    public boolean isLinked(Cell c) {
        return links.containsKey(c);
    }

    public Set<Cell> neighbors() {
        Set<Cell> neighbors = new HashSet<>();
        if (n != null)
            neighbors.add(n);
        if (s != null)
            neighbors.add(s);
        if (e != null)
            neighbors.add(e);
        if (w != null)
            neighbors.add(w);
        return neighbors;
    }

    public String toString() {
        StringBuffer o = new StringBuffer("Cell(x="+this.x+", y="+this.y);
        if (n != null) {
            o.append(", N=(" + this.n.x + "," + this.n.y + ",link=" + isLinked(n) + ")");
        }
        if (s != null) {
            o.append(", S=(" + this.s.x + "," + this.s.y + ",link=" + isLinked(s) + ")");
        }
        if (e != null) {
            o.append(", E=(" + this.e.x + "," + this.e.y + ",link=" + isLinked(e) + ")");
        }
        if (w != null) {
            o.append(", W=(" + this.w.x + "," + this.w.y + ",link=" + isLinked(w) + ")");
        }
        o.append(")");
        return o.toString();
    }
}
