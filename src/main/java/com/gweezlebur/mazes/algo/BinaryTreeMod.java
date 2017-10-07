package com.gweezlebur.mazes.algo;

import com.gweezlebur.mazes.grid.Cell;
import com.gweezlebur.mazes.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTreeMod {
    public static Grid on(Grid g) {
        Random rand = new Random();
        for(List<Cell> row : g.getCells()) {
            for(Cell cell : row) {
                List<Cell> neighbors = new ArrayList<>();
                if (cell.getS() != null) {
                    neighbors.add(cell.getS());
                }
                if (cell.getW() != null) {
                    neighbors.add(cell.getW());
                }
                if (!neighbors.isEmpty()) {
                    int x = rand.nextInt(neighbors.size());
                    Cell neighbor = neighbors.get(x);

                    if (neighbor != null) {
                        cell.link(neighbor);
                    }
                }
            }
        }
        return g;
    }
}
