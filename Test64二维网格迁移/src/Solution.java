import java.util.ArrayList;
import java.util.List;
//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //进行 k 次移动
        for (;k > 0;k--) {
            //重新定义一个和 grid 一样大的数组;
            int[][] newGrid = new int[grid.length][grid[0].length];
            //1.情况一,把 grid 的第零列给 newGrid 的第一列
            //  把 grid 的的一列给 newGrid 的第二列
            for (int row = 0;row < grid.length;row++) {
                for (int col = 0;col < grid[0].length - 1;col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }
            //2.情况二,newGrid[row][grid[0].length] = grid[row + 1][0];
            for (int row = 0;row < grid.length - 1;row++) {
                newGrid[row + 1][0] = grid[row][grid[0].length - 1];
            }
            //3.情况三,把 gird[grid[0].length][grid[0].length] = newGrid[0][0];
            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];
            grid = newGrid;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            list.add(listRow);
            for (int col : row) {
                listRow.add(col);
            }
        }
        return list;
    }
}
