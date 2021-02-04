package se.nackademin.day.D3;

import se.nackademin.util.InputProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    private final List<String> input = InputProvider.linesFromInput("3");
    private final char[][] map;

    public Day3() {
        int rows = this.input.size();
        int columns = this.input.get(0).length();
        this.map = new char[rows][columns];
        for (int row = 0; row < this.map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                char[] chars = input.get(row).toCharArray();
                this.map[row][col] = chars[col];
            }
        }
    }

    public void getPart1Result() {
        int right = 3;
        int down = 1;

        int treesEncountered = getTreesEncountered(right, down);
        System.out.println(treesEncountered);
    }


//    Right 1, down 1.
//    Right 3, down 1. (This is the slope you already checked.)
//    Right 5, down 1.
//    Right 7, down 1.
//    Right 1, down 2.
    public void getPart2Result() {
        int n1 = getTreesEncountered(1, 1);
        int n2 = getTreesEncountered(3, 1);
        int n3 = getTreesEncountered(5, 1);
        int n4 = getTreesEncountered(7, 1);
        int n5 = getTreesEncountered(1, 2);

        int sum = n1 * n2 * n3 * n4 * n5;

        System.out.println("Sum is " + sum);
    }

    private int getTreesEncountered(int right, int down) {
        int rowLocation = 0;
        int colLocation = 0;

        int treesEncountered = 0;
        while (rowLocation < this.input.size()) {
            char location = this.map[rowLocation][colLocation];
            if (location == '#')
                treesEncountered++;

            colLocation = (colLocation + right) % 31;
            rowLocation += down;
        }
        return treesEncountered;
    }
}
