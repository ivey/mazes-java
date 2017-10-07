package com.gweezlebur.mazes.algo;

import com.gweezlebur.mazes.grid.Cell;
import com.gweezlebur.mazes.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sidewinder {
    public static Grid on(Grid g) {
        Random rand = new Random();
        for(List<Cell> row : g.getCells()) {
            List<Cell> run = new ArrayList<>();

            for(Cell cell : row) {
                run.add(cell);

                if ((cell.getE() == null)
                        || (cell.getN() != null && rand.nextBoolean())) {
                    int x = rand.nextInt(run.size());
                    Cell member = run.get(x);
                    if (member.getN() != null) {
                        member.link(member.getN());
                    }
                    run.clear();
                } else {
                    cell.link(cell.getE());
                }
            }
        }
        return g;
    }
}
