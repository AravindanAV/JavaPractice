import java.util.*;

public class Sudoku {
    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(isValidSudoku(sudoku)?"Its a valid matrix":"Its invalid matrix");
    }

    public static boolean isValidSudoku(int[][] arr){
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        int rowIndex=0,colIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            row.put(++rowIndex,new LinkedHashSet<>());
            col.put(++colIndex,new LinkedHashSet<>());
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j]!=0 && !row.get(rowIndex).contains(arr[i][j]) ){
                    row.get(rowIndex).add(arr[i][j]);
                }
                else if(row.get(rowIndex).contains(arr[i][j])) {
                    return false;
                }
                if (arr[j][i]!=0 && !col.get(colIndex).contains(arr[j][i]) ){
                    col.get(colIndex).add(arr[j][i]);
                }
                else if(col.get(colIndex).contains(arr[j][i])) {
                    return false;
                }
            }
        }
        print(row);
        print(col);
        return true;
    }

    public static void print(Map<Integer, Set<Integer>> row){
        row.entrySet().stream().forEach(entry->
        {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
    }
}
