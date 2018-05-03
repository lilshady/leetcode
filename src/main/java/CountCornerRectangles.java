/**
 * Created by lil_shady on 2018/5/3.
 * 853. Number Of Corner Rectangles
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
 * <p>
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle.
 * Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 */

public class CountCornerRectangles {

    public int countCornerRectangles(int[][] grid) {

        if (grid == null) {
            return 0;
        }

        if (grid.length <= 1) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        if (column == 1) {
            return 0;
        }

        return countCornerRectanglesHelper(grid, row, column);
    }

    private int countCornerRectanglesHelper(int[][] grid, int row, int colum) {

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (grid[i][j] == 1) {
                    count += traverse(i, j, row, colum, grid);
                }
            }
        }

        return count;
    }

    private int traverse(int x, int y, int row, int colum, int[][] grid) {

        int count = 0;
        for (int xDelta = 1; x + xDelta < row; xDelta++) {
            for (int yDelta = 1; y + yDelta < colum; yDelta++) {

                int corner = grid[x + xDelta][y + yDelta];
                if (corner == 1 && grid[x + xDelta][y] == 1 && grid[x][y + yDelta] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        CountCornerRectangles test = new CountCornerRectangles();

        System.out.print(test.countCornerRectangles(grid));
    }

}
