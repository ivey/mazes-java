package com.gweezlebur.mazes;

import com.gweezlebur.mazes.algo.BinaryTree;
import com.gweezlebur.mazes.algo.BinaryTreeMod;
import com.gweezlebur.mazes.algo.Sidewinder;
import com.gweezlebur.mazes.algo.SidewinderMod;
import com.gweezlebur.mazes.grid.Grid;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.Collection;
import java.util.List;

public class Main {

    private static final int DEFAULT_SIZE = 5;
    private static final String DEFAULT_ALGO = "binarytree";

    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("s","size", true, "Size of the grid - sets (and overrides) X and Y");
        options.addOption("x", "width", true, "Width of the grid");
        options.addOption("y", "height", true, "Height of the grid");
        options.addOption("a", "algorithm", true, "Which algorithm to use");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        cmd = parser.parse( options, args);
        Grid grid;

        if (cmd.hasOption("s")) {
            int size = Integer.parseInt(cmd.getOptionValue("s"));
            grid = new Grid(size);
        } else {
            int x = DEFAULT_SIZE;
            String xs = cmd.getOptionValue("x");
            if (xs != null) {
                x = Integer.parseInt(xs);
            }

            int y = DEFAULT_SIZE;
            String ys = cmd.getOptionValue("y");
            if (ys != null) {
                y = Integer.parseInt(ys);
            }

            grid = new Grid(x,y);
        }

        String algo = cmd.getOptionValue("a");
        if (algo == null) { algo = DEFAULT_ALGO; }

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
                if (algo != DEFAULT_ALGO) {
                    System.out.println("Unknown algorithm");
                }
                System.out.println("Using binarytree (default)");
                BinaryTree.on(grid);
        }
        System.out.print(grid);
    }
}
