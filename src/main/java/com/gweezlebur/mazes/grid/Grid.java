package com.gweezlebur.mazes.grid;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private int rows;
    private int cols;

    @Getter
    private List<List<Cell>> cells;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        prepareGrid();
        configureCells();
    }

    public Grid(int size) {
        this(size, size);
    }

    private Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return null;
        }
        List<Cell> row = cells.get(x);
        if (row == null) {
            return null;
        }
        return row.get(y);
    }

    public Cell randomCell() {
        Random rand = new Random();
        int x = rand.nextInt(rows);
        int y = rand.nextInt(cols);
        return getCell(x,y);
    }

    public int size() {
        return rows*cols;
    }

    private void configureCells() {
        for(List<Cell> row : cells) {
            for(Cell cell : row) {
                int x = cell.getX();
                int y = cell.getY();
                cell.setN(getCell(x-1, y));
                cell.setS(getCell(x+1, y));
                cell.setW(getCell(x,y-1));
                cell.setE(getCell(x, y+1));
            }
        }
    }

    private void prepareGrid() {
        cells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Cell> col = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                col.add(new Cell(i,j));
            }
            cells.add(col);
        }
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append("+")
            .append(new String(new char[cols]).replace("\0", "---+"))
            .append("\n");

        for(List<Cell> row : cells) {
            StringBuffer top = new StringBuffer("|");
            StringBuffer bot = new StringBuffer("+");

            for(Cell cell : row) {
                if (cell == null) {
                    cell = new Cell(-1,-1);
                }

                top.append("   ");
                top.append(cell.isLinked(cell.getE()) ? " " : "|");

                bot.append(cell.isLinked(cell.getS()) ? "   " : "---");
                bot.append("+");
            }
            output.append(top).append("\n")
                    .append(bot).append("\n");
        }

        return output.toString();
    }
}
