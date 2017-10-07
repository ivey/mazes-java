package com.gweezlebur.mazes;

import com.gweezlebur.mazes.algo.BinaryTree;
import com.gweezlebur.mazes.algo.BinaryTreeMod;
import com.gweezlebur.mazes.algo.Sidewinder;
import com.gweezlebur.mazes.algo.SidewinderMod;
import com.gweezlebur.mazes.grid.Grid;

public class Main {

    public static void main(String[] args) {
        int size = 0;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        String algo = "";
        if (args.length > 1) {
            algo = args[1];
        }

        if (size <= 0) {
            size = 5;
        }
        Grid grid = new Grid(size);
        switch (algo) {
            case "binarytree":
                System.out.println("Using binarytree");
                BinaryTree.on(grid);
                break;
            case "sidewinder":
                System.out.println("Using sidewinder");
                Sidewinder.on(grid);
                break;
            case "binarytreemod":
                System.out.println("Using binarytreemod");
                BinaryTreeMod.on(grid);
                break;
            case "sidewindermod":
                System.out.println("Using sidewindermod");
                SidewinderMod.on(grid);
                break;
            default:
                System.out.println("Using binarytree (default)");
                BinaryTree.on(grid);
        }
        System.out.print(grid);
    }
}
