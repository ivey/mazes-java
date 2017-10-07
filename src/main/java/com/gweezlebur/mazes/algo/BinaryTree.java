package com.gweezlebur.mazes.algo;

import com.gweezlebur.mazes.grid.Cell;
import com.gweezlebur.mazes.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree {
    public static Grid on(Grid g) {
        Random rand = new Random();
        for(List<Cell> row : g.getCells()) {
            for(Cell cell : row) {
                List<Cell> neighbors = new ArrayList<>();
                if (cell.getN() != null) {
                    neighbors.add(cell.getN());
                }
                if (cell.getE() != null) {
                    neighbors.add(cell.getE());
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
